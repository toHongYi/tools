package com.pattern.create.factory.simplyFactory;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:22
 * @Author : LLH
 * @Desc :
 */
public class MAC implements PC{
    public MAC(){
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make MAC");
    }
}
