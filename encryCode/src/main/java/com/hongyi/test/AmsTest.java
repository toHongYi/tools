package com.hongyi.test;

import com.alibaba.fastjson.JSONObject;
import com.hongyi.mode.FormtableMain;
import com.hongyi.mode.RequestData;
import com.hongyi.mode.WorkFlowData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version : V1.0
 * @date : 2021/12/15 17:18
 * @Author : LLH
 * @Desc :
 */
public class AmsTest {
    public static void main(String[] args) {
        /**
         * 创建workFlowData中formtableMainDt1数组数据;
         */
        ArrayList<Map<String, String>> formtableMainDt1 = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("cpmc","test1");
        map.put("cpdm","test1");
        map.put("cplx","test1");
        map.put("cptgr","test1");
        formtableMainDt1.add(map);
        /**
         * 创建workFlowData中formtableMainDt1数组数据;
         */
        Map<String, String> map2 = new HashMap<>();
        map2.put("cpmc","test2");
        map2.put("cpdm","test2");
        map2.put("cplx","test2");
        map2.put("cptgr","test2");
        formtableMainDt1.add(map2);
        System.out.println("formtableMainDt1 = " + formtableMainDt1);

        /**
         * 创建workFlowData 中 formtableMain
         */
        //一个对象;
        FormtableMain formtableMain = new FormtableMain();

        formtableMain.setApplicationreasons("test1");

        List<String> list = new ArrayList<String>();
        list.add("白名单准入流程需求说明书1.docx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJ2UElGX0NQV0RLIiwiZmlsZUNvbHVtbiI6IkZKIiwiaWQiOjkwMzY4NSwiZW50cnlObyI6MH0=");
        list.add("白名单准入流程需求说明书2.docx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJ2UElGX0NQV0RLIiwiZmlsZUNvbHVtbiI6IkZKIiwiaWQiOjkwMzY4NSwiZW50cnlObyI6MH0=");
        formtableMain.setBjs(list);
        System.out.println("list = " + list);
        /**
         * 添加workFlowData数据;
         */
        WorkFlowData workFlowData = new WorkFlowData();
//        workFlowData.setFormtableMain(formtableMain);
//        workFlowData.setFormtableMainDt1(formtableMainDt1);
        //workFlowData.setFormtableMain();

        /**
         * 添加requestData中的数据;
         */
        RequestData requestData = new RequestData();
        requestData.setWorkFlowData(workFlowData);
        //System.out.println("requestData = " + requestData);
        requestData.setRequestId(11);
        requestData.setRequestSubject("好像");

        /**
         *  格式转换;
         */
        String s = JSONObject.toJSONString(requestData);
        System.out.println("s = " + s);
//
//        //2.创建jackson的核心对象  ObjectMApper
//        ObjectMapper mapper = new ObjectMapper();
//        //3.转换
//        String json = mapper.writeValueAsString(p);
//        System.out.println(json);



    }
}
