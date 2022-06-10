package com.optional;

import java.util.Optional;

/**
 * @version : V1.0
 * @date : 2022/5/24 19:53
 * @Author : LLH
 * @Desc :
 */
public class OptionalDemo {
    public static void main(String[] args) {

        // filter 过滤
        Optional<Integer> optional123 = Optional.of(123);
                        // TODO 根据fiter中返回false和true信息严格对照;
        optional123.filter(num -> num == 123).ifPresent(num -> System.out.println("optional123:"+num));

        //
        Optional<Integer> optional456 = Optional.of(3456);
        optional456.filter(num -> num == 123).ifPresent(num -> System.out.println("optional456:"+num));

        /** 创建一个流对象|再调用该流对象的out方法 */
        optional456.ifPresent(System.out::println);


        System.out.println("测试: "+optional456.toString());


        String.valueOf(optional456).length();


        // map 转换
        // 如果optiona对象不为null,则执行map方法中的映射函数得到返回值;
        //1、 t->{ t = String.valueOf(optional789) }
        //2、 j->{ j = String.valueOf(optional456)..length(t) }
        Optional<Integer> optional789 = Optional.of(789);
        optional789.map(String::valueOf).map(String::length).ifPresent(length -> System.out.println("optional789:"+length));

    }

}
