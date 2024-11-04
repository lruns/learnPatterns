package org.example.behavioral.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class RadioStationTest {
    @Test
    public void test() {
        RadioStation station = new RadioStation(new Radio7());
        assertEquals("Радио на семи холмах!", station.play());
        station.nextStation();
        station.nextStation();
        assertEquals("Слушайте классику с нами!", station.play());
        station.nextStation();
        station.nextStation();
        assertEquals("С вами снова радио фм! А теперь классика!", station.play());
        assertInstanceOf(RadioClassic.class, station.current);
    }
}
