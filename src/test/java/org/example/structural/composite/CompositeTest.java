package org.example.structural.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeTest {
    @Test
    public void testComposite() {
        Text text = new Text();
        Image image1 = new Image();
        Image image2 = new Image();

        Composite composite1 = new Composite();
        composite1.addElement(image1);
        composite1.addElement(image2);

        Composite composite2 = new Composite();
        composite2.addElement(text);
        composite2.addElement(composite1);

        String drawResult = composite2.draw();

        assertEquals("textimageimage", drawResult.toLowerCase());

    }
}
