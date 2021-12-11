package com.pattern.create.factory.factoryMethod;

/**
 * @version : V1.0
 * @date : 2021/12/8 22:37
 * @Author : LLH
 * @Desc :
 */
public class PhoneFactory {

    public Phone makePhone(String phoneType) {
        if(phoneType.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }
        else if(phoneType.equalsIgnoreCase("iPhone")) {
            return new IPhone();
        }
        return null;
    }
}
