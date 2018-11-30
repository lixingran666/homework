package org.westos.设计模式;

public class TestSimpleFactory {
    public static void main(String[] args) {
        Human man = SimpleFactory.makeHuman("man");
        man.say();
        Human woman = SimpleFactory.makeHuman("woman");
        woman.say();
        Human thirdman = SimpleFactory.makeHuman("火星人");
    }
}
