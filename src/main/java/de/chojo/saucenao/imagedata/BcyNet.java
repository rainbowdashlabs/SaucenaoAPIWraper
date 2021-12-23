/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class BcyNet extends ExternalUrlMeta {
    private String title;
    @SerializedName("bcy_id")
    private int id;
    @SerializedName("member_name")
    private String memberName;
    @SerializedName("member_id")
    private String memberId;
    @SerializedName("member_link_id")
    private String memberLinkId;
    @SerializedName("bcy_type")
    private String bcyType;

    public String title() {
        return title;
    }

    public int id() {
        return id;
    }

    public String memberName() {
        return memberName;
    }

    public String memberId() {
        return memberId;
    }

    public String memberLinkId() {
        return memberLinkId;
    }

    public String bcyType() {
        return bcyType;
    }
}
