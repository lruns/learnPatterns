package org.example.creational.factory.watch;

import org.example.creational.factory.RomanNumberConverter;

public class RomanWatch extends AbstractWatch {
    @Override
    public String showTime() {
        int hour = time.getHour();
        int minute = time.getMinute();
        return STR."\{RomanNumberConverter.toRoman(hour)}:\{RomanNumberConverter.toRoman(minute)}";
    }
}

