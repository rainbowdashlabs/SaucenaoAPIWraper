/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;

public class Konachan extends ImageboardMeta {
    @SerializedName("konachan_id")
    private int id;

    public int id() {
        return id;
    }
}
