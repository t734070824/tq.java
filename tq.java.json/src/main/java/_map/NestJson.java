package _map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 嵌套Json 转 Map
 * @author 734070824@qq.com
 * @date 2019/4/8 13:43
 */
public class NestJson {

    public static void main(String[] args) {
        String json = "{'ss':123, 'date':{'adress':45}}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.err.println(jsonObject);
    }
}
