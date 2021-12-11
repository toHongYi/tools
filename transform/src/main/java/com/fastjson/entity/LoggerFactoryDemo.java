package com.fastjson.entity;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class LoggerFactoryDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactoryDemo.class);


    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            DemoEntity entity = getDemoEntity(i);
            LOGGER.info("这是一条数据:{}", JSON.toJSONString(entity));

        }
        for (int i=0;i<5;i++){
            DemoEntity entity = getDemoEntity(i);
            LOGGER.info("{}：也可以是前面", JSON.toJSONString(entity));
        }
    }
    private static DemoEntity getDemoEntity(int i){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("小明"+i+"号");
        demoEntity.setAddress("北京胡同"+2+"街道");
        demoEntity.setBirthday(new Date());
        return demoEntity;
    }
}

