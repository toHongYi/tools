package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @version : V1.0
 * @date : 2021/12/5 21:02
 * @Author : LLH
 * @Description :
 */
public class demo5 {
    public static void main(String[] args) {



        // old way
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list1) {
            System.out.println(n);
        }

//  使用完整的lambda表达式;  内部是函数式编程;
        list1.forEach(n -> {
            System.out.println(n);
        });

// 使用 -> 的 Lambda 表达式
        list1.forEach(n->System.out.println(n));

// 使用 :: 的 Lambda 表达式  下方对上方进行简化;
        list1.forEach(System.out::println);

        /** Consumer<T> 接口
         *  1、action : (n->{System.out.println(n)})
         *  2、action : (n->System.out.println(n))
         *  3、action : (System.out::println)
         */
        System.out.println("===========================================================================");

                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

                System.out.print("输出所有数字：");
                evaluate(list, (n) -> true);

                System.out.print("不输出：");
                evaluate(list, (n) -> false);

                System.out.print("输出偶数：");
                evaluate(list, (n) -> n % 2 == 0);

                System.out.print("输出奇数：");
                evaluate(list, (n) -> n % 2 == 1);

                System.out.print("输出大于 5 的数字：");
                evaluate(list, (n) -> n > 5);
            }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {

        for (Integer n : list) {
            if (predicate.test(n)) {
                        System.out.print(n + " ");
               }
            }
            System.out.println();
        }
}
