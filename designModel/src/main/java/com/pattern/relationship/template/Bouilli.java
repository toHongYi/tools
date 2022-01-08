package com.pattern.relationship.template;

/**
 * @version : V1.0
 * @date : 2022/1/8 18:58
 * @Author : LLH
 * @Desc :
 */
public class Bouilli extends Dish{
    @Override
    public void preparation() {
        System.out.println("洗并切西红柿，打鸡蛋。");
    }

    @Override
    public void doing() {
        System.out.println("鸡蛋倒入锅里，然后倒入西红柿一起炒。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将炒好的西红寺鸡蛋装入碟子里，端给客人吃。");
    }

}
