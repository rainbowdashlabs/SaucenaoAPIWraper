/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class MangaDex extends ExternalUrlMeta {
    @SerializedName("md_id")
    private int id;
    private String source;
    private String part;
    private String artist;
    private String author;

    public int id() {
        return id;
    }

    public String source() {
        return source;
    }

    public String part() {
        return part;
    }

    public String artist() {
        return artist;
    }

    public String author() {
        return author;
    }
}
