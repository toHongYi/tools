package com.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/7 20:24
 * @Author : LLH
 * @Desc :
 */
public class test1 {
    public static void main(String[] args) {
        // 测试源
        List<String> sourceList = new ArrayList<>();
        for (int i = 0;i<10;i++) {
            sourceList.add("第" + i + "条数据");
        }
        System.out.println("数据条数：" + sourceList.size());
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
        long a1=System.currentTimeMillis();
        for (int i = 0;i < sourceList.size(); i++) doSome();
//        for (int i = 0; i < sourceList.size(); i++) { doSome(); }
        long a2=System.currentTimeMillis();
        System.out.println("普通for循环用时：" + (a2-a1));
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
        //当前时间戳
        long b1=System.currentTimeMillis();
            //程序执行;
        for (String t:sourceList) doSome();
        //结束后时间戳
        long b2=System.currentTimeMillis();
        System.out.println("增强for循环用时：" + (b2-b1));
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
        long c1=System.currentTimeMillis();
        sourceList.forEach((t)-> doSome());
        long c2=System.currentTimeMillis();
        System.out.println("forEach循环用时：" + (c2-c1));
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
        long d1=System.currentTimeMillis();
        sourceList.parallelStream().forEach((t)-> doSome());
        long d2=System.currentTimeMillis();
        System.out.println("forEach-Stream循环用时：" + (d2-d1));

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    }


    //变成多线程环境
    /**多线程环境下,stream效率较高; 只是运算,for和forEach效率较高;
     * stream().forEach用的多线程方式，其调用线程池的时候必然会耗费更多的时间。
     * 但如果你在循环内要处理的事情很多，或者要循环调用远程接口/数据库的时候，
     * 无疑极大的提升了效率
     */
    private static void doSome() {
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
