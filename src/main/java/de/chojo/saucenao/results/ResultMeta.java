/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.results;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.SauceIndex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultMeta {
    private static final Pattern INDEX_NAME_PATTERN = Pattern.compile("(Index #[0-9]{1,3}:\\s.+?)\\s-");

    private double similarity;
    private String thumbnail;
    @SerializedName("index_id")
    private int indexId;
    @SerializedName("index_name")
    private String indexName;

    public String strippedIndexName() {
        var matcher = INDEX_NAME_PATTERN.matcher(indexName);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return indexName;
    }

    public SauceIndex getIndex() {
        return SauceIndex.getIndex(indexId);
    }

    public double similarity() {
        return similarity;
    }

    public void similarity(double similarity) {
        this.similarity = similarity;
    }

    public String thumbnail() {
        return thumbnail;
    }

    public void thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String indexName() {
        return indexName;
    }

    public void indexName(String indexName) {
        this.indexName = indexName;
    }

    public int indexId() {
        return indexId;
    }
}
