package org.westos.挖宝;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestTreasure {
    public static void main(String[] args) throws ClassNotFoundException {
        // E:\IdeaProjects\homework\day20
        // 类加载器, 作用：加载一个不在classpath下的类
        ClassLoader cl = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in  = new FileInputStream("E:\\IdeaProjects\\homework\\day20\\Treasure.class");
                    byte[] bytes = new byte[1024*8];
                    int len = in.read(bytes);

                    // 调用父类的方法根据字节数组加载类
                    return defineClass(name, bytes, 0, len);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        Class<?> clazz = cl.loadClass("com.westos.Treasure"); // 根据类名加载类, 得到类对象
        for (Method method : clazz.getMethods()) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if(annotation!=null){
                    System.out.println(annotation+",宝藏方法为: "+method);
                }
            }
        }
        /*
        public void com.westos.Treasure.me247e3d53e724001a4e828add5698d3c()
public void com.westos.Treasure.m58bc2e8a640640c2b29559a2c377ab13()
public void com.westos.Treasure.mc21085e018bc48f586b0365a2778263d()
         */
    }
}
