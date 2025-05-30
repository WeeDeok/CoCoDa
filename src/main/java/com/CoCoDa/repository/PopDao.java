package com.CoCoDa.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.CoCoDa.mapper.PopMapper;

import com.CoCoDa.vo.SelectIncomeVO;
import com.CoCoDa.vo.SelectKeyVO;
import org.springframework.stereotype.Repository;

@Repository
public class PopDao {
	
	private PopMapper mapper;

	public ArrayList<SelectKeyVO> selectstay(int sigungu_cd) {

		ArrayList<SelectKeyVO> result = new ArrayList<>();
		String data = "stay";
		HashMap<String,String> datamap = new HashMap<>();
		datamap.put("data", data);

		try {
			
			ArrayList<String> datedata = mapper.selectmonth(datamap);
			
			for (String fixed_date : datedata) {
				
				HashMap<String,Object> popstay = new HashMap<String,Object>();
				popstay.put("fixed_date", (String) fixed_date);
				popstay.put("sigungu_cd", (Integer) sigungu_cd);
				SelectKeyVO temp = mapper.selectstay(popstay);
				String[] monthtemp = fixed_date.split("");
				
				if (monthtemp[5].equals("0")) {
					temp.setFixed_month(Integer.parseInt(monthtemp[6]));
				} else {
					temp.setFixed_month(Integer.parseInt(monthtemp[5]+monthtemp[6]));
				}
				result.add(temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public ArrayList<SelectKeyVO> selectworker(int sigungu_cd) {
		
		ArrayList<SelectKeyVO> result = new ArrayList<>();
		String data = "worker";
		HashMap<String,String> datamap = new HashMap<>();
		datamap.put("data", data);
		
		try {
			
			ArrayList<String> datedata = mapper.selectmonth(datamap);
				
			for (String fixed_date : datedata) {
				
				HashMap<String,Object> popworker = new HashMap<String,Object>();
				popworker.put("fixed_date", (String) fixed_date);
				popworker.put("sigungu_cd", (Integer) sigungu_cd);
				SelectKeyVO temp = mapper.selectworker(popworker);
				String[] monthtemp = fixed_date.split("");
				
				if (monthtemp[5].equals("0")) {
					temp.setFixed_month(Integer.parseInt(monthtemp[6]));
				} else {
					temp.setFixed_month(Integer.parseInt(monthtemp[5]+monthtemp[6]));
				}

				result.add(temp);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	public ArrayList<SelectKeyVO> selectfloat(int sigungu_cd) {

		ArrayList<SelectKeyVO> result = new ArrayList<>();
		String data = "float";
		HashMap<String,String> datamap = new HashMap<>();
		datamap.put("data", data);

		try {
			
			ArrayList<String> datedata = mapper.selectmonth(datamap);
			
			for (String fixed_date : datedata) {
				
				HashMap<String,Object> popfloat = new HashMap<String,Object>();
				popfloat.put("fixed_date", (String) fixed_date);
				popfloat.put("sigungu_cd", (Integer) sigungu_cd);
				SelectKeyVO temp = mapper.selectfloat(popfloat);
				
				String[] monthtemp = fixed_date.split("");
				
				if (monthtemp[5].equals("0")) {
					temp.setFixed_month(Integer.parseInt(monthtemp[6]));
				} else {
					temp.setFixed_month(Integer.parseInt(monthtemp[5]+monthtemp[6]));
				}
				
				result.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	

	public ArrayList<SelectKeyVO> selectfloat2(double wgsx,double wgsy) {

		ArrayList<SelectKeyVO> result = new ArrayList<>();
		String data = "float";
		HashMap<String,String> datamap = new HashMap<>();
		datamap.put("data", data);

		try {
			
			ArrayList<String> datedata = mapper.selectmonth(datamap);
			
			for (String fixed_date : datedata) {
				
				HashMap<String,Object> popfloat = new HashMap<String,Object>();
				popfloat.put("fixed_date", (String) fixed_date);
				//popfloat.put("sigungu_cd", (Integer) sigungu_cd);
				popfloat.put("wgsx", wgsx);
				popfloat.put("wgsy", wgsy);
				SelectKeyVO temp = mapper.selectfloat2(popfloat);
				
				String[] monthtemp = fixed_date.split("");
				
				if (monthtemp[5].equals("0")) {
					temp.setFixed_month(Integer.parseInt(monthtemp[6]));
				} else {
					temp.setFixed_month(Integer.parseInt(monthtemp[5]+monthtemp[6]));
				}
				
				result.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	
	
	public ArrayList<SelectIncomeVO> selectincome(int sigungu_cd) {

		ArrayList<SelectIncomeVO> result = new ArrayList<>();
		String data = "income";
		HashMap<String,String> datamap = new HashMap<>();
		datamap.put("data", data);

		try {
			
			ArrayList<String> datedata = mapper.selectmonth(datamap);
			
			for (String fixed_date : datedata) {

				HashMap<String,Object> popincome = new HashMap<String,Object>();
				popincome.put("fixed_date", (String) fixed_date);
				popincome.put("sigungu_cd", (Integer) sigungu_cd);
				SelectIncomeVO temp = mapper.selectincome(popincome);
				String[] monthtemp = fixed_date.split("");
				
				if (monthtemp[5].equals("0")) {
					temp.setFixed_month(Integer.parseInt(monthtemp[6]));
				} else {
					temp.setFixed_month(Integer.parseInt(monthtemp[5]+monthtemp[6]));
				}

				result.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}

	private ArrayList<Object> setResultData(ArrayList<String> datedata, String func, int sigungu_cd) {

		ArrayList<Object> result = new ArrayList<>();
		SelectIncomeVO income = new SelectIncomeVO();
		SelectKeyVO key = new SelectKeyVO();

		for (String fixed_date : datedata) {

			HashMap<String,Object> popincome = new HashMap<String,Object>();
			popincome.put("fixed_date", (String) fixed_date);
			popincome.put("sigungu_cd", (Integer) sigungu_cd);
			SelectIncomeVO temp = mapper.selectincome(popincome);
			String[] monthtemp = fixed_date.split("");
			
			if (monthtemp[5].equals("0")) {
				temp.setFixed_month(Integer.parseInt(monthtemp[6]));
			} else {
				temp.setFixed_month(Integer.parseInt(monthtemp[5]+monthtemp[6]));
			}

			result.add(temp);

		}

		return result;

	}

}
