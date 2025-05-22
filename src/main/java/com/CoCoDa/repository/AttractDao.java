package com.CoCoDa.repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.CoCoDa.mapper.AttractMapper;

@Repository
public class AttractDao {

	private AttractMapper mapper;
	
	public JSONArray selectattraction(int sigungu_cd) {
		
		JSONArray result = new JSONArray();
		HashMap<String,Object> datalist = new HashMap<>();
		datalist.put("sigungu_cd", sigungu_cd);
		
		try {	

			ArrayList<HashMap <String,Object>> bring = mapper.selectattraction(datalist);
			
			for (HashMap <String,Object> t : bring) {
				JSONObject obj = new JSONObject();
				obj.put("government", t.get("GOVERNMENT"));
				obj.put("bank", t.get("BANK"));
				obj.put("bhospital", t.get("BHOSPITAL"));
				obj.put("shospital", t.get("SHOSPITAL"));
				obj.put("phar", t.get("PHAR"));
				obj.put("kinder", t.get("KINDER"));
				obj.put("elementary", t.get("ELEMENTARY"));
				obj.put("ele_pop", t.get("ELE_POP"));
				obj.put("middle", t.get("MIDDLE"));
				obj.put("mid_pop", t.get("MID_POP"));
				obj.put("high", t.get("HIGH"));
				obj.put("high_pop", t.get("HIGH_POP"));
				obj.put("university", t.get("UNIVERSITY"));
				obj.put("uni_pop", t.get("UNI_POP"));
				obj.put("department", t.get("DEPARTMENT"));
				obj.put("theater", t.get("THEATER"));
				obj.put("hotel", t.get("HOTEL"));
				obj.put("terminal", t.get("TERMINAL"));
				result.put(obj);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

	public JSONArray selectsubway(HashMap<String,Object> list) {
		
		JSONArray array = new JSONArray();
		
		try {
			
			ArrayList<HashMap<String,Object>> result = mapper.selectsubway(list);
			
			for (HashMap<String,Object> t : result) {
				JSONObject obj = new JSONObject();
				obj.put("fixed_date", t.get("FIXED_DATE"));
				obj.put("sub_nm", t.get("SUB_NM"));
				obj.put("time1", t.get("TIME1"));
				obj.put("time2", t.get("TIME2"));
				obj.put("time3", t.get("TIME3"));
				obj.put("time4", t.get("TIME4"));
				obj.put("time5", t.get("TIME5"));
				obj.put("time6", t.get("TIME6"));
				obj.put("time7", t.get("TIME7"));
				array.put(obj);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return array;
		
	}
	
	
}
