package com.hongyi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;

public class Utils {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        String test = "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMSwiZW50cnlObyI6MH0=";
        String test1 ="oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxMCwiZW50cnlObyI6Mn0=";
        list.add(test);
        list.add(test1);
        list.add("小白");
        list.add("小白");
        list.add("小林");

        JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
        String s = array.toString();
        System.out.println("array"+array);
        System.out.println("s"+s);
        System.out.println("++++++++++++++++++++++++++++++++++++");

        List<String> list1 = stringToList(s);
        list.forEach(System.out::println);


    }

    private static List<String> stringToList(String strs){
        String str[] = strs.split(",");
        return Arrays.asList(str);
    }


    /**
     * [FormtableMainDt{cpmc='广发瑞锦一年定期开放混合型证券投资基金', cpdm='011481', test='null', cpjc='广发瑞锦一年定开混合', cplx='公募', cpfxdj='R4 中高风险', cpglr='广发基金', cptgr='华夏银行', cptabh='49', sclx='场外', jjjl='林绿化'},
     * FormtableMainDt{cpmc='财慧通571号', cpdm='SRL921', test='null', cpjc='财慧通571号', cplx='收益凭证', cpfxdj='R1 低风险', cpglr='财通证券（总）', cptgr='APS资产管理', cptabh='67', sclx='场外', jjjl='null'},
     * FormtableMainDt{cpmc='尊享宝中证500指数看跌105号', cpdm='SRQ443', test='null', cpjc='尊享宝中证500指数看跌105号', cplx='收益凭证', cpfxdj='R1 低风险', cpglr='财通证券（总）', cptgr='财通证券（总）', cptabh='67', sclx='场外', jjjl='林鸿一02'}]
     */

    /**
     * [FormtableMainDt{cpmc='广发瑞锦一年定期开放混合型证券投资基金', cpdm='011481', test='null', cpjc='广发瑞锦一年定开混合', cplx='公募', cpfxdj='R4 中高风险', cpglr='广发基金', cptgr='华夏银行', cptabh='49', sclx='场外', jjjl='林绿化'},
     * FormtableMainDt{cpmc='财慧通571号', cpdm='SRL921', test='null', cpjc='财慧通571号', cplx='收益凭证', cpfxdj='R1 低风险', cpglr='财通证券（总）', cptgr='APS资产管理', cptabh='67', sclx='场外', jjjl='null'},
     * FormtableMainDt{cpmc='尊享宝中证500指数看跌105号', cpdm='SRQ443', test='null', cpjc='尊享宝中证500指数看跌105号', cplx='收益凭证', cpfxdj='R1 低风险', cpglr='财通证券（总）', cptgr='财通证券（总）', cptabh='67', sclx='场外', jjjl='林鸿一02'}]}
     */

    /**
     * "formtableMainDt1":[
     * {"cpdm":"011481","cpfxdj":"R4 中高风险","cpglr":"广发基金","cpjc":"广发瑞锦一年定开混合","cplx":"公募","cpmc":"广发瑞锦一年定期开放混合型证券投资基金","cptabh":"49","cptgr":"华夏银行","jjjl":"林绿化","sclx":"场外"},
     * {"cpdm":"SRL921","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"财慧通571号","cplx":"收益凭证","cpmc":"财慧通571号","cptabh":"67","cptgr":"APS资产管理","sclx":"场外"},
     * {"cpdm":"SRQ443","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"尊享宝中证500指数看跌105号","cplx":"收益凭证","cpmc":"尊享宝中证500指数看跌105号","cptabh":"67","cptgr":"财通证券（总）","jjjl":"林鸿一02","sclx":"场外"}]}
     */

    /**
     * "formtableMainDt1":[
     * {"cpdm":"011481","cpfxdj":"R4 中高风险","cpglr":"广发基金","cpjc":"广发瑞锦一年定开混合","cplx":"公募","cpmc":"广发瑞锦一年定期开放混合型证券投资基金","cptabh":"49","cptgr":"华夏银行","jjjl":"林绿化","sclx":"场外"},
     * {"cpdm":"SRL921","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"财慧通571号","cplx":"收益凭证","cpmc":"财慧通571号","cptabh":"67","cptgr":"APS资产管理","sclx":"场外"},
     * {"cpdm":"SRQ443","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"尊享宝中证500指数看跌105号","cplx":"收益凭证","cpmc":"尊享宝中证500指数看跌105号","cptabh":"67","cptgr":"财通证券（总）","jjjl":"林鸿一02","sclx":"场外"},
     * {"cpdm":"011481","cpfxdj":"R4 中高风险","cpglr":"广发基金","cpjc":"广发瑞锦一年定开混合","cplx":"公募","cpmc":"广发瑞锦一年定期开放混合型证券投资基金","cptabh":"49","cptgr":"华夏银行","jjjl":"林绿化","sclx":"场外"},
     * {"cpdm":"SRL921","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"财慧通571号","cplx":"收益凭证","cpmc":"财慧通571号","cptabh":"67","cptgr":"APS资产管理","sclx":"场外"},
     * {"cpdm":"SRQ443","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"尊享宝中证500指数看跌105号","cplx":"收益凭证","cpmc":"尊享宝中证500指数看跌105号","cptabh":"67","cptgr":"财通证券（总）","jjjl":"林鸿一02","sclx":"场外"},
     * {"cpdm":"011481","cpfxdj":"R4 中高风险","cpglr":"广发基金","cpjc":"广发瑞锦一年定开混合","cplx":"公募","cpmc":"广发瑞锦一年定期开放混合型证券投资基金","cptabh":"49","cptgr":"华夏银行","jjjl":"林绿化","sclx":"场外"},
     * {"cpdm":"SRL921","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"财慧通571号","cplx":"收益凭证","cpmc":"财慧通571号","cptabh":"67","cptgr":"APS资产管理","sclx":"场外"},
     * {"cpdm":"SRQ443","cpfxdj":"R1 低风险","cpglr":"财通证券（总）","cpjc":"尊享宝中证500指数看跌105号","cplx":"收益凭证","cpmc":"尊享宝中证500指数看跌105号","cptabh":"67","cptgr":"财通证券（总）","jjjl":"林鸿一02","sclx":"场外"}]}
     */
}



