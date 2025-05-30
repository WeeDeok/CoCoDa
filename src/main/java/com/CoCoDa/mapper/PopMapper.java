package com.CoCoDa.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import com.CoCoDa.vo.SelectIncomeVO;
import com.CoCoDa.vo.SelectKeyVO;

@Mapper
public interface PopMapper {
	
	public ArrayList<String> selectmonth(HashMap<String,String> datamap);
	
	public SelectKeyVO selectstay(HashMap<String,Object> popstay);
	
	public SelectKeyVO selectworker(HashMap<String,Object> popworker);
	
	public SelectKeyVO selectfloat(HashMap<String,Object> popfloat);
	
	public SelectKeyVO selectfloat2(HashMap<String,Object> popfloat);
	
	public SelectIncomeVO selectincome(HashMap<String,Object> income);
	
}
