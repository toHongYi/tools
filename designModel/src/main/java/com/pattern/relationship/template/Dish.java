package com.pattern.relationship.template;

/**
 * @version : V1.0
 * @date : 2022/1/8 18:57
 * @Author : LLH
 * @Desc :
 */
public abstract class Dish {
    /**
     * 具体的整个过程
     */
     protected void dodish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();
}

