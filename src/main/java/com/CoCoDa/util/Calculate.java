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
                
                case Constant.AVG_GROWTH :

                    result.put(Constant.AVG_GROWTH, getAvgGrowth(value));

                    break;

                case Constant.EXPECT_SALES :

                    result.put(Constant.EXPECT_SALES, getExpectSales(value));

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

    private double getAvgGrowth (double param) {

        double compare_avgGrowth = 2.04;
        double result_avgGrowth = Math.floor(param * Constant.TOTAL_CALC / compare_avgGrowth);

        if(result_avgGrowth >= 10){

            result_avgGrowth = 9;

        }

        return result_avgGrowth;

    }

    private double getExpectSales (double param) {

        double compare_expectSales = 100000000000.00;
        double result_expectSales = Math.floor(param * 5 / compare_expectSales);

        if(result_expectSales >= 5){

            result_expectSales = 4;

        }

        return result_expectSales;

    }

}
