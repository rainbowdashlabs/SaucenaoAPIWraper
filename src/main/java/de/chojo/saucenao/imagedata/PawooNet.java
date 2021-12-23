/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class PawooNet extends ExternalUrlMeta {
    private String createdAt;
    private int id;
    /**
     * Accountname of user.
     */
    @SerializedName("pawoo_user_acct")
    private String pawooUser;
    /**
     * Username of user.
     */
    @SerializedName("pawoo_user_username")
    private String pawooUsername;
    /**
     * Displayname of user.
     */
    @SerializedName("pawoo_user_display_name")
    private String pawooDisplayname;

    public String createdAt() {
        return createdAt;
    }

    public int id() {
        return id;
    }

    public String pawooUser() {
        return pawooUser;
    }

    public String pawooUsername() {
        return pawooUsername;
    }

    public String pawooDisplayname() {
        return pawooDisplayname;
    }
}
