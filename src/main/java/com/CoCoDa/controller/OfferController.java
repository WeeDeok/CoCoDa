package com.CoCoDa.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.CoCoDa.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

	@Autowired
	private OfferService service;
		
	@GetMapping("/selectoffer")
	public ArrayList<HashMap<String, Object>> offer(int sigungu_cd,String sales_divison_s_cd) {
		
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		result = service.offer(sigungu_cd, sales_divison_s_cd);
		
		return result;
		
	}
	
	@GetMapping("/mapsousa")
	public ArrayList<HashMap<String, Object>> mapsousa(int sigungu_cd, String sales_divison_s_cd) {
		
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		result = service.mapsousa(sigungu_cd, sales_divison_s_cd);

		return result;

	}
		
}