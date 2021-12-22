package com.judge;

/**
 * @version : V1.0
 * @date : 2021/12/21 9:42
 * @Author : LLH
 * @Desc :
 */
public class nullString {
    public static void main(String[] args) {

        String str1 = null; //str引用为空
        String str2 = ""; //str应用一个空串

        //str1还不是一个实例化的对象，儿str2已经实例化。
        //对象用equals比较，null用等号比较。

        //如果str1=null;下面的写法错误：
        if(str1==null||str1.equals("")){
            System.out.println("存在null值");
        }
        //先判断是不是对象，如果是，再判断是不是空字符串
        //if(str1.equals("")||str1==null){ }

    }
}
