package org.example.structural.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComputerTest {

    @Test
    public void testCopying() {
        String testData = "Some data";

        Computer computer = new Computer(testData);
        computer.copy();

        assertEquals(computer.getHdd().getData(), "Some data");
    }

    @Test
    public void testFailingComputing() {
        Computer computer = new Computer("");

        assertThrows(IllegalArgumentException.class, computer::copy);
    }
}
