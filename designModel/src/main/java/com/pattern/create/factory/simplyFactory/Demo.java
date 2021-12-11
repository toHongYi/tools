package com.pattern.create.factory.simplyFactory;

import com.pattern.create.factory.abstractFactory.AbstractFactory;
import com.pattern.create.factory.abstractFactory.IphoneFactory;
import com.pattern.create.factory.abstractFactory.XiaoMiFactory;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:08
 * @Author : LLH
 * @Desc :抽象工厂模式是工厂方法模式的升级版，后者面向单个产品，而前者面向的的是一个产品族。
 * 根据官方定义：为创建一组相关/互相依赖的对象提供一个接口而无需指定它们的具体类。
 * 比如一个汽车工厂要生成骑车，而每种汽车都有车门、车轮胎等一系列产品，
 * 这意味着每增加一款汽车就需要增加一个新的工厂来提供新产品的实现。
 * 这时候就可以使用抽象工厂模式来进行设计。抽象工厂模式适用于一系列产品族。
 */
public class Demo {
    public static void main(String[] arg) {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new IphoneFactory();
        miFactory.makePhone();            // make xiaomi phone!
        miFactory.makePC();                // make xiaomi PC!
        appleFactory.makePhone();        // make iphone!
        appleFactory.makePC();            // make MAC!
    }

}
