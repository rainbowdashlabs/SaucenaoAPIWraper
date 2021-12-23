/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata.util;

public interface IImageMeta {
    @SuppressWarnings("unchecked")
    default <T extends IImageMeta> T getImageData() {
        return (T) this;
    }
}
