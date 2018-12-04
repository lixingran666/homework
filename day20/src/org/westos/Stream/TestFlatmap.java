package org.westos.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestFlatmap {
    public static void main(String[] args) {
        List<String[]> list=new ArrayList<>();
        list.add(new String[]{"张三","李四"});
        list.add(new String[]{"王五","张三"});
        list.add(new String[]{"钱七","周八"});

        List<String> list2=new ArrayList<>();
        for (String[] strings : list) {
            for (String string : strings) {
                list2.add(string);
            }
        }
        System.out.println(list2);

        //                                       字符串数组 转为 流
        List<String> list3 = list.stream().flatMap(strings -> Arrays.stream(strings)).collect(Collectors.toList());
        System.out.println(list3);

        //遍历 forEach
        list3.stream().forEach((a)->{
            System.out.println(a);
        });

        //map的遍历
        Map<String,String> map=new HashMap<>();
        map.put("a","张");
        map.put("b","李");
        map.forEach((key,value)->{
            System.out.println("key:"+key+" value:"+value);
        });

        //流的个数 count
        System.out.println(list3.stream().count());

        //去除重复
        System.out.println(list3.stream().distinct().collect(Collectors.toList()));

        //最大,最小
        List<String> list4=Arrays.asList("zhang","li","wang","zhao");
        System.out.println(list4.stream().max((a, b) -> a.compareTo(b)));
        System.out.println(list4.stream().min((a, b) -> a.compareTo(b)));

        //如果是数字流,还可以求和,求平均
        System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).max());
        System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).min());
        System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).average());
        System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sum());

        //测试学生集合
        List<Student> studentList=Arrays.asList(
                new Student("zhang","男","西安"),
                new Student("li","女","南京"),
                new Student("wang","男","西安"),
                new Student("zhao","男","北京"),
                new Student("qian","女","南京")
        );

        // 分组 Map<String, List<Student>>   男 ->{zhang li zhou}   女 ->{wang zhao}
        Map<String, List<Student>> map1 = studentList.stream().collect(Collectors.groupingBy((s) -> s.getSex()));
        System.out.println(map1);
        Map<String, List<Student>> map2 = studentList.stream().collect(Collectors.groupingBy(s -> s.getCity()));
        System.out.println(map2);
    }
}
