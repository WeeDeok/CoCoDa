package com.CoCoDa.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface TotalMapper {

		Map<String, Object> SalesInfo(String sigungu_cd);
		
		// 성장성
				// 월별 증감률
				public ArrayList<Long> MonthSales(String sigungu_cd);
			
				// 매출 전체 규모
				public long TotalSales();

			// 안정성
				// 변동성
				public ArrayList<Integer> Variation(String sigungu_cd);

				// 운영년수
				public int OperationYear(Map<String, Object> param);
				
				// 매출변동률
				public ArrayList<Long> SalesVariation(Map<String, String> param);
				
			// 집객력
				// 유동인구
				public double FloatPopulation(String sigungu_cd);
				
				// 주거인구
				public double StayPopulation(String sigungu_cd);
				
				// 직장인구
				public double WorkerPopulation(String sigungu_cd);

			// 구매력
				// 건당 결제금액
				public int cntPrice(String sigungu_cd);
				
				// 소비수준
				public int incomeLevel(String sigungu_cd);
			
}

