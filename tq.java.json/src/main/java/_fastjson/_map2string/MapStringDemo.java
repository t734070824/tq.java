package _fastjson._map2string;

import java.util.Map;

import com.alibaba.fastjson.JSON;

public class MapStringDemo {
	
	public static void main(String[] args) {
		String jsonString = JSON.toJSONString(new Person(111,"123", 1, new Adress("tq", "sss", null)));
		System.err.println(jsonString);
		
		Map<String, Object> mapTypes = JSON.parseObject(jsonString);
		System.err.println(mapTypes);
	}

}
