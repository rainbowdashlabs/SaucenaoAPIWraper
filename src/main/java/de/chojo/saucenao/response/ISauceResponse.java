package de.chojo.saucenao.response;

import de.chojo.saucenao.results.IResultEntry;

import java.util.List;

public interface ISauceResponse {
    /**
     * Get the response meta.
     *
     * @return meta
     */
    ResponseMeta getResponseMeta();

    /**
     * Get the results of the search
     *
     * @return list of results
     */
    List<IResultEntry> getResults();
}
