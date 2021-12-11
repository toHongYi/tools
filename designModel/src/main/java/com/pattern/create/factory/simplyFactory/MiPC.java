package com.pattern.create.factory.simplyFactory;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:18
 * @Author : LLH
 * @Desc :
 */
public class MiPC implements PC{
    public MiPC(){
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make MiPC");
    }
}
