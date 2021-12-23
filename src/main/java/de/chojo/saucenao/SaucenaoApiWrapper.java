/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import de.chojo.saucenao.response.ISauceResponse;
import de.chojo.saucenao.response.SauceResponse;
import de.chojo.saucenao.results.IResultEntry;
import de.chojo.saucenao.results.ResultEntry;
import de.chojo.saucenao.results.ResultMeta;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Entry point for api requests. A reusable api wrapper to perform requests against the saucenao api.
 */
public final class SaucenaoApiWrapper {
    private static final Logger log = getLogger(SaucenaoApiWrapper.class);
    private final String request;
    private final HttpClient httpClient;
    private final OkHttpClient okHttpClient;
    private final Gson exposedParser = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private final Gson generalParser = new GsonBuilder().create();

    private SaucenaoApiWrapper(String request) {
        this.request = request;
        httpClient = HttpClient.newHttpClient();
        okHttpClient = null;
    }

    private SaucenaoApiWrapper(OkHttpClient okHttpClient, HttpClient httpClient, String request) {
        this.request = request;
        this.httpClient = httpClient;
        this.okHttpClient = okHttpClient;
    }

    /**
     * Get a new saucenao api wrapper builder.
     *
     * @param key key for api. can be null.
     * @return builder with key
     */
    public static SaucenaoApiWrapperBuilder builder(@Nullable String key) {
        return new SaucenaoApiWrapperBuilder(key);
    }

    /**
     * Get a new saucenao api wrapper builder.
     *
     * @return builder without api key
     */
    public static SaucenaoApiWrapperBuilder builder() {
        return new SaucenaoApiWrapperBuilder();
    }

    /**
     * Requests saucenao based on an image url.
     *
     * @param url url to check
     * @return sauce response.
     */
    public Optional<ISauceResponse> requestImage(String url) {
        var httpResponse = requestSauce(url);
        if (httpResponse.isEmpty()) return Optional.empty();

        // build json element from string
        var jsonResponse = new JsonParser().parse(httpResponse.get());

        // create general response.
        var sauceResponse = exposedParser.fromJson(jsonResponse, SauceResponse.class);

        var sauceResultEntries = parseResults(sauceResponse, jsonResponse);

        sauceResponse.setResults(sauceResultEntries);
        return Optional.of(sauceResponse);
    }

    private Optional<String> requestSauce(String url) {
        String requestUrl;
        try {
            requestUrl = request + URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            log.warn("Could not encode url.", e);
            return Optional.empty();
        }

        if (httpClient != null) {
            HttpRequest request;
            request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .build();

            try {
                return Optional.ofNullable(httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body());
            } catch (IOException | InterruptedException e) {
                return Optional.empty();
            }
        }
        var request = new Request.Builder().url(requestUrl).get().build();
        try (var execute = okHttpClient.newCall(request).execute(); var body = execute.body()) {
            if (body == null) return Optional.empty();
            return Optional.of(body.string());
        } catch (IOException e) {
            log.error("Request failed", e);
            return Optional.empty();
        }
    }

    private List<IResultEntry> parseResults(SauceResponse sauceResponse, JsonElement jsonResponse) {
        var resultJson = jsonResponse.getAsJsonObject().getAsJsonArray("results");

        if (resultJson == null) return Collections.emptyList();

        var results = new ArrayList<IResultEntry>();

        for (var element : resultJson) {
            // build base result object.
            var header = element.getAsJsonObject().get("header");
            var resultMeta = generalParser.fromJson(header, ResultMeta.class);

            var result = new ResultEntry(resultMeta);

            // determine index
            var indexId = result.resultMeta().indexId();
            var index = SauceIndex.getIndex(indexId);
            if (index == SauceIndex.UNKOWN) {
                var parentId = sauceResponse.responseMeta().getParentId(indexId);
                if (parentId.isPresent()) {
                    index = SauceIndex.getIndex(parentId.getAsInt());
                } else {
                    log.info("Index {} with id {} is unknown.", result.resultMeta().indexName(), indexId);
                    continue;
                }
            }

            if (index.getDataClass() == null) {
                log.info("Index {} with id {} has no mapping class.", result.resultMeta().indexName(), indexId);
                continue;
            }

            // Build data object based on index.
            var data = generalParser.fromJson(element.getAsJsonObject().get("data"), index.getDataClass());

            result.data(data);
            results.add(result);
        }
        return results;
    }

