package com.hongyi.test;

import com.alibaba.fastjson.JSONObject;
import com.hongyi.mode.Model01;
import com.hongyi.utils.impl.FileTestUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @version : V1.0
 * @date : 2021/12/15 9:56
 * @Author : LLH
 * @Desc :  缺少一张获取到所有所需数据的表;
 *          //需要将此表改造为工具类,传入数据为lccpps_xxxx.id;
 *          // 返回数据为后台数据的数据形式;
 *          "白名单准入流程需求说明书.docx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJ2UElGX0NQV0RLIiwiZmlsZUNvbHVtbiI6IkZKIiwiaWQiOjkwMzY4NSwiZW50cnlObyI6MH0="
 *
 *   再在外部封装时,格式改造为下方形式:
 *      "cpht": [
 *               "白名单准入流程需求说明书.docx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJ2UElGX0NQV0RLIiwiZmlsZUNvbHVtbiI6IkZKIiwiaWQiOjkwMzY4NSwiZW50cnlObyI6MH0="
 *          ]
 */
public class test1 {
    public static void main(String[] args) {

        final int id = 262;

        String fileColumn = "CPHT";
        String fileName = "产品合同";

        String fileColumn1 = "CPJZDCBG";
        String fileName1 = "产品尽职调查报告";

        String fileColumn2 = "CPJZFXBG";
        String fileName2 = "产品价值分析报告";

//        Model01 model01 = new Model01();
//        //字段中文件名称;
//        String fileName;
//        fileName= model01.getCPHT();
//        id = model01.getId();

        String s = FileTestUtil.fileTransation(fileColumn,fileName, id);
        String s1 = FileTestUtil.fileTransation(fileColumn1, fileName1, id);
        String s2 = FileTestUtil.fileTransation(fileColumn2, fileName2, id);

        System.out.println(" ===================================================================== " );
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);


        System.out.println("==============================================================================");







}}