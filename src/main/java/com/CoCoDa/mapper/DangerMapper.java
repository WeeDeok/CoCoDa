package com.CoCoDa.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DangerMapper {
	
	public ArrayList<HashMap<String,String>> bringdanger();
}
