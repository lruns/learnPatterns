package org.example.structural.proxy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ImageHandlerTest {
    @Test
    public void test() {
        ImageHandlerProxy proxy = new ImageHandlerProxy("test path");

        assertNull(proxy.imageHandler);

        String image = proxy.downloadImage();
        assertEquals(image, "Image bitcode");

        assertNotNull(proxy.imageHandler);

        ImageHandler spied = Mockito.spy(proxy.imageHandler);
        proxy.downloadImage();
        verify(spied, never()).downloadImage();
    }
}
