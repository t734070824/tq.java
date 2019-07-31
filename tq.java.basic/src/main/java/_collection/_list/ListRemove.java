package _collection._list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2019/7/31 10:16
 */
public class ListRemove {

    /**
     * for(int index=x,size=arr.size();index<size): 这种方式size之后获取一次, 数组越界
     * for(int index=xx;index<arr.size): 这种方式实时获取size, 会造成数据 漏删
     *
     * @param args
     */

    public static void main(String[] args) {
//        cme();
//        nocme();
//        indexSelfNoCme();
        from_back_to_front();
    }

    private static void from_back_to_front() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for(int i = intList.size() - 1; i >= 0; i--) {
            Integer value = intList.get(i);
            if(value == 3 || value == 5) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
    }

    private static void indexSelfNoCme() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for(int i = 0; i < intList.size(); i++) {
            Integer value = intList.get(i);
            if(value == 3 || value == 5) {
                intList.remove(i);
                i--;
            }
        }
        System.out.println(intList);
    }

    /**
     * 维护索引的一致性
     */
    private static void nocme() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        Iterator<Integer> it = intList.iterator();
        while(it.hasNext()) {
            Integer value = it.next();
            if(value == 3 || value == 5) {
                it.remove();
            }
        }
        System.out.println(intList);
    }

    private static void cme() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for(Integer value : intList) {
            // 符合条件，删除元素
            if(value == 3 || value == 5) {
                intList.remove(value);
            }
        }
        System.out.println(intList);
    }
}
