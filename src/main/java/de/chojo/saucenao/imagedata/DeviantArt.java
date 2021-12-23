/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class DeviantArt extends ExternalUrlMeta {
    private String title;
    @SerializedName("da_id")
    private int id;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("author_url")
    private String authorUrl;

    public String title() {
        return title;
    }

    public int id() {
        return id;
    }

    public String authorName() {
        return authorName;
    }

    public String authorUrl() {
        return authorUrl;
    }
}
