/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata.util;

import com.google.gson.annotations.SerializedName;

public class ExternalUrlMeta implements IImageMeta {
    @SerializedName("ext_urls")
    private String[] externalUrls;

    public String[] externalUrls() {
        return externalUrls;
    }
}
