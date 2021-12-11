package com.pattern.create.factory.factoryMethod;

/**
 * @version : V1.0
 * @date : 2021/12/8 22:46
 * @Author : LLH
 * @Desc :
 */
public class IPhone implements Phone{
    public IPhone(){
        this.make();
    }

    @Override
    public void make() {
        System.out.println("Make IPhone");
    }
}
