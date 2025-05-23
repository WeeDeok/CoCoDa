package com.CoCoDa.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.CoCoDa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/total") // 공통 경로
public class TotalController {

	@Autowired
    private TotalService service;
	
	@GetMapping("/sales_info")
	public HashMap<String, Object> SalesInfo(@RequestParam ArrayList<String> sigungu_arr){
		// Base
			HashMap<String, Object>  result = new HashMap<>();
		// Logic
			result = service.SalesInfo(sigungu_arr);
			
		return result;
		
	}
	
	//	Total
	@GetMapping("/total_info")
	public ArrayList<HashMap<String, Object>> TotalInfo(@RequestParam String sigungu_cd, String sales_divison_s_cd){
		
		// Base
			ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		// Get
			result.add(service.Growth	 (sigungu_cd));
			result.add(service.Stability (sigungu_cd, sales_divison_s_cd));
			result.add(service.Collect	 (sigungu_cd));
			result.add(service.Purchasing(sigungu_cd));
		
		return result;
		
	}
	
}
