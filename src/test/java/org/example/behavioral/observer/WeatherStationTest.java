package org.example.behavioral.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStationTest {

    @Test
    public void test() {
        WeatherStation station = new WeatherStation();
        DangerTracker dangerTracker = new DangerTracker();
        GoodWalkingDayTracker goodDayTracker = new GoodWalkingDayTracker();

        station.addObserver(dangerTracker);
        station.addObserver(goodDayTracker);

        station.makeMeasurements(20, 50);

        assertFalse(dangerTracker.isDanger());
        assertFalse(goodDayTracker.isLetsWalk());

        station.notifyObservers();

        assertFalse(dangerTracker.isDanger());
        assertTrue(goodDayTracker.isLetsWalk());

        station.makeMeasurements(10, 100);
        station.notifyObservers();

        assertTrue(dangerTracker.isDanger());
        assertFalse(goodDayTracker.isLetsWalk());
    }
}
