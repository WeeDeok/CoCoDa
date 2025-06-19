package com.CoCoDa.service;

import java.util.HashMap;

import com.CoCoDa.Constant.Constant;

public class Calculate {
        
    public HashMap<String, Double> getTotalResult(HashMap<String, Double> response) {

        HashMap<String, Double> result = new HashMap<>();

        double compare_salesScales = 0.00;
        double compare_avgGrowth = 0.00;
        double compare_expectSales = 0.00;

        response.forEach((key, value) -> {

            switch (key) {

                case Constant.SALES_SCALES : 

                    result.put(Constant.SALES_SCALES, getSalesScales(value, compare_salesScales));
                    
                    break;
                
                case Constant.AVG_GROWTH :

                    result.put(Constant.AVG_GROWTH, getAvgGrowth(value, compare_avgGrowth));

                    break;

                case Constant.EXPECT_SALES :

                    result.put(Constant.EXPECT_SALES, getExpectSales(value, compare_expectSales));

                    break;

                default :  
                    
                    break;
                
            }

        });

        return result;

    }

    private double getSalesScales (double param, double compare_salesScales) {

        if (Double.isNaN(compare_salesScales) || compare_salesScales == 0) compare_salesScales = 20.0;

        double result_salesScales = Math.floor(param * Constant.TOTAL_CALC / compare_salesScales);

        if(result_salesScales >= 10){

            result_salesScales = 9;

        }

        return result_salesScales;

    }

    private double getAvgGrowth (double param, double compare_avgGrowth) {

        if (Double.isNaN(compare_avgGrowth) || compare_avgGrowth == 0) compare_avgGrowth = 2.04;

        double result_avgGrowth = Math.floor(param * Constant.TOTAL_CALC / compare_avgGrowth);

        if(result_avgGrowth >= 10){

            result_avgGrowth = 9;

        }

        return result_avgGrowth;

    }

    private double getExpectSales (double param, double compare_expectSales) {

        if (Double.isNaN(compare_expectSales) || compare_expectSales == 0) compare_expectSales = 100000000000.00;

        double result_expectSales = Math.floor(param * 5 / compare_expectSales);

        if(result_expectSales >= 5){

            result_expectSales = 4;

        }

        return result_expectSales;

    }

}
