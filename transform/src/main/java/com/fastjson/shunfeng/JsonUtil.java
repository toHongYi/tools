package com.fastjson.shunfeng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fastjson.entity.DemoEntity;

import java.util.*;

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
        String object = JSONObject.toJSONString(new Object());

        String s = UUID.randomUUID().toString().replace("-","");


        List<DemoEntity> entity = new ArrayList<>();
        entity.add(new DemoEntity("测试一","地址一",2020));
        entity.add(new DemoEntity("测试二","地址二",2021));
        entity.add(new DemoEntity("测试三","地址三",2022));

        System.out.println("entity = " + entity.toString());
        String s1 = listToJson(entity);
        System.out.println("s1 = " + s1);
    }


    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }


    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * JSON 转 POJO
     */
    public static <T> T getObject(String pojo, Class<T> tclass) {
        try {
            return JSONObject.parseObject(pojo, tclass);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return null;
    }

    /**
     * POJO 转 JSON
     */
    public static <T> String getJson(T tResponse){
        String pojo = JSONObject.toJSONString(tResponse);
        return pojo;
    }

}
