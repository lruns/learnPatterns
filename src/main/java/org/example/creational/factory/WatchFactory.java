package org.example.creational.factory;

import org.example.creational.factory.watch.DigitalWatch;
import org.example.creational.factory.watch.RomanWatch;
import org.example.creational.factory.watch.Watch;

public interface WatchFactory {
    Watch createWatch();

    static WatchFactory getWatchFactory(String name) {
        return switch (name) {
            case "Roman" -> new RomanWatchFactory();
            case "Digital" -> new DigitalWatchFactory();
            default -> throw new RuntimeException(STR."Unknown watch name: \{name}");
        };
    }
}

class DigitalWatchFactory implements WatchFactory {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomanWatchFactory implements WatchFactory {

    @Override
    public Watch createWatch() {
        return new RomanWatch();
    }
}
