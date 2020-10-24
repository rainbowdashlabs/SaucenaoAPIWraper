package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;
import lombok.Getter;

@Getter
public class NijieImages extends ExternalUrlMeta {
    private String title;
    @SerializedName("nijie_id")
    private int id;
    @SerializedName("member_name")
    private String memberName;
    @SerializedName("member_id")
    private int memberId;
}
