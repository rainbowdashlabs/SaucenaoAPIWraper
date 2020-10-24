package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;
import lombok.Getter;

@Getter
public class E621Net extends ImageboardMeta {
    @SerializedName("e621_id")
    private int id;
}
