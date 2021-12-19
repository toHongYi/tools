package com.hongyi.utils.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/15 9:32
 * @Author : LLH
 * @Desc :  用于数据库中文件与字符串之间的拼接;
 */
public class FileTestUtil {


    /**
     *
     * @param
     * @param fileColumn
     * @param id
     * @return
     */
    public static String fileTransation(String fileColumn,String fileName, int id)  {

        String n = fileColumn;
        int y = id;
        String  mask = "{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\""+ n + "\",\"id\":" + y + ",\"entryNo\":0}";
        System.out.println("mask = " + mask);

        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String head = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";
        //final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";

        // fileName需要与fileColumn对照;
        String url = fileName + "|" + head + encode;
        System.out.println(url);

        return url;
    }

    public static String fileTransation(String fileColumn,String fileName, int id,int no) {
        String n = fileColumn;
        int y = id;
        int entryNo = no;
        String  mask = "{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\""+ n + "\",\"id\":" + y + ",\"entryNo\":" + no + "}";
        System.out.println("mask = " + mask);

        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String head = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";
        //final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";

        // fileName需要与fileColumn对照;
        String url = fileName + "|" + head + encode;
        System.out.println(url);

        return url;

    }


    /**
     * 输入获取到的后台字段数据;
     *      {"nextId":2,"items":[["0","新人手册.docx"],["1","财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"]]}
     *          {
     *   "nextId": 2,
     *   "items": [
     *     [
     *       "0",
     *       "新人手册.docx"
     *     ],
     *     [
     *       "1",
     *       "财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"
     *     ]
     *   ]
     * }
     *
     *          该找该字段,进行内部便利;
     *      获取到所有的所需链接,
     *
     * 注意：
     *      其中存在数据删除,前移;
     * @return
     */
    public List<String> fileTransationForQT(){

        return null;
    };


}