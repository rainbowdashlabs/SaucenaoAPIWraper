package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;
import lombok.Getter;

@Getter
public class Sankaku extends ImageboardMeta {
    @SerializedName("sankaku_id")
    private int id;
}
