/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.response;

public class IndexData {
    /**
     * status fields are 0 if success, >0 for server side errors (failed descriptor gen, failed query, etc), <0 for
     * client side errors (bad image, out of searches, etc). Not all errors are properly tagged yet, and some may exit
     * the api.
     */
    private int status;
    /**
     * Id of the parent index.
     */
    private int parentId;
    /**
     * Id of the index.
     */
    private int id;
    /**
     * Count of results.
     */
    private final int results = 0;

    public int status() {
        return status;
    }

    public int parentId() {
        return parentId;
    }

    public int id() {
        return id;
    }

    public int results() {
        return results;
    }
}
