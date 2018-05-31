package _gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 734070824@qq.com
 * @date 2018/5/30 17:21
 */
public class SimpleExample1 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", System.out);
        gson.toJson(123, System.out);
    }
}
