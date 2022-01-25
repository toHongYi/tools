package com.pattern.relationship.observer;

import com.pattern.relationship.observer.Observer;

/**
 * @version : V1.0
 * @date : 2022/1/8 19:39
 * @Author : LLH
 * @Desc :
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name){
        this.name=name;
    }

    @Override
    public void update(String message){
        this.message = message;
        read();
    }

    public void read(){
        System.out.println(name + "收到推送消息"+ message);
    }


}
