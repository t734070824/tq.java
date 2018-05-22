package _fastjson._list;

import _fastjson._map2string.Adress;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/5/22 14:52
 */
public class Json2List {
    public static void main(String[] args) {
        List<Adress> list = new ArrayList<>();
        list.add(new Adress("1", "2", 1));
        list.add(new Adress("2", "3", 2));
        System.err.println(JSON.toJSONString(list));
     }
}
