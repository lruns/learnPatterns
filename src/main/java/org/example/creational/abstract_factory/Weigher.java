package org.example.creational.abstract_factory;

import org.example.creational.factory.RomanNumberConverter;

public interface Weigher {
    String weigh(Item item);
}

record Item(String name, int weight){};

class DigitalWeigher implements Weigher{

    @Override
    public String weigh(Item item) {
        return String.valueOf(item.weight());
    }
}

class RomanWeigher implements Weigher {
    @Override
    public String weigh(Item item) {
        return RomanNumberConverter.toRoman(item.weight());
    }
}