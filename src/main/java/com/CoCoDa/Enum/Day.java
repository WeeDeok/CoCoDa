package com.CoCoDa.Enum;

public enum Day {

    MONDAY("MON", "N")
    , TUESDAY("TUE", "N")
    , WENDSDAY("WED", "N")
    , THURSDAY("THU", "N")
    , FRIDAY("FRI", "N")
    , SATURDAY("SAT", "Y")
    , SUNDAY("SUN", "Y");

    private final String day;
    private final String weekendYn;

    Day(String day, String weekendYn) {

        this.day = day;
        this.weekendYn = weekendYn;
        
    }

    public String getDay() {

        return day;

    }

    public String getweekendYn() {

        return weekendYn;

    }

}
