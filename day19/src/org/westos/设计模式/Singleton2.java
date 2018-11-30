package org.westos.设计模式;
//懒汉式单例:用到时才创建
public class Singleton2 {
    //让构造方法私有
    private Singleton2() {
    }

    private static Singleton2 ME;

    public static synchronized Singleton2 getInstance(){
        if(ME==null){
            ME=new Singleton2();
        }
        return ME;
    }
}
