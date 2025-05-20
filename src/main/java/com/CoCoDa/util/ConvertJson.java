package org.project.cocoda.utill;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJson {

	// List<Map<String, Object>> => JSONArray
	public static JSONArray convertMapJsonArray(List<Map<String, Object>> select_result) {
		// Base
		JSONArray result = new JSONArray();
		JSONObject obj = new JSONObject();

		// Logic
		for (Map<String, Object> map : select_result) {

			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				obj.put(key, value);	
			}

			result.add(obj);
			obj = new JSONObject();

		}

		return result;
	}

	// Map<String, Object>> => JSON
	public static JSONObject getJsonStringFromMap(Map<String, Object> map) {
		JSONObject jsonObject = new JSONObject();
		for (Map.Entry<String, Object> entry : map.entrySet()) {

			String key = entry.getKey();
			Object value = entry.getValue();
			jsonObject.put(key, value);
			
		}

		return jsonObject;
	}

	// JSON => MAP<String, Object>
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObj) {
		Map<String, Object> map = null;

		try {

			map = new ObjectMapper().readValue(jsonObj.toJSONString(), Map.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

}
