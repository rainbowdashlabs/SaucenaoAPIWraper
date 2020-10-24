package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.IImageMeta;
import lombok.Getter;

@Getter
public class HMisc implements IImageMeta {
    private String source;
    private String[] creator;
    @SerializedName("eng_name")
    private String engName;
    @SerializedName("jp_name")
    private String jpName;
}