    public static final class SaucenaoApiWrapperBuilder {
        private final String key;
        private SauceIndex[] indices;
        private long excludeBitmask;
        private int testmode;
        private int count = 1;
        private HttpClient httpClient;
        private OkHttpClient okHttpClient;

        private SaucenaoApiWrapperBuilder(String key) {
            this.key = key;
        }

        private SaucenaoApiWrapperBuilder() {
            key = null;
        }

        /**
         * Add indices to the wrapper. Will override already set indiced. Default value is {@link SauceIndex#ALL}
         *
         * @param indices indices to use.
         * @return builder with indices set.
         * @throws IllegalArgumentException when flag {@link SauceIndex#ALL} is used with other flags.
         */
        public SaucenaoApiWrapperBuilder withIndices(SauceIndex... indices) throws IllegalArgumentException {
            if (indices.length == 0) {
                throw new IllegalArgumentException("Indices cant be empty");
            }
            this.indices = indices;

            long bitmask = 0;
            for (var index : indices) {
                if (index == SauceIndex.ALL && indices.length != 1) {
                    throw new IllegalArgumentException("ALL index was used with more indices");
                }
                if (index == SauceIndex.ALL) {
                    return this;
                }

                Deprecated deprecated;
                try {
                    deprecated = index.getClass().getField(index.name()).getAnnotation(Deprecated.class);
                } catch (NoSuchFieldException e) {
                    log.error("Error while checking deprecation", e);
                    continue;
                }

                if (deprecated != null) {
                    log.warn("Usage of deprecated index {} detected.", index.name());
                }
            }
            return this;
        }

        /**
         * Exclude indices. Usefull if {@link #withIndices(SauceIndex...)} is set to {@link SauceIndex#ALL}.
         *
         * @param indices indices to exclude
         * @return builder with excluded indices set
         * @throws IllegalArgumentException when flag {@link SauceIndex#ALL} is used
         */
        public SaucenaoApiWrapperBuilder excludeIndices(SauceIndex... indices) throws IllegalArgumentException {
            long bitmask = 0;
            for (var index : indices) {
                bitmask += index.bitmask;
                if (index == SauceIndex.ALL) {
                    throw new IllegalArgumentException("ALL index was used with more indices");
                }
            }

            excludeBitmask = bitmask;
            return this;
        }

        /**
         * Activates the test mode. Causes each index which has a match to output at most 1 for testing. Works best with
         * a {@link #withResultCount(int)} greater than the number of indexes searched.
         *
         * @return builder with testmode activated
         */
        public SaucenaoApiWrapperBuilder inTestMode() {
            testmode = 1;
            return this;
        }

        /**
         * Set the result count. For free account the max result count is 6. For premium accounts the max result count
         * is 60.
         *
         * @param count max result count.
         * @return builder with result count set
         */
        public SaucenaoApiWrapperBuilder withResultCount(int count) {
            this.count = count;
            return this;
        }

        public SaucenaoApiWrapperBuilder withHttpClient(OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
            httpClient = null;
            return this;
        }

        public SaucenaoApiWrapperBuilder withHttpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            okHttpClient = null;
            return this;
        }

        /**
         * Build a api wrapper.
         *
         * @return a new api wrapper object
         */
        public SaucenaoApiWrapper build() {
            var builder = new StringBuilder("https://saucenao.com/search.php?output_type=2");
            if (key != null) {
                builder.append("&api_key=").append(key);
            }
            if (testmode == 1) {
                builder.append("&testmode=").append(testmode);
            }

            // use bitmask if more than one index is required.
            if (indices.length > 1) {
                long bitmask = 0;
                for (var index : indices) {
                    bitmask += index.bitmask;
                }
                builder.append("&dbmask=").append(bitmask);
            } else {
                builder.append("&db=").append(indices[0].index);
            }


            if (excludeBitmask != 0) {
                builder.append("&dbmaski=").append(excludeBitmask);
            }
            builder.append("&numres=").append(count);

            builder.append("&url=");
            if (okHttpClient != null || httpClient != null) {
                return new SaucenaoApiWrapper(okHttpClient, httpClient, builder.toString());

            }

            return new SaucenaoApiWrapper(builder.toString());
        }
    }
}
