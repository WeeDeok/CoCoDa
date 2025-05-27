package com.CoCoDa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Repository;

import com.CoCoDa.mapper.DangerMapper;

@Repository
public class DangerDao {
	
	private DangerMapper mapper;
	
	public JSONArray bringdanger() {
		
		JSONArray array = new JSONArray();
		
		try {
			
			
			
			ArrayList<HashMap<String,String>> result = mapper.bringdanger();
			
			for (HashMap<String,String> t : result) {
				JSONObject obj = new JSONObject();
				obj.put("SIGUNGU_CD", t.get("SIGUNGU_CD"));
				obj.put("DANGER_CD", t.get("DANGER_CD"));
				obj.put("DANGER_POINT", t.get("DANGER_POINT"));
				array.put(obj);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return array;
	}
	
	
}
