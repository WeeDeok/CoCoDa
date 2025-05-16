package org.CoCoda.mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface AttractMapper {

	public ArrayList<HashMap<String,Object>> selectattraction(HashMap<String,Object> list);
	
	public ArrayList<HashMap<String,Object>> selectsubway(HashMap<String,Object> list);
}
