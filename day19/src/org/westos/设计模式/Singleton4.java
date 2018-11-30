package org.westos.设计模式;
//懒汉式的更加实现
public class Singleton4 {
    private Singleton4() {
    }

    private static class Holder{
        static Singleton4 ME=new Singleton4();
    }

    public static Singleton4 getInstance(){
        return Holder.ME;
    }
}
