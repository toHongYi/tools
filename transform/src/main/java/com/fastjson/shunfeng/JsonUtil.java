package com.fastjson.shunfeng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @version : V1.0
 * @date : 2021/12/2 15:18
 * @Author : LLH
 * @Description :
 */
public class JsonUtil {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("AAA", "1");
        map.put("BBB", "2");
        map.put("CCC", "3");
        System.out.println("map=>"+map);//map=>{AAA=1, CCC=3, BBB=2}

        //1.map转string
        String jsonString = JSON.toJSONString(map);
        System.out.println("1:mapToString=>"+jsonString);//mapToString=>{"AAA":"1","CCC":"3","BBB":"2"}

        //2.map转jsonObject
        JSONObject JSONObj = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println("2:mapToJSON=>"+JSONObj);//mapToJSON=>{"AAA":"1","CCC":"3","BBB":"2"}

        //3.String转jsonObject
        String jsonString2 = "{\"AAA\":\"1\",\"CCC\":\"3\",\"BBB\":\"2\"}";
        JSONObject parseObject = JSONObject.parseObject(jsonString2);
        System.out.println("3:StringToJson=>"+parseObject);//StringToJson=>{"AAA":"1","CCC":"3","BBB":"2"}

        //4.String转map
        Map stringToMap =  JSONObject.parseObject(jsonString2);
        System.out.println("4:StringToMap=>"+stringToMap);//StringToMap=>{"AAA":"1","CCC":"3","BBB":"2"}

        //5.jsonObject转map
        String str = "{\"age\":\"24\",\"name\":\"summer\"}";
        System.out.println("5.1:str = " + str);
        JSONObject  jsonObject = JSONObject.parseObject(str);
        System.out.println("5.2:jsonObject = " + jsonObject);
        Map jsonToMap =  JSONObject.parseObject(jsonObject.toJSONString());
        System.out.println("5.3:jsonToMap=>"+jsonToMap);//jsonToMap=>{"name":"summer","age":"24"}

        //6.jsonObject转String
        String jsonString3 = jsonObject.toJSONString();
        System.out.println("6:jsonToString=>"+jsonString3);//jsonToString=>{"name":"summer","age":"24"}

        //7、对象转JSON

        String s = UUID.randomUUID().toString().replace("-","");

    }
}
