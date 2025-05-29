package com.CoCoDa.controller;

import org.json.JSONArray;
import com.CoCoDa.repository.OfferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

	@Autowired
	private OfferDao dao;
		
	@GetMapping("/selectoffer")
	public JSONArray offer(int sigungu_cd,String sales_divison_s_cd) {
		
		JSONArray result = null;
		
		result = dao.selectoffer(sigungu_cd, sales_divison_s_cd);
		
		return result;
		
	}
	
	@GetMapping("mapsosa")
	public JSONArray mapsosa(int sigungu_cd, String sales_divison_s_cd) {
		
		JSONArray result = null;
		
		result = dao.selectoffer(sigungu_cd, sales_divison_s_cd);

		return result;
		
	}
		
}


