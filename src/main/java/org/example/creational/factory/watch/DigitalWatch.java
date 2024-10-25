package org.example.creational.factory.watch;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DigitalWatch extends AbstractWatch {
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("HH:mm").toFormatter();

    @Override
    public String showTime() {
        return time.format(formatter).toLowerCase();
    }

}
