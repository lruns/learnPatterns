package org.example.structural.bridge;

public abstract class Car {
    Maker maker;

    public Car(Maker maker) {
        this.maker = maker;
    }

    public String getDescription() {
        return STR."\{getName()}:\{maker.getName()}";
    }

    abstract String getName();
}


class Sedan extends Car {

    public Sedan(Maker maker) {
        super(maker);
    }

    @Override
    String getName() {
        return "Sedan";
    }
}

class Hatchback extends Car {

    public Hatchback(Maker maker) {
        super(maker);
    }

    @Override
    String getName() {
        return "Hatchback";
    }
}

interface Maker {
    String getName();
}

class KiaMaker implements Maker {

    @Override
    public String getName() {
        return "Kia";
    }
}

class RioMaker implements Maker {

    @Override
    public String getName() {
        return "Rio";
    }
}