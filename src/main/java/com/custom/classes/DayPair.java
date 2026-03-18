package com.custom.classes;

import weather.Period;

public class DayPair {
    public Day day;
    public Day night;

    public DayPair(Period day, Period night) {
        this.day = new Day(day);
        this.night = new Day(night);
    }
}
