package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;
import lombok.Getter;

@Getter
public class Konachan extends ImageboardMeta {
    @SerializedName("konachan_id")
    private int id;
}
