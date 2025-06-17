package com.CoCoDa.util;

import java.util.HashMap;

public class Calculate {
    
    private static final int total = 10;
    private static final String salesScales = "salesScales";
    
    public HashMap<String, Double> getTotalResult(HashMap<String, Double> response) {

        HashMap<String, Double> result = new HashMap<>();

        response.forEach((key, value) -> {

            switch (key) {

                case salesScales : 

                    result.put(salesScales, getSalesScales(value));

                    break;
                
                default : 
                    
                    break;
                
            }

        });

        return result;

    }

    private double getSalesScales (double param) {

        double compare_salesScales = 20.0;
        double result_salesScales = Math.floor(param * total / compare_salesScales);

        if(result_salesScales >= 10){

            result_salesScales = 9;

        }

        return result_salesScales;

    }

}
