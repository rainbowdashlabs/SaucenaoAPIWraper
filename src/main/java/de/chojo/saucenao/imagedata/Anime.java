/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class Anime extends ExternalUrlMeta {
    private String source;
    @SerializedName("anidb_aid")
    private int id;
    private String part;
    private String year;
    @SerializedName("est_time")
    private String estimatedTime;

    public String source() {
        return source;
    }

    public int id() {
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
