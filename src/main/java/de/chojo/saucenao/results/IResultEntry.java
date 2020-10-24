package de.chojo.saucenao.results;

import de.chojo.saucenao.imagedata.util.IImageMeta;

public interface IResultEntry {
    /**
     * Get the meta of the current result.
     *
     * @return meta
     */
    ResultMeta getResultMeta();

    /**
     * Get the image data of the result.
     *
     * @return image data
     */
    IImageMeta getData();
}
