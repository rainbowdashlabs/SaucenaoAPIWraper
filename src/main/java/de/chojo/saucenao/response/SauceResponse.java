/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.results.IResultEntry;

import java.util.ArrayList;
import java.util.List;

public class SauceResponse implements ISauceResponse {
    @Expose(serialize = false)
    private final List<IResultEntry> results = new ArrayList<>();
    @SerializedName("header")
    @Expose
    private ResponseMeta responseMeta;

    public void setResults(List<IResultEntry> results) {
        this.results.clear();
        this.results.addAll(results);
    }

    public List<IResultEntry> results() {
        return results;
    }

    public ResponseMeta responseMeta() {
        return responseMeta;
    }
}
