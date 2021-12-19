package com.hongyi.base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @version : V1.0
 * @date : 2021/12/14 17:38
 * @Author : LLH
 * @Desc :
 */
public class Demo02 {
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
                                        //                  {"fileTable":"lcCPPSLC_CPXX","fileColumn":"fileName","id":264,"entryNo":1}
        String head = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";

        // 表名.对应上传表格名称 + 表.首部ID ;
        final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";

        // fileName需要与fileColumn对照;
        String url = CPHT + "|" + head + encode;
        System.out.println(url);

        /**
         * 产品合同|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSFQiLCJpZCI6MzAwLCJlbnRyeU5vIjowfQ==
         * 希瓦小牛200号证券投资基金产品尽职调查报告.pdf|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpEQ0JHIiwiaWQiOjIyMCwiZW50cnlObyI6MH0=
         */

    }
}
