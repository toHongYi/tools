package com.hongYi.tools;

import java.util.Arrays;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2022/6/8 9:37
 * @Author : LLH
 * @Desc :
 */
public class ArrayTools {
    public static void main(String[] args) {

        int[] arr = new int[]{0,1,3,4,5};
        System.out.println("arr = " + arr);

        List<int[]> ints = Arrays.asList(arr);
        System.out.println("ints = " + ints);

        System.out.println("ints.contains(1) = " + ints.contains(2));

        String[] arr2 = new String[]{"0","1","3","4","5"};
        System.out.println("arr2 = " + arr2);
        List<String> list = Arrays.asList(arr2);
        System.out.println("list = " + list);

        System.out.println("list.contains(1) = " + list.contains("1"));

    }
}
