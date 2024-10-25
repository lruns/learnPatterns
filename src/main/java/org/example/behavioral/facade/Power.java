package org.example.behavioral.facade;

import lombok.Getter;

public class Power {

    @Getter
    private boolean isPowered = false;

    public void on() {
        isPowered = true;
    }

    public void off() {
        isPowered = false;
    }
}
