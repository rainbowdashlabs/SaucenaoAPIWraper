package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;
import lombok.Getter;

@Getter
public class MangaDex extends ExternalUrlMeta {
    @SerializedName("md_id")
    private int id;
    private String source;
    private String part;
    private String artist;
    private String author;
}
