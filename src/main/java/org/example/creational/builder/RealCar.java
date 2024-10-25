package org.example.creational.builder;

import lombok.Builder;

@Builder
public class RealCar {
    private final String carType;
    private final int seats;
    private final String engine;
    private final String transmission;
    private final String tripComputer;
    private final String gpsNavigator;

    public static class RealCarBuilder implements CarBuilder {}

    boolean drive() {
        return true;
    }
}
