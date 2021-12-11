package com.pattern.create.factory.abstractFactory;

import com.pattern.create.factory.factoryMethod.Phone;
import com.pattern.create.factory.simplyFactory.PC;

/**
 * @version : V1.0
 * @date : 2021/12/8 23:02
 * @Author : LLH
 * @Desc :
 */
public interface AbstractFactory {
    Phone makePhone();
    PC makePC();
}
