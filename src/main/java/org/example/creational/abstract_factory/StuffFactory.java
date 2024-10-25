package org.example.creational.abstract_factory;

import org.example.creational.factory.watch.DigitalWatch;
import org.example.creational.factory.watch.RomanWatch;
import org.example.creational.factory.watch.Watch;

public interface StuffFactory {
    Weigher getWeigher();
    Watch getWatch();

    static StuffFactory getStuffFactory(String type) {
        return switch (type) {
            case "Roman" -> new RomanStuffFactory();
            case "Digital" -> new DigitalStuffFactory();
            default -> throw new IllegalArgumentException(STR."Unknown StuffFactory type: \{type}");
        };
    }
}

class RomanStuffFactory implements StuffFactory {
    @Override
    public Weigher getWeigher() {
        return new RomanWeigher();
    }

    @Override
    public Watch getWatch() {
        return new RomanWatch();
    }
}

class DigitalStuffFactory implements StuffFactory {
    @Override
    public Weigher getWeigher() {
        return new DigitalWeigher();
    }

    @Override
    public Watch getWatch() {
        return new DigitalWatch();
    }
}

