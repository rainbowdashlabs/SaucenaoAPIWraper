package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.IImageMeta;

public class HGameGc implements IImageMeta {
    private String title;
    private String company;
    @SerializedName("getchu_id")
    private String id;
}
