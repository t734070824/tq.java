package _fastjson._extend;

import com.alibaba.fastjson.JSON;

/**
 * @author 734070824@qq.com
 * @date 2018/4/3 14:10
 */
public class App {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAdress("123");
        p.setName("tq");
        String s = JSON.toJSONString(p);
        System.err.println(s);

        Base b = p;
        System.err.println(JSON.toJSONString(b));
    }
}
