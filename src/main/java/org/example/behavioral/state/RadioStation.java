package org.example.behavioral.state;

import lombok.AllArgsConstructor;

// Context
public class RadioStation {
    Station current;

    public RadioStation(Station current) {
        this.current = current;
    }

    void nextStation() {
        if (current instanceof Radio7) {
            this.current = new RadioFM(this);
        } else if (current instanceof RadioFM) {
            this.current = new RadioClassic();
        } else if (current instanceof RadioClassic) {
            this.current = new Radio7();
        }
    }

    String play() {
        return current.play();
    }


}

// State
interface Station {
    String play();
}

class Radio7 implements Station {
    @Override
    public String play() {
        return "Радио на семи холмах!";
    }
}

@AllArgsConstructor
class RadioFM implements Station {
    private RadioStation context;

    @Override
    public String play() {
        context.nextStation();
        return "С вами снова радио фм! А теперь классика!";
    }
}

class RadioClassic implements Station {

    @Override
    public String play() {
        return "Слушайте классику с нами!";
    }
}