package com.example.springboottest02Map.controller;

import com.example.springboottest02Map.service.ServiceMapConstants;
import com.example.springboottest02Map.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @version : V1.0
 * @date : 2021/12/30 10:27
 * @Author : LLH
 * @Desc :
 */
@RestController
public class DemoController01 {

    @Autowired
        private Map<String, StudentService> studentServiceMap;

    @GetMapping("/getStudentName")
    public String getStudentBuyId(Integer studentId,String source){

        String key = ServiceMapConstants.STUDENT_SERVICE_PREFIX + source;

        //一个根据名称的调用;


        //如果没有找到,便默认为中国;
        StudentService studentService = Optional
            .ofNullable(studentServiceMap.get(key))
                .orElse(
                        studentServiceMap
                                .get(studentServiceMap.get(
                                        ServiceMapConstants.StudentServiceConstants.REQUEST_SITE_CN)));

//        StudentService studentService101 = studentServiceMap.get(key);
//        String studentName1 = studentService101.findStudentName(7);

        String studentName = studentService.findStudentName(studentId);

        return studentName;
    }

}
