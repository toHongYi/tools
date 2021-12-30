package com.example.springboottest02Map.service.impl;

import com.example.springboottest02Map.service.StudentService;
import org.springframework.stereotype.Component;

/**
 * @version : V1.0
 * @date : 2021/12/28 15:03
 * @Author : LLH
 * @Desc :
 */
@Component
public class StudentServiceCnImpl implements StudentService {

    @Override
    public String findStudentName(Integer stuId) {
        return "小明 ---from cn";
    }
}
