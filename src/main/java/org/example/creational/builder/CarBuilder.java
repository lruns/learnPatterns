package org.example.creational.builder;

public interface CarBuilder {
    CarBuilder carType(String type);
    CarBuilder seats(int seats);
    CarBuilder engine(String engine);
    CarBuilder transmission(String transmission);
    CarBuilder tripComputer(String tripComputer);
    CarBuilder gpsNavigator(String gpsNavigator);
}
