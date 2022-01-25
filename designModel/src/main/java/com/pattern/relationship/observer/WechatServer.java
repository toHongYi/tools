package com.pattern.relationship.observer;

import java.util.ArrayList;
import java.util.List;
import com.pattern.relationship.observer.Observer;

/**
 * @version : V1.0
 * @date : 2022/1/8 19:36
 * @Author : LLH
 * @Desc : 定义被观察者,
 */
public class WechatServer implements Subject{

    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }


    @Override
    public void registerObserver(java.util.Observer o) {
        // TODO Auto-generated method stub
        list.add((Observer) o);
    }

    @Override
    public void removeObserver(java.util.Observer o) {
        // TODO Auto-generated method stub
        list.add((Observer) o);

    }

    @Override
    public void notifyObserver() {
        // TODO Auto-generated method stub
        for (Observer o : list) {
            o.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        // 消息更新，通知所有观察者
        notifyObserver();
    }


}
