package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ExternalUrlMeta;
import lombok.Getter;

@Getter
public class Anime extends ExternalUrlMeta {
    private String source;
    @SerializedName("anidb_aid")
    private int id;
    private String part;
    private String year;
    @SerializedName("est_time")
    private String estimatedTime;
}
