/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.IImageMeta;

public class HGameGc implements IImageMeta {
    private String title;
    private String company;
    @SerializedName("getchu_id")
    private String id;

    public String title() {
        return title;
    }

    public String company() {
        return company;
    }

    public String id() {
        return id;
    }
}
