/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata.util;

public class ImageboardMeta extends ExternalUrlMeta {
    private String creator;
    private String material;
    private String characters;
    private String source;

    public String creator() {
        return creator;
    }

    public String material() {
        return material;
    }

    public String characters() {
        return characters;
    }

    public String source() {
        return source;
    }
}
