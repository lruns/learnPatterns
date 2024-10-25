package org.example.behavioral.facade;

import lombok.Getter;

public class HDD {
    @Getter
    private String data;

    void copyFromDVD(DVDRom dvd) throws IllegalArgumentException {
        if (dvd.hasData()) {
           data = dvd.getData();
        } else {
            throw new IllegalArgumentException("DVD has no data");
        }
    }
}
