/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class Imdb extends ExternalUrlMeta {
    protected String source;
    @SerializedName("imdb_id")
    protected String id;
    protected String part;
    protected String year;
    @SerializedName("est_time")
    protected String estimatedTime;

    public String source() {
        return source;
    }

    public String id() {
        return id;
    }

    public String part() {
        return part;
    }

    public String year() {
        return year;
    }

    public String estimatedTime() {
        return estimatedTime;
    }
}
