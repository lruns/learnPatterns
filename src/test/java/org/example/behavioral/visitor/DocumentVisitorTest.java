package org.example.behavioral.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentVisitorTest {

    @Test
    public void test() {
        DocumentVisitorHTML visitor = new DocumentVisitorHTML();
        Letter letter = new Letter("Violeta", "Hollth", "Lets go for a walk!");
        String html = letter.accept(visitor);
        String expected = """
                <h1>Lets go for a walk!</h1>
                <p>Violeta</p>
                <p>Hollth</p>
                """;
        assertEquals(expected, html);
    }
}
