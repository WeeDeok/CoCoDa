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
	public String home(Locale locale, Model model) {
		
		JSONArray result = dao.bringdanger();
		
		model.addAttribute("dangerresult",result);
		
		return "analysis";

	}

	@GetMapping("seoul_analysis")
	public String seoul_analysis (Model model) {

		JSONArray result = dao.bringdanger();
		
		model.addAttribute("dangerresult",result);
		
		return "analysis";
	}

	@GetMapping("middle")
	public JSONArray division_middle(@RequestParam String sales_divison_l_cd) {
		
		JSONArray result = null;
		
		result = service.division_middle(sales_divison_l_cd);
			
		return result;

	}
	
	@GetMapping("result")
	public String location(@RequestBody IndexVO param, Model model) {
		
		String target = "result_page";
		
		ArrayList<String> sales_num = new ArrayList<String>(); 	// 상권번호
		String sigungu_cd = null; // 시군구 코드 
		String sigungu_nm = null; // 시군구 이름
		
		String sales_division_nm = null;
		String sales_nm = null;
		
		sales_division_nm = service.divisionNm(param.getSales_division_s_cd());
			
		HashMap<String, Object> division = service.divisionMap(param.getSales_division_s_cd());
		for (String string : param.getSales_nm()) {
			sales_nm = string;
		}
		
		if(division != null) {
			model.addAttribute("division", division);
		}
		
		for (String string : param.getSales_num()) {
			sales_num.add(string);
		}
		
		for (String string : param.getSigungu_cd()) {
			sigungu_cd = string;
		}
		
		
		for (String string : param.getSigungu_nm()) {
			sigungu_nm = string;
		}
		
		model.addAttribute("cx", param.getCx());
		model.addAttribute("cy", param.getCy());
		model.addAttribute("sales_num", sales_num);
		model.addAttribute("sigungu_cd",sigungu_cd);
		model.addAttribute("sigungu_nm", sigungu_nm);
		model.addAttribute("address",param.getAddress());
		model.addAttribute("sales_division_s_cd", param.getSales_division_s_cd());
		model.addAttribute("division_nm", sales_division_nm);
		model.addAttribute("sales_nm", sales_nm);
			
		return target;

	}

}
