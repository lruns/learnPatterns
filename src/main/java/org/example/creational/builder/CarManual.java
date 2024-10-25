package org.example.creational.builder;

import lombok.Builder;

@Builder()
public class CarManual {
    private final String carType;
    private final int seats;
    private final String engine;
    private final String transmission;
    private final String tripComputer;
    private final String gpsNavigator;

    public static class CarManualBuilder implements CarBuilder {}

    String report() {
        return STR."It is \{carType} with \{seats} seats. Powered by \{engine}.\n" +
                STR."Have transmission \{transmission} and \{tripComputer} with \{gpsNavigator}.";
    }
}
