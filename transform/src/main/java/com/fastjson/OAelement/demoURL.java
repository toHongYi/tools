package com.fastjson.OAelement;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @version : V1.0
 * @date : 2021/12/28 20:43
 * @Author : LLH
 * @Desc :
 */
public class demoURL {
    public static void main(String[] args) {

        //该组唯一ID;   //270
        int onlyID = 270;
        //字段名
        String QTColumn1 ="QT";
        //文件名
        String FileName = "测试";
        //第几位;
        int QTnoNo = Integer.valueOf(1);

        //文件名、字段名、唯一ID、第几位
        String fileTable = "lcCPPSLC_CPXX";

        String s = fileTransation(fileTable, FileName, QTColumn1, onlyID, QTnoNo);
        System.out.println("s = " + s);


    }

    private static String head1 ="http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";

    /**
     * @param  fileTable    数据表名;
     * @param fileName      文件名;
     * @param fileColumn    字段名;
     * @param onlyID        唯一ID;
     * @param entryNo       第几位;
     * @return
     */
    public static String fileTransation(String fileTable,String fileName, String fileColumn, int onlyID, int entryNo) {

        String fileTable1 = "lcCPPSLC_CPXX";

        String  mask = "{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\""+ fileColumn + "\",\"id\":" + onlyID + ",\"entryNo\":"+entryNo+"}";
        //log.info("mask = " + mask);

        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
//            log.error();  抛出异常;
            e.printStackTrace();
        }

        String head = head1;
        //final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";
        // fileName需要与fileColumn对照;
        String url = fileName + "|" + head + encode;

        //log.info(url);
        return url;

    }
}
