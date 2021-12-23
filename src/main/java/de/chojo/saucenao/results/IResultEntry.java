/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.results;

import de.chojo.saucenao.imagedata.util.IImageMeta;

public interface IResultEntry {
    /**
     * Get the meta of the current result.
     *
     * @return meta
     */
    ResultMeta resultMeta();

    /**
     * Get the image data of the result.
     *
     * @return image data
     */
    IImageMeta data();
}
