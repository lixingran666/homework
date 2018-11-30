package org.westos.设计模式;

public class SimpleFactory {
    public static Human makeHuman(String type){
        if(type.equals("man")){
            Human man = new Man();
            return man;
        }else if(type.equals("woman")){
            Human woman = new Woman();
            return woman;
        }else {
            System.out.println("生产不出来");
            return null;
        }
    }
}
