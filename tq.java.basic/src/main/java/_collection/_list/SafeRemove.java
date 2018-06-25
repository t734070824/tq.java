package _collection._list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 循环删除
 * @author 734070824@qq.com
 * @date 2018/3/3 10:11
 */
public class SafeRemove {

    public static void main(String args[]) {
        List<String> listOfPhones = new ArrayList<String>(
                Arrays.asList( "iPhone 6S", "iPhone 6", "iPhone 5", "Samsung Galaxy 4", "Lumia Nokia"));
        System.out.println("list of phones: " + listOfPhones);
        // Iterating and removing objects from list
        // This is wrong way, will throw ConcurrentModificationException
        for(String phone : listOfPhones){
            if(phone.startsWith("Samsung Galaxy 4")){
                listOfPhones.remove(phone); // will throw exception
            }
        }
        // The Right way, iterating elements using Iterator's remove() method
        for(Iterator<String> itr = listOfPhones.iterator(); itr.hasNext();){
            String phone = itr.next();
            if(phone.startsWith("iPhone")){
                // listOfPhones.remove(phone); // wrong again
                itr.remove();
                // right call
            }
        }
        System.out.println("list after removal: " + listOfPhones); }
}
