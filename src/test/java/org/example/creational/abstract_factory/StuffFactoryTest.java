package org.example.creational.abstract_factory;

import org.example.creational.factory.watch.Watch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.example.creational.abstract_factory.StuffFactory.getStuffFactory;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StuffFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Roman, V:XII, VI",
            "Digital, 05:12, 6"
    })
    public void testFactory(String type, String outputTime, String outputWeight) {
        StuffFactory factory = getStuffFactory(type);

        Watch watch = factory.getWatch();
        watch.setTime(5, 12);

        Weigher weigher = factory.getWeigher();
        String weight = weigher.weigh(new Item("Water balloon", 6));

        assertAll(
                () -> assertEquals(watch.showTime(), outputTime),
                () -> assertEquals(weight, outputWeight)
        );
    }
}
