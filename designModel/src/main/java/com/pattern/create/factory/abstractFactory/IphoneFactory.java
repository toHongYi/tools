package com.pattern.create.factory.abstractFactory;

import com.pattern.create.factory.factoryMethod.IPhone;
import com.pattern.create.factory.factoryMethod.Phone;
import com.pattern.create.factory.simplyFactory.MAC;
import com.pattern.create.factory.simplyFactory.PC;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:03
 * @Author : LLH
 * @Desc :
 */
public class IphoneFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public PC makePC() {
        return new MAC();
    }
}
