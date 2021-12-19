package com.hongyi.base64;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @version : V1.0
 * @date : 2021/12/19 17:48
 * @Author : LLH
 * @Desc :
 */
public class transationDemo {
    public static void main(String[] args) {

        /**
         *          *  {
         *          *   "nextId": 3,
         *          *   "items": [
         *          *     [
         *          *       "0",
         *          *       "新人手册.docx"
         *          *     ],
         *          *     [
         *          *       "1",
         *          *       "财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"
         *          *     ],
         *                [
         *                  "2",
         *                  "财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"
         *                ]
         *          *   ]
         *          * }
         */

        String write = " {\"nextId\":2,\"items\":[[\"0\",\"新人手册.docx\"],[\"1\",\"财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf\"]]}";
        Map stringToMap =  JSONObject.parseObject(write);
        System.out.println("stringToMap = " + stringToMap);
        List items = (List) stringToMap.get("items");
        for (Object item : items) {
            System.out.println("测试一下item是否执行完毕 = " + item);
        }

        System.out.println("items = " + items);


    }
}
