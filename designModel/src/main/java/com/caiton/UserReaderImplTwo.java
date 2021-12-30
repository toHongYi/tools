package com.caiton;

/**
 * @version : V1.0
 * @date : 2021/12/28 14:46
 * @Author : LLH
 * @Desc :
 */
public class UserReaderImplTwo implements UserReader{

    @Override
    public String getUser() {
        return "访问的UserReaderImplTwo";
    }
}
