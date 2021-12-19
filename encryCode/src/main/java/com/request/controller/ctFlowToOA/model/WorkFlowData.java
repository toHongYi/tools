package com.request.controller.ctFlowToOA.model;

import java.util.ArrayList;


/**
 * @version : V1.0
 * @date : 2021/12/15 16:13
 * @Author : LLH
 * @Desc :  流程数据
 */
public class WorkFlowData {

    FormtableMain formtableMain;
    //ArrayList<Map<String, String>> formtableMainDt1 = new ArrayList<>();

    //将Map换成对象;
    ArrayList<FormtableMainDt> formtableMainDt1 = new ArrayList<>();



    @Override
    public String toString() {
        return "WorkFlowData{" +
                "formtableMain=" + formtableMain +
                ", formtableMainDt1=" + formtableMainDt1 +
                '}';
    }

}
