package _fastjson._map2string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SetStringDemo {
	
	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		set.add(123);
		System.err.println(JSON.toJSONString(set));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("123", 123);
		map.put("124", 124);
		
		System.err.println(JSON.toJSONString(map.entrySet()));
		
		
		
//		JSONObject array = JSON.parseObject(JSON.toJSONString(map.entrySet()));
//		System.err.println(array);
		
		
		JSONArray parse = (JSONArray) JSONArray.parse(JSON.toJSONString(map.entrySet()));
		System.err.println(JSON.toJSONString(parse.get(1)));
		
		Map<String, Object> mapTypes = JSON.parseObject(parse.get(1).toString());
		System.err.println(mapTypes);
		
		
	}

}
