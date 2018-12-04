package org.westos.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = list.stream();

        // 过滤方法 filter
        Stream<Integer> stream2 = stream1.filter(i -> i % 2 == 0);//2 4

        // 各个元素*2, map是映射的意思 2-> 2*2 ， 4-> 4*2
        Stream<Integer> stream3 = stream2.map(i -> i * 2);//4 8

        // 收集结果collect
        List<Integer> list2 = stream3.collect(Collectors.toList());
        System.out.println(list2);

        List<Integer> list3 = list.stream().filter(i -> i % 2 == 0).map(i -> i * 2).collect(Collectors.toList());
        System.out.println(list3);


    }
}
