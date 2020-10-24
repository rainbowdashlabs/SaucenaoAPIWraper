package de.chojo.saucenao.imagedata;

import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.ImageboardMeta;
import lombok.Getter;

/**
 * Will most likely contain results from danbooru and gelbooru. {@link ImageboardMeta#externalUrls} will contain two
 * urls in this case.
 */
@Getter
public class Danbooru extends ImageboardMeta {
    @SerializedName("danbooru_id")
    private int id;
}
