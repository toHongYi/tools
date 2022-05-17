package com.hongyi.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @version : V1.0
 * @date : 2021/12/14 15:56
 * @Author : LLH
 * @Desc :
 */
public class Demo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        // 测试:  http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=  (base64)
        //
        // JSON入参格式:    {"fileTable":"lcCPPSLC_CPXX","fileColumn":"QT","id":262,"entryNo":1}
        //  {
        //      "fileTable": "lcCPPSLC_CPXX",   数据所在表名;            √√√    所在表,基本不变;
        //      "fileColumn": "QT",             文件行;                 √√-    文件名
        //      "id": 262,                      数据所在表中的ID;        √√√    该行主键ID;  (非LCCPPSLC_ID);
        //      "entryNo": 1                    文件编码;               √√√    0为第一个文件; 1 为第二个文件;
        //   }
        // 将此数据进行Base64加密;
        /**
         * QT中字段状态: {"nextId":2,"items":[["0","新人手册.docx"],["1","财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"]]}
         *
         * {
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
         */
        //  此为QT中数据: {"nextId":2,"items":[["0","新人手册.docx"],["1","财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"]]}
        /**
         * 案例:   [
         *          "白名单准入流程需求说明书.docx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=
         *          eyJmaWxlVGFibGUiOiJ2UElGX0NQV0RLIiwiZmlsZUNvbHVtbiI6IkZKIiwiaWQiOjkwMzY4NSwiZW50cnlObyI6MH0="
         *         ]
         */

         // 编码
         String encode = Base64.getEncoder().encodeToString("{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\"CPJZDCBG\",\"id\":220,\"entryNo\":0}".getBytes("UTF-8"));
         System.out.println(encode);

         // 解码
         byte[] decode = Base64.getDecoder().decode(encode);
         System.out.println(new String(decode, "UTF-8"));

        String fileName = "希瓦小牛200号证券投资基金产品尽职调查报告.pdf";//SELECT CPJZDCBG from lcCPPSLC_CPXX where id = 220;

        String head = "|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";
        String encode1 = Base64.getEncoder().encodeToString("{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\"CPJZDCBG\",\"id\":220,\"entryNo\":0}".getBytes("UTF-8"));

        // fileName需要与fileColumn对照;
        String url = fileName + head + encode1;
        System.out.println(url);





    }
}
