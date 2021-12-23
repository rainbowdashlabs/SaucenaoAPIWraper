/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2021 RainbowDashLabs and Contributor
 */

package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;

public class MediBang extends ExternalUrlMeta {
    private String title;
    private String url;
    @SerializedName("member_name")
    private String memberName;
    @SerializedName("member_id")
    private int memberId;

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }

    public String memberName() {
        return memberName;
    }

    public int memberId() {
        return memberId;
    }
}
