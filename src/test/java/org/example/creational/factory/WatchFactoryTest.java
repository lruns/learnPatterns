package org.example.creational.factory;

import org.junit.jupiter.api.Test;

import static org.example.creational.factory.WatchFactory.getWatchFactory;
import static org.junit.jupiter.api.Assertions.*;

public class WatchFactoryTest {

    public String getTime(String watchName) {
        WatchFactory factory = getWatchFactory(watchName);

        Watch watch = factory.createWatch();
        watch.setTime(19, 5);

        return watch.showTime();
    }

    @Test
    public void testWatch() {
        assertAll(
                () ->   assertEquals(getTime("Roman"), "XIX:V"),
                () ->   assertEquals(getTime("Digital"), "19:05"),
                () ->   assertThrows(RuntimeException.class, () -> getTime("sfasfasf"))
        );

    }
}
