package _collection._list;

import java.util.ArrayList;
import java.util.List;

public class SubListApp {

    public static void main(String[] args) {

        List<String> mainList = new ArrayList<>();
        mainList.add("ss");
        mainList.add("ss");
        mainList.add("ss");
        mainList.add("ss");
        mainList.add("ss");
        mainList.add("ss");
        int size = mainList.size();
        int thread = 3;
        int perNum = (int)Math.ceil(1.0 * size / thread);

        for (int i = 0; i < 3; i++) {
            List<String> subList = mainList.subList(i * perNum, ((i + 1) * perNum) > size ? size :  ((i + 1) * perNum));
            System.err.println(subList);
        }




    }
}
