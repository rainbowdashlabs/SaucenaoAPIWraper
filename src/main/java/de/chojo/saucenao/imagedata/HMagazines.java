/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;


import de.chojo.saucenao.imagedata.util.IImageMeta;

public class HMagazines implements IImageMeta {
    private String title;
    private String part;
    private String date;

    public String title() {
        return title;
    }

    public String part() {
        return part;
    }

    public String date() {
        return date;
    }
}
