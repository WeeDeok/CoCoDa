package com.CoCoDa.Enum;

public enum Day {

    MONDAY("MON"), TUESDAY("TUE"), WENDSDAY("WED"), THURSDAY("THU"), FRIDAY("FRI"), SATURDAY("SAT"), SUNDAY("SUN");

    private final String day;

    Day(String day) {
        this.day = day;
    }

    public String getDay() {

        return day;

    }

}
