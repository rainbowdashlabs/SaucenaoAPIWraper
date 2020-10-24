package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;
import lombok.Getter;

@Getter
public class YandeRe extends ImageboardMeta {
    @SerializedName("yandere_id")
    private int id;
}
