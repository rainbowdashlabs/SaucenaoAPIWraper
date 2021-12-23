/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.OptionalInt;


public class ResponseMeta {
    @SerializedName("user_id")
    @Expose
    private int userId;
    /**
     * Type of the account as int. 0 is premium and 1 is free
     */
    @SerializedName("account_type")
    @Expose
    private int accountType;
    /**
     * The limit of requests in 30 seconds.
     */
    @SerializedName("short_limit")
    @Expose
    private long shortLimit;
    /**
     * The limit of requests in 24 hours.
     */
    @SerializedName("long_limit")
    @Expose
    private long longLimit;
    /**
     * Remaining requests for next 30 seconds.
     */
    @SerializedName("short_remaining")
    @Expose
    private long shortRemaining;
    /**
     * Remaining requests for next 24 hours.
     */
    @SerializedName("long_remaining")
    @Expose
    private long longRemaining;
    /**
     * status fields are 0 if success, >0 for server side errors (failed descriptor gen, failed query, etc), <0 for
     * client side errors (bad image, out of searches, etc). Not all errors are properly tagged yet, and some may exit
     * the api. If the status is not 0. a message should be available in the message field.
     */
    @Expose
    private int status;
    /**
     * Amount of requests results. This will be less than defined in the api wrapper, when the count exceeds the account
     * limit.
     */
    @SerializedName("results_requested")
    @Expose
    private int resultsRequested;
    /**
     * Amount of returned results.
     */
    @SerializedName("results_returned")
    @Expose
    private int resultsReturned;
    /**
     * The minimum similarity returned. If testmode is activated results can be less than this.
     */
    @SerializedName("minimum_similarity")
    @Expose
    private float minimumSimilarity;
    /**
     * Error message, if the request failed.
     */
    @Expose
    private String message;
    /**
     * Status of requested indices.
     */
    @SerializedName("index")
    @Expose
    private Map<String, IndexData> indexData;

    /**
     * Get the parent id of an index.
     *
     * @param id id of child index
     *
     * @return id of parent index.
     */
    public OptionalInt getParentId(int id) {
        var indexData = this.indexData.get(Integer.toString(id));
        if (indexData == null) return OptionalInt.empty();
        return OptionalInt.of(indexData.parentId());
    }

    public int userId() {
        return userId;
    }

    public int accountType() {
        return accountType;
    }

    public long shortLimit() {
        return shortLimit;
    }

    public long longLimit() {
        return longLimit;
    }

    public long shortRemaining() {
        return shortRemaining;
    }

    public long longRemaining() {
        return longRemaining;
    }

    public int status() {
        return status;
    }

    public int resultsRequested() {
        return resultsRequested;
    }

    public int resultsReturned() {
        return resultsReturned;
    }

    public float minimumSimilarity() {
        return minimumSimilarity;
    }

    public String message() {
        return message;
    }

    public Map<String, IndexData> indexData() {
        return indexData;
    }
}
