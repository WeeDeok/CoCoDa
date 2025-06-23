package com.CoCoDa.Enum;

public enum DangerGrade {
    
    NOTRECOMMEND(0, "#FF0000")
    , HIGH(0.1, "#FF6E00")
    , NORMAL(0.3, "#FFFF00")
    , LOW(0.5, "#2AFF00")
    , RECOMMAND(1, "#002EFF");

    private final double rate;
    private final String colorHex;

    DangerGrade(double rate, String colorHex) {

        this.rate = rate;
        this.colorHex = colorHex;

    }

    public double getRate() {

        return rate;

    }

    public String getColorHex() {

        return colorHex;

    }

}