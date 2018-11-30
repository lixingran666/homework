package org.westos.设计模式;
//享元模式
//Integer的享元范围-128~127
public class TestFlyweight {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(1)==Integer.valueOf(1));//true
        System.out.println(Integer.valueOf(100) == Integer.valueOf(100));//true
        System.out.println(Integer.valueOf(200) == Integer.valueOf(200));//false
    }
}
