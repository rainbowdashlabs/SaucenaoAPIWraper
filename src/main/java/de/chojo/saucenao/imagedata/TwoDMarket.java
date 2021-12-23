/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class TwoDMarket extends ExternalUrlMeta {
    private String source;
    private String creator;

    public String source() {
        return source;
    }

    public String creator() {
        return creator;
    }
}
