package _stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 734070824@qq.com
 * @date 2019/4/28 11:43
 */
public class MapDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect = integers.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.err.println(collect);


        System.err.println(Arrays.asList("a","b","v").stream().map(String::toUpperCase).collect(Collectors.toList()));

    }
}
