package org.westos.设计模式;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        User user2 = (User) user.clone();
        System.out.println(user==user2);//false
        System.out.println(user2.getName());
        System.out.println(user2.getAge());
    }
}
