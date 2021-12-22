package com.hongyi.utils;

import java.util.*;

/**
 * @version : V1.0
 * @date : 2021/12/21 10:05
 * @Author : LLH
 * @Desc :
 */
public class onlyString {
    public static void main(String[] args) {

        List<String> list = new ArrayList();
        String test = "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMSwiZW50cnlObyI6MH0=";
        String test1 ="oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMCwiZW50cnlObyI6Mn0=";
        list.add(test);
        list.add(test1);
        list.add("小白");
        list.add("小白");
        list.add("小林");

        list.forEach(System.out::println);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<String> list1 = onlyOne(list);

        //List<String> list2 = onlyOneOrder(list1);
        list1.forEach(System.out::println);

//        HashSet<String> set = new  HashSet<>();
//            //此t变为遍历后的list内部小对象;
//        list.parallelStream().forEach((t)->doSome(t,set));
//        System.out.println("是否去重成功:set = " + set);
//        System.out.println("list1 = " + list1);
    }

    /**
     * oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMCwiZW50cnlObyI6Mn0=
     * oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMSwiZW50cnlObyI6MH0=
     */


    private static void doSome(String test, HashSet<String> set) {
        set.add(test);
    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static List<String> onlyOne(List<String> list){
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



    /**
     * 去重,保留顺序;
     * @return
     */
    public static List<String> onlyOneOrder(List<String> list){
        LinkedHashSet<Object> temp = new LinkedHashSet<>();

        for(int i=0;i<list.size();i++){
           temp.add(list.get(i));
        }
        System.out.println("temp:"+temp);

        String[] array = temp.toArray(new String[0]);

        List<String> resultList= new ArrayList<>(Arrays.asList(array));

//        temp.toArray();

        return  resultList;
    }
}
