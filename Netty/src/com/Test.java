package com;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @version : V1.0
 * @date : 2022/2/17 11:25
 * @Author : LLH
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {

        String URL_DOWN_HEAD = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";

        //产品风险揭示书CPFXJSS(对接需要)————CPJSS(数据库)

        //TODO 需要对数据进行了解;
        String fileColumn = "CPFXDJSS";
        //
        String cpfxjss = "sql处理范围.md";

        String fileName = cpfxjss;
        Integer onlyID = 523;


        String s = fileTransform(URL_DOWN_HEAD, fileColumn, fileName, onlyID);
        System.out.println("s = " + s);

        //TODO 需要对数据进行了解;
        String fileColumn2 = "CPFXDJSS";
        //

        String fileName2 = "image-20220208183855992.png";
        Integer onlyID2 = 523;

        String s2 = fileTransform(URL_DOWN_HEAD, fileColumn2, fileName2, onlyID2);
        System.out.println("s = " + s2);

    }


    /**
     *
     * @param URL_DOWN_HEAD     下载地址配置前缀（根据配置项得出）
     * @param       fileTable         文件表名:(所属表数据)
     * @param fileColumn        字段名:(表中字段名称)
     * @param onlyID            唯一ID:
     * @param       entryNo           第几位{该项上传文件不为一时（目前只有QT项目不为一）使用，默认为0}
     *
     * @param fileName          文件名:(上传文件文件名)
     * @return
     */
    public static String fileTransform(String URL_DOWN_HEAD,String fileColumn,String fileName, int onlyID)  {

        String  mask = "{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\""+ fileColumn + "\",\"id\":" + onlyID + ",\"entryNo\":0}";

        System.out.println("mask = " + mask);

        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String head = URL_DOWN_HEAD;
        //final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";
        // fileName需要与fileColumn对照;
        String url = fileName + "|" + head + encode;
        return url;
    }
}
