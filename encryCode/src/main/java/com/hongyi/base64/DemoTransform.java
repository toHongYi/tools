package com.hongyi.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @version : V1.0
 * @date : 2022/3/25 18:46
 * @Author : LLH
 * @Desc :
 */
public class DemoTransform {
    public static void main(String[] args) throws UnsupportedEncodingException {

        /** 先判断:
         *      SELECT CPJZDCBG from lcCPPSLC_CPXX where id = 270;
         *          获取其传入数据情况;
         *      若为单个:
         *
         *      若为多个:
         *          289;
         *          299;
         *          300;
         *          获取其中某一文件URL;
         *               {"nextId":2,"items":[["0","新人手册.docx"],["1","财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"]]}
         *               {"nextId":1,"items":[["0","新人手册.docx"]]}
         *
         *           字段名:  DXCPXQFXPGB
         *                  CPJZDCBG
         *
         *      "白名单准入流程需求说明书.docx|http://172.15.7.109:8001/
         *                      product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJ2UElGX0NQV0RLIiwiZmlsZUNvbHVtbiI6IkZKIiwiaWQiOjkwMzY4NSwiZW50cnlObyI6MH0="
         *       后台可见:
         *              白名单准入流程需求说明书.docx
         *
         *              CPHT
         */
        String encode = Base64.getEncoder().encodeToString("{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\"QT\",\"id\":264,\"entryNo\":1}".getBytes("UTF-8"));

        //"{"fileTable":"TPIF_CPWDK","fileColumn":"WDMC","id":916656,"entryNo":0}"
        //                  {"fileTable":"lcCPPSLC_CPXX","fileColumn":"fileName","id":264,"entryNo":1}
        String head = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";

        // 表名.对应上传表格名称 + 表.首部ID ;
        final String CPHT = "这是表名称";

        // fileName需要与fileColumn对照;
        String url = CPHT + "|" + head + encode;
        System.out.println(url);

        /**
         * 产品合同|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSFQiLCJpZCI6MzAwLCJlbnRyeU5vIjowfQ==
         * 希瓦小牛200号证券投资基金产品尽职调查报告.pdf|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpEQ0JHIiwiaWQiOjIyMCwiZW50cnlObyI6MH0=
         */



        //该组唯一ID;
        int initID = 916656;
        //字段名
        String QTColumn1 ="FJ";
        //文件名
        String FileName = "催收短信截图.jpg";
        //第几位;
        int QTnoNo = 0;

        String fileTable = "TPIF_CPWDK";

        String URL_DOWN_HEAD = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";

        //格式转换;
        String urlQT = fileTransform(URL_DOWN_HEAD,fileTable,FileName, QTColumn1, initID,QTnoNo);
        System.out.println("urlQT = " + urlQT);


    }

    /**
     *
     * @param URL_DOWN_HEAD     下载地址配置前缀（根据配置项得出）
     * @param fileTable         文件表名:(所属表数据)
     * @param fileColumn        字段名:(表中字段名称)
     * @param onlyID            唯一ID:
     * @param entryNo           第几位{该项上传文件不为一时（目前只有QT项目不为一）使用，默认为0}
     *
     * @param fileName          文件名:(上传文件文件名)
     * @return
     */
    //下载地址、所属表名、文件名、字段名、唯一ID、第几位;
    public static String fileTransform(String URL_DOWN_HEAD,String fileTable,String fileName, String fileColumn, int onlyID, int entryNo) {
        //表名;

        String  mask = "{\"fileTable\":\""+fileTable+"\",\"fileColumn\":\""+ fileColumn + "\",\"id\":" + onlyID + ",\"entryNo\":"+entryNo+"}";

        System.out.println("mask = " + mask);
        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String head = URL_DOWN_HEAD;
        String url = fileName + "|" + head + encode;
        return url;
    }
}
