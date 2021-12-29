package com.example.springboottest01.service.impl;

import com.example.springboottest01.service.UserReader;

/**
 * @version : V1.0
 * @date : 2021/12/28 15:03
 * @Author : LLH
 * @Desc :
 */
public class UserReaderImpl1 implements UserReader {
    @Override
    public String getUser() {
        return "访问的UserReaderImplOne";
    }
}
