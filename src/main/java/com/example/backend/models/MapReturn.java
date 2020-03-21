package com.example.backend.models;

import java.util.HashMap;
import java.util.Map;

public class MapReturn {

	public static Map<String, ?> objReturn(Object data, long total, String message, String status) {
		Map<String, Object> mapReturn = new HashMap<>(4);
		
	    mapReturn.put("data", data);
        mapReturn.put("total", total);
        mapReturn.put("message", message);
        mapReturn.put("status", status);
        
		return mapReturn;
	}

}
