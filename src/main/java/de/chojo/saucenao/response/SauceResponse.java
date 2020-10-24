package de.chojo.saucenao.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import de.chojo.saucenao.results.IResultEntry;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SauceResponse implements ISauceResponse {
    @Expose(serialize = false)
    private final List<IResultEntry> results = new ArrayList<>();
    @SerializedName("header")
    @Expose
    private ResponseMeta responseMeta;

    public void setResults(List<IResultEntry> results) {
        this.results.clear();
        this.results.addAll(results);
    }
}
