package com.CoCoDa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.CoCoDa.mapper.IndexMapper;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDao {
	
	private IndexMapper mapper;

	public List<Map<String, Object>> division_middle(String sales_divison_l_cd) {

		// Base
		List<Map<String, Object>> result = null;

		// Logic
		result = mapper.division_middle(sales_divison_l_cd);

		return result;
	}

	public HashMap<String, Object> divisionMap(String sales_division_s_cd) {
		// Base
		HashMap<String, Object> result = null;

		// Logic
		result = mapper.divisionMap(sales_division_s_cd);

		return result;
	}

	public String divisionNm(String sales_division_s_cd) {
		// TODO Auto-generated method stub
		// Base
			String result = null;
		
			result = mapper.divisionNm(sales_division_s_cd);
			
		return result;
	}

}
	