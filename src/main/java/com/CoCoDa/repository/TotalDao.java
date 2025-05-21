package com.CoCoDa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.CoCoDa.mapper.TotalMapper;

@Repository
public class TotalDao {

    private TotalMapper mapper;

    // 매출 정보
    public Map<String, Object> SalesInfo(String sigungu_cd) {
        Map<String, Object> result = mapper.SalesInfo(sigungu_cd);
        System.out.println("결과값 : " + result);
        return result;
    }

    // 성장성

    // 월별 매출 증감률 (10, 9, 8, 7)
    public ArrayList<Long> MonthSales(String sigungu_cd) {
        ArrayList<Long> result = mapper.MonthSales(sigungu_cd);
        System.out.println(result);
        return result;
    }

    // 전체 매출 규모
    public long TotalSales() {
        return mapper.TotalSales();
    }

    // 안정성

    // 매출 변동성
    public ArrayList<Integer> Variation(String sigungu_cd) {
        return mapper.Variation(sigungu_cd);
    }

    // 운영연수
    public int OperationYear(String sigungu_cd, String sales_divison_s_cd) {
        Map<String, Object> param = new HashMap<>();
        param.put("sales_divison_s_cd", sales_divison_s_cd);
        param.put("sigungu_cd", sigungu_cd);
        return mapper.OperationYear(param);
    }

    // 매출 변동률
    public ArrayList<Long> SalesVariation(String sigungu_cd, String sales_divison_s_cd) {
        Map<String, String> param = new HashMap<>();
        param.put("sales_divison_s_cd", sales_divison_s_cd);
        param.put("sigungu_cd", sigungu_cd);
        return mapper.SalesVariation(param);
    }

    // 집객력

    // 유동 인구
    public double FloatPopulation(String sigungu_cd) {
        return mapper.FloatPopulation(sigungu_cd);
    }

    // 주거 인구
    public double StayPopulation(String sigungu_cd) {
        return mapper.StayPopulation(sigungu_cd);
    }

    // 직장 인구
    public double WorkerPopulation(String sigungu_cd) {
        return mapper.WorkerPopulation(sigungu_cd);
    }

    // 구매력

    // 건당 결제 금액
    public int cntPrice(String sigungu_cd) {
        return mapper.cntPrice(sigungu_cd);
    }

    // 소비 수준
    public int incomeLevel(String sigungu_cd) {
        return mapper.incomeLevel(sigungu_cd);
    }
}
