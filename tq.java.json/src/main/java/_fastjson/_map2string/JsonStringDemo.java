package _fastjson._map2string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonStringDemo {

    public static void main(String[] args) {
        String json = "{\"adress\":{\"addressName\":\"tq\",\"addressStr\":\"sss\"},\"id\":111,\"name\":\"123\",\"sex\":1}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.err.println(jsonObject);
        System.err.println(json);


        String json1 = "\"" + json + "\"";
        System.err.println(json1);
    }
}
