package com.optional;

/**
 * @version : V1.0
 * @date : 2022/5/27 10:38
 * @Author : LLH
 * @Desc :
 */
public class CalcDemo {
    public static void main(String[] args) {
        int length = 64;
        int height = 200;
        int num1 = length/height;
        int num2 = height/length+1;
//        System.out.println("num = " + num1);
//        System.out.println("num = " + num2);
        //计算字节长度;

        // 获取当前字段字节长度；
        double numericCellValue = 22222L;
        System.out.println("numericCellValue = " + numericCellValue);
        String length2 = Double.toString(numericCellValue);
        System.out.println("length2 = " + length2);

        byte[] b = length2.getBytes();
        int t = b.length;
        System.out.println("b = " + b.length);

        String str = "大苏打大苏打大大萨达萨达阿德";
        byte[] bytes = str.getBytes();
        int f = bytes.length;
        System.out.println("str = " + f);

        System.out.println("length2.toString().length() = " + length2.toString().length());
        System.out.println("str.toString().length() = " + str.toString().length());
        System.out.println("length2.toString().length() = " + length2.toString().length()/3);

        //int c = Integer.MAX_VALUE+1//怕有的小伙伴看不懂
        int c = 2147483647+1;
        System.out.println(c);//-2147483648


        int strWidth = 32;
        int length1 = 64;
        System.out.println(length1 / strWidth);
        System.out.println(length1 / strWidth + 1);

    }
}
