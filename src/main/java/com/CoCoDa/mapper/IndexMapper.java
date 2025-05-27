package com.CoCoDa.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndexMapper {

	public List<Map<String, Object>> division_middle(String sales_divison_l_cd);

	public HashMap<String, Object> divisionMap(String sales_division_s_cd);

	public String divisionNm(String sales_division_s_cd);

}
