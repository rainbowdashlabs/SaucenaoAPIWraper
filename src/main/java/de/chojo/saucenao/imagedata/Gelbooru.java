package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;
import lombok.Getter;

@Getter
public class Gelbooru extends ImageboardMeta {
    @SerializedName("gelbooru_id")
    private int id;
}
