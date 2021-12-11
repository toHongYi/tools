package com.pattern.create.factory.factoryMethod;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:01
 * @Author : LLH
 * @Desc :简单工厂和工厂方法模式的不同在于前者生成产生产品的行为封装在一个方法中，
 * 根据参数的类型进行实例化，同时不存在抽象接口。
 * 而后者则增加了抽象工厂，通过实现不同的工厂方法来创建不同的产品，
 * 一个方法通常对应一个产品，这种方式相较于前者扩展性更高，
 * 在需求增加时完全符合开闭原则和依赖倒置原则。
 */
public class Demo {
    public static void main(String[] arg) {
        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");            // make xiaomi phone!
        IPhone iPhone = (IPhone)factory.makePhone("iPhone");    // make iphone!
    }
}
