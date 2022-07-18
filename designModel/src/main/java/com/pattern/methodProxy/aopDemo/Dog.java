package com.pattern.methodProxy.aopDemo;

import org.springframework.stereotype.Component;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/7/19 0:07
 * @description: TODO
 */
@Component
public class Dog {

    public void say(){
        System.out.println("汪汪");
    }
}
