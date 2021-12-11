package com.fastjson.shunfeng;


import com.fastjson.entity.LoggerFactoryDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LLH
 * @version V1.0
 * @Package com.lyl.shunfeng
 * @date 2021/11/30 11:21
 * @Description
 */
public class LoggerFactoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactoryDemo.class);

    public static void main(String[] args) {

        for (int i=0;i<5;i++){
            LOGGER.info("这是一条数据"+i);
            LOGGER.debug("这是debug");
            LOGGER.error("这是errot");
            LOGGER.warn("这是warn");
            LOGGER.trace("路过此地");
        }
    }

}
