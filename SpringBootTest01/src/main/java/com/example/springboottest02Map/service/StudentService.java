package com.example.springboottest02Map.service;

/**
 * @version : V1.0
 * @date : 2021/12/28 15:02
 * @Author : LLH
 * @Desc :
 */
public interface StudentService {

    /**
     * 根据id 查询学生名字
     *
     * @param stuId Integer
     * @return String
     */
    String findStudentName(Integer stuId);
}
