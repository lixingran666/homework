package org.westos.枚举;

public class EnumTest {
    public static void main(String[] args) {
        //枚举类中常用的方法
        //1.获取枚举类中对象的序号,序号从0开始
        System.out.println(Sex.MALE.ordinal());//0
        System.out.println(Sex.FEMALE.ordinal());//1

        //2.枚举类和字符串的转换
        //把枚举对象转为字符串
        System.out.println(Sex.MALE.name());//MALE
        //把字符串转为枚举对象
        Sex female = Sex.valueOf("FEMALE");

        //虚拟机中的枚举对象只有一份,可以用==来比较
        System.out.println(Sex.valueOf("MALE") == Sex.MALE);//true

        //3.打印所有的枚举对象
        for (Sex sex : Sex.values()) {
            System.out.println(sex);
        }
    }
}
