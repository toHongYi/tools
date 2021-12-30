package com.example.springboottest01.service.impl;

import com.example.springboottest01.service.UserReader;
import org.springframework.stereotype.Component;

/**
 * @version : V1.0
 * @date : 2021/12/28 15:03
 * @Author : LLH
 * @Desc :
 */
@Component
public class UserReaderImpl2 implements UserReader {
    @Override
    public String getUser() {
        return "访问的UserReaderImplTwo";
    }
}