/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.response;

import de.chojo.saucenao.results.IResultEntry;

import java.util.List;

public interface ISauceResponse {
    /**
     * Get the response meta.
     *
     * @return meta
     */
    ResponseMeta responseMeta();

    /**
     * Get the results of the search
     *
     * @return list of results
     */
    List<IResultEntry> results();
}
