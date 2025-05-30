package com.CoCoDa.controller;

import java.util.ArrayList;

import com.CoCoDa.repository.PopDao;
import com.CoCoDa.vo.SelectIncomeVO;
import com.CoCoDa.vo.SelectKeyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopController {
	@Autowired
	PopDao dao;
	
	@GetMapping("selectstay")
	public ArrayList<SelectKeyVO> selectstay(int sigungu_cd) {

		ArrayList<SelectKeyVO> result = null;
		
		result = dao.selectstay(sigungu_cd);
		
		return result;

	}
	
	@GetMapping("selectworker")
	public ArrayList<SelectKeyVO> selectworker(int sigungu_cd) {

		ArrayList<SelectKeyVO> result = null;
		
		result = dao.selectworker(sigungu_cd);
		
		return result;

	}
	
	@GetMapping("selectfloat")
	public ArrayList<SelectKeyVO> selectfloat(int sigungu_cd) {

		ArrayList<SelectKeyVO> result = null;

		result = dao.selectfloat(sigungu_cd);

		return result;

	}
	
	@GetMapping("selectfloat2")
	public ArrayList<SelectKeyVO> selectfloat2(double wgsx, double wgsy) {

		ArrayList<SelectKeyVO> result = null;

		result = dao.selectfloat2(wgsx,wgsy);

		return result;

	}
	
	@GetMapping("selectincome")
	public ArrayList<SelectIncomeVO> selectincome(int sigungu_cd) {

		ArrayList<SelectIncomeVO> result = new ArrayList<>();
		
		result = dao.selectincome(sigungu_cd);
		
		return result;

	}
	
}
