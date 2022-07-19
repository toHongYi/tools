package com.hongYi.tools;

import java.io.File;
import java.io.IOException;

/**
 * @version : V1.0
 * @date : 2022/7/14 18:48
 * @Author : LLH
 * @Desc :
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        System.out.println("property = " + property);
        File file = new File(".");
        System.out.println("file = " + file);
        System.out.println("file = " + file.getCanonicalPath());
        System.out.println("file = " + file.getAbsolutePath());
        System.out.println("file = " + file.getPath());


    }
}
