package org.example.behavioral.facade;

import lombok.Getter;

public class DVDRom {

    @Getter
    private String data;

    public void loadData(String data) {
        this.data = data;
    }

    public void clean() {
        this.data = null;
    }

    public boolean hasData() {
        return data != null && !data.isEmpty();
    }


}
