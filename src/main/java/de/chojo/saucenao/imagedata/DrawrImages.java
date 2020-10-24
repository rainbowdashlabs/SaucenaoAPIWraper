package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;
import lombok.Getter;

@Getter
public class DrawrImages extends ExternalUrlMeta {
    private String title;
    @SerializedName("drawr_id")
    private int id;
    @SerializedName("member_name")
    private String memberName;
    @SerializedName("member_id")
    private int memberId;
}
