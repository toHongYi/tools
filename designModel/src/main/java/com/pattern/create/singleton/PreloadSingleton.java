package com.pattern.create.singleton;

/**
 * @version : V1.0
 * @date : 2022/1/8 18:21
 * @Author : LLH
 * @Desc : 预加载
 */
public class PreloadSingleton {

    public static PreloadSingleton instance = new PreloadSingleton();
    //其他类无法实例
    private PreloadSingleton(){};

    public static PreloadSingleton getInstance(){
        return instance;
    }



}
