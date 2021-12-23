/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;

/**
 * Will most likely contain results from danbooru and gelbooru. {@link ImageboardMeta#externalUrls()} will contain two
 * urls in this case.
 */
public class Danbooru extends ImageboardMeta {
    @SerializedName("danbooru_id")
    private int id;

    public int id() {
        return id;
    }
}
