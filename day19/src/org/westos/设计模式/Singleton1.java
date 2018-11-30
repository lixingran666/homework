package org.westos.设计模式;
//饿汉式单例:一开始就创建好
public class Singleton1 {
    //让构造方法私有
    private Singleton1() {
    }

    //自己创建这个实例
    private static final Singleton1 ME=new Singleton1();

    //获取唯一实例
    public static Singleton1 getInstance(){
        return ME;
    }
}
