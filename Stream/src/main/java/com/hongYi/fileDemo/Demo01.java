package com.hongYi.fileDemo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version : V1.0
 * @date : 2021/12/28 10:35
 * @Author : LLH
 * @Desc :
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //创建一个FileinputStream对象，并绑定一个数据源文件
        // 如果文件不存在，则会抛出异常（File not fount excep）
        FileInputStream fis = new FileInputStream("E:\\masm5\\aaa.txt");
        //调用read方法读取数据
        // int read​()： 从文件中读取一个字节数的数据。并返回读取到的这个字节。 如果读取结束，返回的是-1.
        int i;
        while ((i = fis.read()) != -1) {
           /*
                条件做了下面的事情
                1. 通过fis输入流调用read方法，读取一个字节。
                2. 把读取到的这个字节赋值给变量i。
                3. 判断i是否不等于-1，如果不是-1表示读取到了内容，就在循环中对读取到的内容进行处理。
                读取到的内容在i里面保存*/
            System.out.print((char) i);

        }    }
}
