package org.example.behavioral.facade;

import lombok.Getter;

// Facade
public class Computer {

    Power power = new Power();
    DVDRom dvd = new DVDRom();
    @Getter
    HDD hdd = new HDD();

    public Computer(String testData) {
        dvd.loadData(testData);
    }

    public void copy() {
        power.on();
        hdd.copyFromDVD(dvd);
    }
}
