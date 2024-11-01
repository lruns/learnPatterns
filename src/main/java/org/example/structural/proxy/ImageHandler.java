package org.example.structural.proxy;

public interface ImageHandler {
    String downloadImage();
}

class RealImageHandler implements ImageHandler {

    private String path;

    public RealImageHandler(String path) {
        this.path = path;
    }

    @Override
    public String downloadImage() {
        return "Image bitcode";
    }
}

class ImageHandlerProxy implements ImageHandler {

    private String path;
    private String cachedImage = null;
    protected ImageHandler imageHandler;

    public ImageHandlerProxy(String path) {
        this.path = path;
    }

    @Override
    public String downloadImage() {
        if (imageHandler == null) {
            imageHandler = new RealImageHandler(path);
            cachedImage = imageHandler.downloadImage();
        }

        return cachedImage;
    }
}