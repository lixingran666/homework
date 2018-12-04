package org.westos.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * List<Integer> list = Arrays.asList(1,2,3,4,5);
 * 写一个方法找偶数，返回一个新的list包含结果
 *
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(exec(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i%2==0;
            }
        }));
        System.out.println(exec(list,i->i%2==0));
    }

    public static List<Integer> exec(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> list2 = new ArrayList<>();
        for (Integer i : list) {
            if(predicate.test(i)){
                list2.add(i);
            }
        }
        return list2;
    }
}
