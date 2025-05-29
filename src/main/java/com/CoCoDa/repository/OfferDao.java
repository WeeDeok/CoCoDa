package com.CoCoDa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.CoCoDa.mapper.OfferMapper;

@Repository
public class OfferDao {

	private OfferMapper mapper;
	
	public JSONArray selectoffer(int sigungu_cd, String sales_divison_s_cd) {
		
		JSONArray result = new JSONArray();
		int count = 0;
		HashMap<String,String> datamap = new HashMap<>();
		
		String data = "sales";
		datamap.put("data", data);
		
		try {
			
			ArrayList<String> datedata = mapper.selectmonth(datamap);	
			ArrayList<Map<String,Object>> temp = new ArrayList<>();
			
			for (String fixed_date : datedata) {
				
				HashMap<String,Object> offer = new HashMap<String,Object>();
				offer.put("sigungu_cd", (Integer)sigungu_cd);
				offer.put("fixed_date", (String)fixed_date);
				offer.put("sales_divison_s_cd", (String)sales_divison_s_cd);
				temp.add(mapper.selectoffer(offer));
				
			}
			
			for(Map<String,Object> t : temp) {
				JSONObject obj = new JSONObject();
				
				for (Map.Entry<String, Object> entry : t.entrySet()) {
					if (entry.getKey().equals("TEMPMONTH")) {
						String month = (String)entry.getValue();
						String[] monthtemp = month.split("");
						if (monthtemp[5].equals("0")) {
							obj.put("FIXED_MONTH", Integer.parseInt(monthtemp[6]));
						} else {
							obj.put("FIXED_MONTH", Integer.parseInt(monthtemp[5] + monthtemp[6]));
						}
					} else {
					obj.put(entry.getKey(), entry.getValue());
					}
				}
				
				result.put(count, obj);
				count++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
