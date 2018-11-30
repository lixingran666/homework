package org.westos.设计模式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestStrategy {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan",18));
        list.add(new Student("lisi",28));
        list.add(new Student("wangwu",36));
        list.add(new Student("zhaoliu",19));
        list.add(new Student("wangwu",16));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //先按名字排,再按 年龄大小排
                int num=s1.getName().compareTo(s2.getName());
                int num2=num==0?s1.getAge()-s2.getAge():num;
                return num2;
            }
        });
        System.out.println(list);

    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
