/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import de.chojo.saucenao.imagedata.util.IImageMeta;

public class Madokami implements IImageMeta {
    private String source;
    private String part;
    private String type;

    public String source() {
        return source;
    }

    public String part() {
        return part;
    }

    public String type() {
        return type;
    }
}
