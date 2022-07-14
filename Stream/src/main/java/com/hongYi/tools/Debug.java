package com.hongYi.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @version : V1.0
 * @date : 2022/7/14 8:58
 * @Author : LLH
 * @Desc : 遍历HashMap集合的四种方式;
 */
public class Debug {
    public static void main(String[] args) {


            Map<String, String> map = new HashMap<String, String>();
            map.put("1", "value1");
            map.put("2", "value2");
            map.put("3", "value3");

            //第一种：普遍使用，二次取值
            System.out.println("通过Map.keySet遍历key和value：");
            for (String key : map.keySet()) {
                System.out.println("key= "+ key + " and value= " + map.get(key));
            }

            //第二种
            System.out.println("通过Map.entrySet使用iterator遍历key和value：");
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            //第三种：推荐，尤其是容量大时
            System.out.println("通过Map.entrySet遍历key和value");
            //内部是Set<Map.Entry<String, String>>
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            //第四种
            System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
            for (String v : map.values()) {
                System.out.println("value= " + v);
            }



            Map<String, String> map2 = new HashMap<String, String>();
            map2.put("01", "qwe");
            map2.put("02", "asd");
            map2.put("03", "zxc");
            // 通过entrySet()方法将map集合中的映射关系取出（这个关系就是Map.Entry类型）
            Set<Map.Entry<String, String>> entrySet = map2.entrySet();


        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue());
        }
        System.out.println("jsonObject = " + jsonObject);

            // 将关系集合entryset进行迭代，存放到迭代器中
            Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
            while (it2.hasNext()) {
                // 获取Map.Entry关系对象me
                Map.Entry<String, String> me = it2.next();
                // 通过关系对像获取key
                String key2 = me.getKey();
                // 通过关系对像获取value
                String value2 = me.getValue();
                System.out.println("key:" + key2 + "-->value:" + value2);

        }

    }
}
