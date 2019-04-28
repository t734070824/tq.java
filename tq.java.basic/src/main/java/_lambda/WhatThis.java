package _lambda;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author 734070824@qq.com
 * @date 2019/4/28 16:38
 */
public class WhatThis {

    public static void main(String[] args) {
        WhatThis whatThis  = new WhatThis();
        whatThis.whatthis();
    }

    private void whatthis() {
        Arrays.asList("Ni", "hao", "Biejing")
                .stream()
                .map(str -> {
                    System.err.println(this.getClass().getName());
                    return str.toLowerCase(); })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
