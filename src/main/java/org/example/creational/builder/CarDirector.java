package org.example.creational.builder;

public class CarDirector {

    public void constructSportCar(CarBuilder builder) {
        builder.carType("Mega")
                .tripComputer("X10")
                .engine("Tesla engine")
                .gpsNavigator("Goo watch")
                .seats(2)
                .transmission("Manual");
    }

    public void constructFamilyCar(CarBuilder builder) {
        builder.carType("MyFamily")
                .engine("BMW engine")
                .seats(5)
                .transmission("Auto");
    }

}
