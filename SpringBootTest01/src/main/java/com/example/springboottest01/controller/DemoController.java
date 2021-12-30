package com.example.springboottest01.controller;

import com.example.springboottest01.configuration.BeanConfig;
import com.example.springboottest01.service.UserReader;
import com.example.springboottest01.service.impl.UserReaderImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version : V1.0
 * @date : 2021/12/28 15:26
 * @Author : LLH
 * @Desc :
 */
@RestController
public class DemoController {

    @Autowired
    private UserReaderImpl1 userReader;
    @Autowired
    private BeanConfig beanConfig;

    @GetMapping("/get")
    public String get(String id) {
        UserReader queryService = beanConfig.createQueryService(id);
        System.out.println(queryService.toString());
        //
        return queryService.getUser();

    }
}
