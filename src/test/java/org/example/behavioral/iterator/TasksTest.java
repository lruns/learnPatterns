package org.example.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {

    @Test
    public void test() {
        Tasks tm = new Tasks();
        Iterator iterator = tm.getIterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            String task = (String) iterator.next();
            result.append(task);
            result.append(" ");
        }


        assertEquals("Task1 Task2 Task3 ", result.toString());
    }


}
