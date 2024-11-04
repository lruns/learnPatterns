package org.example.behavioral.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class Data {
    int temperature;
    int humidity;
}

interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void handleEvent(Data data);
}

public class WeatherStation implements Observed {

    public List<Observer> observers = new ArrayList<Observer>();

    private final Data data = new Data(0, 0);

    public void makeMeasurements(int temperature, int humidity) {
        data.temperature = temperature;
        data.humidity = humidity;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(data);
        }
    }
}


class DangerTracker implements Observer {

    @Getter
    private boolean danger = false;

    @Override
    public void handleEvent(Data data) {
        danger = data.humidity < 10 || data.humidity > 90
            || data.temperature < -20 || data.temperature > 30;
    }
}

class GoodWalkingDayTracker implements Observer {

    @Getter
    private boolean letsWalk = false;

    @Override
    public void handleEvent(Data data) {
        letsWalk = data.temperature > 15 && data.temperature < 30;
    }
}