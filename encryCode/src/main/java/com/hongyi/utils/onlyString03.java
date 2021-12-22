package com.hongyi.utils;

import java.util.*;

import static java.lang.System.out;

/**
 * @version : V1.0
 * @date : 2021/12/21 10:05
 * @Author : LLH
 * @Desc :
 */
public class onlyString03 {
    public static void main(String[] args) {

        //利用hashMap去重;

        HashMap<String,String> map = new HashMap();
        String test = "test.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMSwiZW50cnlObyI6MH0=";
        String test1 ="test1.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMCwiZW50cnlObyI6Mn0=";
        String test2 = "test2.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMSwiZW50cnlObyI6";

        map.put("test",test);
        map.put("test1",test1);
        map.put("test1",test2);

//        for(Map.Entry<String, String> entry : map.entrySet()){
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }

        List<String> list = new ArrayList<>();
        doTrain(list, map);

        list.forEach(System.out::println);

    }


    /**
     * 使用HashMap进行去重操作;
     * @param list
     * @param map
     * @return
     */
    private static void doTrain(List<String> list,HashMap<String,String> map) {
        for (String value : map.values()) {
            list.add(value);
        }
    }





//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static List<String> onlyOneBytest(List<String> list){
        //遍历数组: 获取当前对象;

        //若是先获取文件名;

        /**
         * list<String> list = new ArrayList<>();
         *         //iterating over keys only
         *         for (String key : map.keySet()) {
         *             System.out.println("Key = " + key);
         *         }
         *
         *         //iterating over values only
         *         for (String value : map.values()) {
         *             System.out.println("Value = " + value);
         *             list.add(value);
         *         }
         *
         *         list.forEach(System.out::println);
         */

        //对数组进行切分;

        return null;
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++




//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static List<String> onlyOne(List<String> list){
        //需要将字段进行分割提取,再对提取后的数据进行处理;

        HashSet<String> set = new HashSet<>();
        list.forEach((t)->doAdd(t,set));
        List<String> list1 = new ArrayList();
        set.forEach((t)->doListAdd(t,list1));
        return list1;
    }

    private static void doListAdd(String t, List<String> list1) {
        list1.add(t);
    }

    private static void doAdd(String list,HashSet set) {
        set.add(list);
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


}
