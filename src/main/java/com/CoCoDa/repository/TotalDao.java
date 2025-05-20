package com.CoCoDa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TotalDao {

		@Autowired
		SqlSession session;
		
		public Map<String, Object> SalesInfo(String sigungu_cd) {
			// Base
				TotalMapper mapper = session.getMapper(TotalMapper.class);
				Map<String, Object> result = null;
				
			// Logic
				result = mapper.SalesInfo(sigungu_cd);
				System.out.println("결과값 : " + result);
				
			return result;
		}
		// 성장성
		
			// 월별 매출 증감률(10, 9, 8, 7)
				public ArrayList<Long> MonthSales(String sigungu_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						ArrayList<Long> result = new ArrayList<Long>();
						
					// Logic
						result = mapper.MonthSales(sigungu_cd);
						
						System.out.println(result);
						
					return result;
				}
			
			// 전체 매출 규모
				public long TotalSales() {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						long result = 0;
					
					// Logic
					result = mapper.TotalSales();
					
					return result;
				}
			
		// 안정성
			// 변동성
				public ArrayList<Integer> Variation(String sigungu_cd){
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						ArrayList<Integer> result = null;
						
					// Logic
						result = mapper. Variation(sigungu_cd);
						
					return result;
				}
			// 운영연수
				public int OperationYear(String sigungu_cd, String sales_divison_s_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						int result = 0;
						
					// Logic
						Map<String, Object> param = new HashMap<>();
						param.put("sales_divison_s_cd", sales_divison_s_cd);
						param.put("sigungu_cd", sigungu_cd);
						
						result = mapper.OperationYear(param);
					
					return result;
				}

			// 매출 변동률
				public ArrayList<Long> SalesVariation(String sigungu_cd, String sales_divison_s_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						
						Map<String, String> param = new HashMap<String, String>();
						param.put("sales_divison_s_cd", sales_divison_s_cd);
						param.put("sigungu_cd", sigungu_cd);
						
						ArrayList<Long> result = null;
						
					// Logic
						result = mapper.SalesVariation(param);
						
					return result;
				}
		// 집객력
			// 유동 인구
				public double FloatPopulation(String sigungu_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						double result = 0;
						
					// Logic
						result = mapper.FloatPopulation(sigungu_cd);
					
					return result;
				}
				
			// 주거인구
				public double StayPopulation(String sigungu_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						double result = 0;
						
					// Logic
						result = mapper.StayPopulation(sigungu_cd);
						
					return result;
				}
			// 직장 인구
				public double WorkerPopulation(String sigungu_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						double result = 0;
						
					// Logic
						result = mapper.WorkerPopulation(sigungu_cd);
						
					return result;
				}
				
		//	구매력
			//	건당 결제금액
				public int cntPrice(String sigungu_cd) {
					// Basic
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						int result = 0;
						
					
					// Logic
						result = mapper.cntPrice(sigungu_cd);
					
					return result;
				}

			// 소비 수준
				public int incomeLevel(String sigungu_cd) {
					// Base
						TotalMapper mapper = session.getMapper(TotalMapper.class);
						int result = 0;
						
					// Logic
						result = mapper.incomeLevel(sigungu_cd);
						
					return result;
				}
		
		
	} // Class 

