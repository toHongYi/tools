package com.pattern.create.factory.abstractFactory;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:03
 * @Author : LLH
 * @Desc :
 */
public class Demo {
    public static void main(String[] arg) {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new IphoneFactory();
        miFactory.makePhone();            // make xiaomi phone!
        appleFactory.makePhone();        // make iphone!
    }
}
