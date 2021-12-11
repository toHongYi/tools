package com.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @version : V1.0
 * @date : 2021/12/5 12:30
 * @Author : LLH
 * @Description : 有一个参数,且无返回值;
 */
public class demo2 {
    public static void main(String[] args) {
        //@FunctionalInterface
        Consumer<String> con = (x) -> System.out.println(x);
        // x -> System.out.println(x);
        con.accept("Hello World!");

        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        stringConsumer.accept("test1");
        System.out.println("//===============================语法三======================================//");
//===========================================语法三=====================================================================================

        Comparator<Integer> com1 = (x,y)->{
            System.out.println("x,y 函数式接口");
            return Integer.compare(x,y);
        };
        System.out.println("com1.compare(433,31) = " + com1.compare(433, 31));

        Comparator<Integer> com2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println("com2.compare(47,2313) = " + com2.compare(47, 2313));

    System.out.println("//===============================语法四======================================//");

        Comparator <Integer> com = (x,y)-> Integer.compare(x,y);
        System.out.println("com.compare(88,88) = " + com.compare(88, 88));

    System.out.println("//===============================语法五======================================//");




    }
}