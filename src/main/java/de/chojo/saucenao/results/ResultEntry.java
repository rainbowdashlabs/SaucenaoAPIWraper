package de.chojo.saucenao.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.imagedata.util.IImageMeta;
import lombok.Getter;

@Getter
public class ResultEntry implements IResultEntry {
    @SerializedName("header")
    private final ResultMeta resultMeta;
    @Expose(deserialize = false)
    private IImageMeta data;

    public ResultEntry(ResultMeta resultMeta) {
        this.resultMeta = resultMeta;
    }

    public void setData(IImageMeta data) {
        this.data = data;
    }
}
