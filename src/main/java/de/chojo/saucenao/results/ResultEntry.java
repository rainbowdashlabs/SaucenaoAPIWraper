/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.IImageMeta;

public class ResultEntry implements IResultEntry {
    @SerializedName("header")
    private final ResultMeta resultMeta;
    @Expose(deserialize = false)
    private IImageMeta data;

    public ResultEntry(ResultMeta resultMeta) {
        this.resultMeta = resultMeta;
    }

    public void data(IImageMeta data) {
        this.data = data;
    }

    public ResultMeta resultMeta() {
        return resultMeta;
    }

    public IImageMeta data() {
        return data;
    }
}
