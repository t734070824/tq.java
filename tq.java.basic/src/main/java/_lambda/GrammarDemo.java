package _lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 语法
 * @author 734070824@qq.com
 * @date 2019/4/28 16:19
 */
public class GrammarDemo {



    public static void main(String[] args) throws InterruptedException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //单语句写法
        List<String> collect = Arrays.asList(new String[]{"Ni", "hao", "Da"})
                .stream()
                .map(name -> name.toLowerCase())
                .collect(Collectors.toList());
        System.err.println(collect);

        //方法引用写法
        System.err.println(Arrays.asList(new String[]{"Ni", "hao", "Da"})
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList()));

        //lambda表达式可使用的变量
        String wai = "wai";
        List<String> collect1 = Arrays.asList(new String[]{"Ni", "hao", "Da"})
                .stream()
                .map(chuandi -> {
                    long neibu = System.currentTimeMillis();
                    return wai + chuandi + ": " + neibu;
                })
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);
        collect1.forEach(System.out::println);


    }
}
