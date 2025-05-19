package com.CoCoDa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.project.cocoda.dao.TotalDAO;
import org.project.cocoda.utill.ConvertJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalService {

    private final TotalDao dao;

    @Autowired
    public TotalService(TotalDao dao) {
        this.dao = dao;
    }
		
		public HashMap<String, Object> SalesInfo(ArrayList<String> sigungu_arr) {
			// Base
				HashMap<String, Object> result = new HashMap<>();
				
				List<Map<String, Object>> select_result = new ArrayList<>();
				int float_pop = 0;
				int total_sales = 0;
				int store_cnt = 0;
				
			// Logic
				//
				for (String sigungu_cd : sigungu_arr) {
					select_result.add(dao.SalesInfo(sigungu_cd));
				}	
				
				for (Map<String, Object> one : select_result) {
					float_pop += (int)one.get("TOTAL_POP");
					store_cnt += (int)one.get("STORE_CNT"); 		
					total_sales += (int)one.get("TOTAL_SALES");
				}
				
				result.put("total_sales", total_sales);
				result.put("float_pop", float_pop);
				result.put("store_cnt", store_cnt);
				
			return result;
		}
		
		// 성장성
		public HashMap<String, Object> Growth(String sigungu_cd) {
			HashMap<String, Object> result = new HashMap<String, Object>();
			double avgGrowth = 0; 	// 월 별 매출증감률
			double salesScales = 0;	// 상권 규모
			double expectSales = 0;	// 예상 성장률

			// Logic
				// 월별 매출 증감률
					ArrayList<Long> temp = dao.MonthSales(sigungu_cd);
			
					double sum_growth = 0; // 저장변수
					
					for (int i = 0; i < temp.size() - 1; i++) {
						
						long exresult = temp.get(i + 1) - temp.get(i);
						
						double growth = ((double)exresult) / temp.get(i) * 100; // 성장률(%)
						
						sum_growth += growth;
					}
					avgGrowth =  Math.round((sum_growth/(temp.size()-1)) * 100) / 100.0; // 소수점 2자리
					
					result.put("avgGrowth", avgGrowth);
			
				// 상권 규모
					long totalSales = dao.TotalSales();
					
					long selectSales = temp.get(temp.size()-1);
					
					double pre_result = ((double)selectSales / totalSales) * 100;
					
					salesScales = Math.round(pre_result * 100) / 100.0;
				
					System.out.println("salesScales"+salesScales);
					
					
					result.put("salesScales", salesScales);
				
				// 예상 성장률
					expectSales = selectSales + (long)(selectSales * avgGrowth);
					result.put("expectSales", expectSales);
			
			return result;
		}
		
		// 안정성
		public HashMap<String, Object> Stability(String sigungu_cd, String sales_divison_s_cd) {
			// Base
				HashMap<String, Object> result = new HashMap<>();
				double variation = 0;		// 변동성
				double operationYear = 0;	// 운영년수
				double businessRate = 0;	// 휴 폐업률
			
			// Logic
				// 변동성 - 월별 점포수 변동
					ArrayList<Integer> month_store_cnt	= dao.Variation(sigungu_cd);
					double sum_var = 0;
					
					for (int i = 0; i < month_store_cnt.size()-1; i++) {
						double var = (double)(month_store_cnt.get(i+1) - month_store_cnt.get(i))/month_store_cnt.get(i) * 100;
						sum_var += var;
					}
					variation = sum_var / month_store_cnt.size();
					variation = Math.round(variation * 100) / 100.0;
					
					result.put("variation", variation);
					
				// 운영년수 - -해당지역 점포 평균 운영연수
					int temp = dao.OperationYear(sigungu_cd, sales_divison_s_cd);
					
					operationYear = (double)temp/12;
					operationYear = Math.round(operationYear * 100) / 100.0;
					
					result.put("operationYear",operationYear);
					
				// 해당 업소 매출 증감률
					ArrayList<Long> salesVariable = dao.SalesVariation(sigungu_cd, sales_divison_s_cd);
					double growth = 0;
					
					for(int i = 0; i < salesVariable.size() - 1; i++) {
						
						growth += ((double)salesVariable.get(i + 1) - salesVariable.get(i))/salesVariable.get(i);
						
					}
					growth = growth / (salesVariable.size()-1) * 100;
					growth = Math.round(growth * 100) / 100.0;
					
					result.put("growth",growth);
					
			return result;
		}
		
		//	집객력
		public HashMap<String, Object> Collect(String sigungu_cd) {
			// Base
				HashMap<String, Object> result = new HashMap<String, Object>();
				double floatPop = 0;	// 유동인구
				double stayPop = 0 ;	// 주거인구 
				double workerPop = 0; 	// 직장인구
				
			// Logic
				// 유동인구
					floatPop = dao.FloatPopulation(sigungu_cd);
					floatPop = Math.round(floatPop * 100) / 100.0;
					
					result.put("floatPop", floatPop);
				// 주거인구
					stayPop = dao.StayPopulation(sigungu_cd);
					stayPop = Math.round(stayPop * 100) / 100.0;
					
					result.put("stayPop", stayPop);
				
				// 직장인구
					workerPop = dao.WorkerPopulation(sigungu_cd);
					workerPop = Math.round(workerPop * 100) / 100.0;
					
					result.put("workerPop", workerPop);
					
			return result;
		}

		// 구매력
		public HashMap<String, Object> Purchasing(String sigungu_cd) {
			// Base
				HashMap<String, Object> result = new HashMap<>();
				int cnt_price = 0;		//	건당 결제금액
				int income_level = 0;	//	소비수준
						
			// Logic
				cnt_price = dao.cntPrice(sigungu_cd);
				result.put("cnt_price", cnt_price);
				
				income_level = dao.incomeLevel(sigungu_cd);
				result.put("income_level", income_level);
				
			return result;
		}
	}
