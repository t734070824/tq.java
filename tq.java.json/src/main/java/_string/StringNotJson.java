package _string;

import com.alibaba.fastjson.JSON;

/**
 * @author 734070824@qq.com
 * @date 2018/11/5 14:51
 */
public class StringNotJson {

    public static void main(String[] args) {
        String json = "{\"name\":\"xx\",'add':'123.0', \"sub\":\"{'age':123}\"}";
        StringNotJsonSuper stringNotJsonSuper = JSON.parseObject(json, StringNotJsonSuper.class);
        StringNotJsonSub stringNotJsonSub = JSON.parseObject(stringNotJsonSuper.getSub(), StringNotJsonSub.class);
        System.err.println(stringNotJsonSuper.getSub());
        System.err.println(stringNotJsonSuper);
        System.err.println(stringNotJsonSub);
        System.err.println(stringNotJsonSuper.getAdd());
    }
}
