package org.example.creational.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest {

    @Test
    void checkThatItIsSingleton() {
        Database db = Database.getInstance("Test1");
        Database db2 = Database.getInstance("Test2");
        assertEquals(db.testValue, db2.testValue);
        assertEquals(db2.testValue, "Test1");
    }

    @Test
    void checkSqlWork() {
        String sqlCommand = "select * from";
        Database db = Database.getInstance("");
        String answer = db.query(sqlCommand);
        System.out.println(answer);
        assertTrue(answer.contains(sqlCommand));
    }

    @RepeatedTest(10)
    void testMultithreading() throws InterruptedException {
        AtomicReference<String> message1 = new AtomicReference<>();
        AtomicReference<String> message2 = new AtomicReference<>();
        Thread threadFoo = new Thread(() -> {
            Database singleton = Database.getInstance("FOO");
            message1.set(singleton.testValue);
            System.out.println(message1.get());
        });
        Thread threadBar = new Thread(() -> {
            Database singleton = Database.getInstance("BAR");
            message2.set(singleton.testValue);
            System.out.println(message2.get());
        });

        threadFoo.start();
        threadBar.start();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                    assertEquals(message1.get(), message2.get());
            }
        }, 10);
    }
}