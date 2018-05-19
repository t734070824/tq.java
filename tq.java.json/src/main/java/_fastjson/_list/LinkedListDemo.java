package _fastjson._list;

import com.alibaba.fastjson.JSON;

/**
 * @author 734070824@qq.com
 * @date 2018/5/18 11:06
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        String json = "{\"name\":\"tq1\", \"next\":{\"name\":\"tq2\", \"next\":{\"name\":\"tq3\"}}}";
        LinkedListVo linkedListVo = JSON.parseObject(json, LinkedListVo.class);
        System.err.println(linkedListVo);
    }
}
