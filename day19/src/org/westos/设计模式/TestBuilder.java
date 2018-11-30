package org.westos.设计模式;

public class TestBuilder {
    public static void main(String[] args) {
        Person p = new Person.PersonBuilder()
                .sex("男")
                .name("张三")
                .height(178)
                .weight(59)
                .build();
        System.out.println(p);
    }
}
