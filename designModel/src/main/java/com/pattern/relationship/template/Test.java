package com.pattern.relationship.template;

/**
 * @version : V1.0
 * @date : 2022/1/8 19:01
 * @Author : LLH
 * @Desc : 模板方法: 定义好骨架,实现类去按照固定的骨架进行实现。
 */
public class Test {
    public static void main(String[] args) {
        Dish eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.dodish();

        System.out.println("-----------------------------");

        Dish bouilli = new Bouilli();
        bouilli.dodish();
    }

}
