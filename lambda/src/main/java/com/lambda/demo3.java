package com.lambda;

import java.util.function.IntUnaryOperator;

/**
 * @version : V1.0
 * @date : 2021/12/5 20:10
 * @Author : LLH
 * @Description :
 */
public class demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(()->
            System.out.println("Hello World")
        );

        IntUnaryOperator addOneShort = (x) -> (x+1);
        IntUnaryOperator addOneLong = (x) -> {return (x+1);};




    }
}
