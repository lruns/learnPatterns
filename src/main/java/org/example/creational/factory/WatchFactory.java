package org.example.creational.factory;

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
