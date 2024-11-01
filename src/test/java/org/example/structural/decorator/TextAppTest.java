package org.example.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAppTest {
    @Test
    public void testTextApp() {
        Texter texter = new Texter("Hello, World!");

        var transformed = new BracketDecorator(new QuoteDecorator(texter));

        assertEquals(transformed.print(), "{'Hello, World!'}");
    }
}
