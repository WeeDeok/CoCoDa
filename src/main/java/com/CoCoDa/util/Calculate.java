package com.CoCoDa.util;

import java.util.HashMap;

import com.CoCoDa.Constant.Constant;

public class Calculate {
        
    public HashMap<String, Double> getTotalResult(HashMap<String, Double> response) {

        HashMap<String, Double> result = new HashMap<>();

        response.forEach((key, value) -> {

            switch (key) {

                case Constant.SALES_SCALES : 

                    result.put(Constant.SALES_SCALES, getSalesScales(value));
                    
                    break;
                
                default : 
                    
                    break;
                
            }

        });

        return result;

    }

    private double getSalesScales (double param) {

        double compare_salesScales = 20.0;
        double result_salesScales = Math.floor(param * Constant.TOTAL_CALC / compare_salesScales);

        if(result_salesScales >= 10){

            result_salesScales = 9;

        }

        return result_salesScales;

    }

}
