package com.lambda;

/**
 * @version : V1.0
 * @date : 2021/12/5 11:41
 * @Author : LLH
 * @Description : 无参数,无返回值;
 */
public class demo1 {
    public static void main(String[] args) {

        Runnable runnable1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("Running without Lambda");
            }
        };

        Runnable runnable2 = ()-> System.out.println("Runnable with Lambda");
        runnable1.run();
        runnable2.run();


    }
}
