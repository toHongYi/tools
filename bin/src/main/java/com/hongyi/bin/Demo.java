package com.hongyi.bin;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version : V1.0
 * @date : 2022/1/10 9:28
 * @Author : LLH
 * @Desc :
 */
public class Demo {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap();

        List<String> stockCollects = new ArrayList<>();
        stockCollects.add("深A 0837179472");
        stockCollects.add("沪A B451347160");
        stockCollects.add("深基 C837179472");

        List<String> stockAccounts = new ArrayList<>();
        for (String stockCollect : stockCollects) {
            String collect = stockCollect.subSequence(3,13).toString();
            System.out.println("collect = " + collect);
            stockAccounts.add(collect.toString());
        }

        String collect = stockCollects.stream().map(t -> t.subSequence(3, 13).toString()).collect(Collectors.joining(",   "));


//        map.put("stockAccounts",stockCollects.stream().map(t->t.split(" ")).findAny().get()collect(Collectors.joining("、   ")));
        System.out.println("FFFFcollect = " + collect);

        String collect2 = stockAccounts.stream().collect(Collectors.joining(","));



        System.out.println("collect2 = " + collect2);
        //Collectors.joining("、   ")
//        map.put("stockAccounts",stockCollects.stream().map(t->t.split(" ")).collect(Coll));


    }
}
