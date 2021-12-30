package com.set;

import java.util.*;

/**
 * @version : V1.0
 * @date : 2021/12/29 16:31
 * @Author : LLH
 * @Desc :
 */
public class onlyOneDemo01 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println("set = " + set);
        set.add("apsm");
        set.add("cpsms");
        set.add("cpsms001");
        set.add("cpsms001");
        set.add("cpsms003");
        System.out.println("set = " + set);
        // java中的强制类型转换只是针对单个对象的
        Object[] objects = set.toArray();
        System.out.println("objects = " + objects.toString());
        String[] strings = new String[set.size()];
        set.toArray(strings);
        String s = Arrays.toString(new HashSet[]{set});

        System.out.println("s = " + s);
        set.parallelStream().forEach( t ->{
            System.out.println("s = " + t);
        });


        /**
         * 1、外部创建set结构;
         *      cphtSet01
         * 2、List.forEach{
         *
         *  String cpht = receiveModel.getCPHT();
         *      cphtSet01.add(cpht);
         *
         * }
         *
         * 3、
         * set.parallelStream().forEach( t ->{
         *
         *         System.out.println("s = " + t);
         *         String cphtURL = fileTransform(URL_DOWN_HEAD,"CPHT", cpht, id);
         *         List.add()
         *     });
         *
         *
         *
         */


    }

    /**
     *
     */
    private static void only(String bjs,HashSet set){
        set.add(bjs);
    }
}
