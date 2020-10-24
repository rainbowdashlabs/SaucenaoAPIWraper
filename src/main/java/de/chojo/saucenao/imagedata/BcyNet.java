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
}
