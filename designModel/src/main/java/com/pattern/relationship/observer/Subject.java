package com.pattern.relationship.observer;

import java.util.Observer;

/**
 * @version : V1.0
 * @date : 2022/1/8 19:35
 * @Author : LLH
 * @Desc :  被观察者;
 */
public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();

}
