package com.custom.classes;

import weather.Period;

public class Day {
    public String name;
    public String desc;
    public int temp;
    public int precip;
    public String windHigh;
    public String windLow;
    public String windDir;
    public boolean windRange;

    public Day(Period now) {
        String[] windArr = now.windSpeed.split(" ");
        if (windArr.length > 2) {
            windRange = true;
            windHigh = windArr[2];
            windLow = windArr[0];
        }
        else {
            windRange = false;
            windHigh = windArr[0];
            windLow = windHigh;
        }

        this.name = now.name;
        this.desc = now.shortForecast;
        this.temp = now.temperature;
        this.precip = now.probabilityOfPrecipitation.value;
        this.windDir = now.windDirection;
    }
}
