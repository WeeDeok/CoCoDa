package com.CoCoDa.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.CoCoDa.repository.IndexDao;
import com.CoCoDa.util.ConvertJson;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
	
	@Autowired
	private IndexDao dao;
	
	public JSONArray division_middle(String sales_divison_l_cd) {
		
		// Base
		List<Map<String, Object>> select_result = null;
		
		JSONArray result = null;
		
		// Logic
		select_result = dao.division_middle(sales_divison_l_cd);
		
		if(select_result != null) {
			result = ConvertJson.convertMapJsonArray(select_result);
		}
		
		return result;

	}

	public HashMap<String, Object> divisionMap(String sales_division_s_cd) {

		// Base
		HashMap<String, Object> result = null;
		 
		 //Logic
		result = dao.divisionMap(sales_division_s_cd);
		 	
		return result;

	}

	public String divisionNm(String sales_division_s_cd) {
		// Base
		String result = null;
		// Logic
		result = dao.divisionNm(sales_division_s_cd);
		
		return result;
		
	}
	
}



