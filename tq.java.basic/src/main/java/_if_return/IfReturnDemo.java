package _if_return;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IfReturnDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("ss");
        list.add("vv");

        Iterator<String> iterator = list.iterator();
        if(iterator.hasNext()){
            String next = iterator.next();
            System.err.println(next);
            return;
        }

        System.err.println("AAAAAAAAA");

    }
}
