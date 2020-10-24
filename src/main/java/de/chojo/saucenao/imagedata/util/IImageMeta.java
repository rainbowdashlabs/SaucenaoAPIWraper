package de.chojo.saucenao.imagedata.util;

public interface IImageMeta {
    @SuppressWarnings("unchecked")
    default <T extends IImageMeta> T getImageData() {
        return (T) this;
    }
}
