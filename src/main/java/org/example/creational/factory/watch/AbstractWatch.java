package org.example.creational.factory.watch;

import java.time.LocalTime;

public abstract class AbstractWatch implements Watch {

    LocalTime time = LocalTime.now();

    @Override
    public void setTime(int hour, int minute) {
        time = LocalTime.of(hour, minute);
    }
}
