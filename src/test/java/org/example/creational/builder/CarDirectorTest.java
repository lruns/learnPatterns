package org.example.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarDirectorTest {

    @Test
    public void testCarDirector() {
        CarDirector director = new CarDirector();

        var manualBuilder = new CarManual.CarManualBuilder();
        var carBuilder = new RealCar.RealCarBuilder();

        director.constructFamilyCar(manualBuilder);
        var manual = manualBuilder.build();

        director.constructFamilyCar(carBuilder);
        var car = carBuilder.build();

        assertTrue(manual.report().contains("Family"));

        assertTrue(car.drive());
    }
}
