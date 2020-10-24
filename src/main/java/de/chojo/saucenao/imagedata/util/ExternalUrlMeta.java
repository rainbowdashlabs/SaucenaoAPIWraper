package de.chojo.saucenao.imagedata.util;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public abstract class ExternalUrlMeta implements IImageMeta {
    @SerializedName("ext_urls")
    private String[] externalUrls;
}
