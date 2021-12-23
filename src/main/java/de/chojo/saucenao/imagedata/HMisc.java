/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.IImageMeta;

public class HMisc implements IImageMeta {
    private String source;
    private String[] creator;
    @SerializedName("eng_name")
    private String engName;
    @SerializedName("jp_name")
    private String jpName;

    public String source() {
        return source;
    }

    public String[] creator() {
        return creator;
    }

    public String engName() {
        return engName;
    }

    public String jpName() {
        return jpName;
    }
}
