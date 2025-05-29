package com.CoCoDa.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OfferMapper {

	public ArrayList<String> selectmonth(HashMap<String,String> datamap);
	
	public Map<String,Object> selectoffer(HashMap<String,Object> temp);
	
}
