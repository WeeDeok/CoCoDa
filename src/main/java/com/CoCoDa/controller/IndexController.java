package com.CoCoDa.controller;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;

import org.json.JSONArray;
import com.CoCoDa.repository.DangerDao;
import com.CoCoDa.service.IndexService;
import com.CoCoDa.vo.IndexVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
public class IndexController {
	
	@Autowired
	private IndexService service;
	private DangerDao dao;
	
	//@GetMapping("/") 추후 결정 (Index 수정할까 말까 고민중)
	@GetMapping("/home")
	public JSONArray home(Locale locale) {
		
		JSONArray result = dao.bringdanger();
		
		//model.addAttribute("dangerresult",result);
		
		return result;

	}

	@GetMapping("/seoul_analysis")
	public JSONArray seoul_analysis (Model model) {

		JSONArray result = dao.bringdanger();
		
		//model.addAttribute("dangerresult",result);
		
		return result;

	}

	@GetMapping("/middle")
	public JSONArray division_middle(@RequestParam String sales_divison_l_cd) {
		
		JSONArray result = null;
		
		result = service.division_middle(sales_divison_l_cd);
			
		return result;

	}
	
	@GetMapping("/result")
	public HashMap<String, Object> location(@RequestBody IndexVO param, Model model) {
		
		HashMap<String, Object> map = new HashMap<>();

		ArrayList<String> sales_num = new ArrayList<String>(); 	// 상권번호
		String sigungu_cd = null; // 시군구 코드 
		String sigungu_nm = null; // 시군구 이름
		
		String sales_division_nm = null;
		String sales_nm = null;
		
		sales_division_nm = service.divisionNm(param.getSales_division_s_cd());
			
		HashMap<String, Object> division = service.divisionMap(param.getSales_division_s_cd());

		
		for (String str : param.getSales_nm()) {
			sales_nm = str;
		}
		
		if(division != null) {
			model.addAttribute("division", division);
		}
		
		for (String str : param.getSales_num()) {
			sales_num.add(str);
		}
		
		for (String str : param.getSigungu_cd()) {
			sigungu_cd = str;
		}
		
		
		for (String str : param.getSigungu_nm()) {
			sigungu_nm = str;
		}
		
		/*
		model.addAttribute("cx", param.getCx());
		model.addAttribute("cy", param.getCy());
		model.addAttribute("sales_num", sales_num);
		model.addAttribute("sigungu_cd",sigungu_cd);
		model.addAttribute("sigungu_nm", sigungu_nm);
		model.addAttribute("address",param.getAddress());
		model.addAttribute("sales_division_s_cd", param.getSales_division_s_cd());
		model.addAttribute("division_nm", sales_division_nm);
		model.addAttribute("sales_nm", sales_nm);
		*/

		map.put("cx", param.getCx());
		map.put("cy", param.getCy());
		map.put("sales_num", sales_num);
		map.put("sigungu_cd",sigungu_cd);
		map.put("sigungu_nm", sigungu_nm);
		map.put("address",param.getAddress());
		map.put("sales_division_s_cd", param.getSales_division_s_cd());
		map.put("division_nm", sales_division_nm);
		map.put("sales_nm", sales_nm);

		return map;

	}

}
