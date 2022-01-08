package com.pattern.create.singleton;

/**
 * @version : V1.0
 * @date : 2022/1/8 18:24
 * @Author : LLH
 * @Desc : 懒加载;
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton(){
    };

    public static Singleton getInstance() {
        if(instance==null)
        {
            instance=new Singleton();
        }
        return instance;

    }

}
