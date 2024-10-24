package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testHello() {
        Main main = new Main();
        String text = main.hello();
        assertEquals(text, "Hello!");
    }
}
