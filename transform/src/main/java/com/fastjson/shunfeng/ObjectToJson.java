package com.fastjson.shunfeng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @version : V1.0
 * @date : 2021/12/27 8:48
 * @Author : LLH
 * @Desc :
 */
public class ObjectToJson {
    public static void main(String[] args) {
        Pifflowinfo pifflowinfo = new Pifflowinfo(2, 0, "测试1", "测试2");
        System.out.println("pifflowinfo.toString() = " + pifflowinfo.toString());
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","测试效果");
        map.put("2",pifflowinfo);
        /**
         * "2": {
         *       "approvalAction": 0,
         *       "approvalUserId": "测试1",
         *       "instID": 2,
         *       "workflowName": "测试2"
         *     },
         */
        map.put("3",pifflowinfo.toString());
        // "3": "Pifflowinfo{InstID=2, approvalAction=0, approvalUserId='测试1', workflowName='测试2'}",
        map.put("4",JSONObject.toJSONString(pifflowinfo));
        //"4": "{\"approvalAction\":0,\"approvalUserId\":\"测试1\",\"instID\":2,\"workflowName\":\"测试2\"}"
        map.put("5",JSONObject.toJSON(pifflowinfo));
        /**
         * "5": {
         *       "instID": 2,
         *       "workflowName": "测试2",
         *       "approvalUserId": "测试1",
         *       "approvalAction": 0
         *     }
         */


        /**
         * map转json:
         *      String toOA = JSON.toJSONString(map1);
         * JSON字符串转JSON对象:
         *      JSONObject.parseObject(toOA)
         *
         */

        System.out.println("map1 = " + map.toString());     //两者一样;
        System.out.println("map2 = " + map);

        JSONObject json = new JSONObject();
        json.put("A",map);
        json.put("B",map.toString());   //不可;转换成String后便会在内容两头加上双引号"";
        System.out.println("json.toString() = " + json.toString());



    }



    /**
     * pifflowinfo字段处理;
     */
    static class Pifflowinfo{
        Integer InstID;
        Integer approvalAction;
        String approvalUserId;
        String workflowName;

        public Pifflowinfo(Integer instID, Integer approvalAction, String approvalUserId, String workflowName) {
            InstID = instID;
            this.approvalAction = approvalAction;
            this.approvalUserId = approvalUserId;
            this.workflowName = workflowName;
        }

        public Integer getInstID() {
            return InstID;
        }

        public void setInstID(Integer instID) {
            InstID = instID;
        }

        public Integer getApprovalAction() {
            return approvalAction;
        }

        public void setApprovalAction(Integer approvalAction) {
            this.approvalAction = approvalAction;
        }

        public String getApprovalUserId() {
            return approvalUserId;
        }

        public void setApprovalUserId(String approvalUserId) {
            this.approvalUserId = approvalUserId;
        }

        public String getWorkflowName() {
            return workflowName;
        }

        public void setWorkflowName(String workflowName) {
            this.workflowName = workflowName;
        }

        @Override
        public String toString() {
            return "Pifflowinfo{" +
                    "InstID=" + InstID +
                    ", approvalAction=" + approvalAction +
                    ", approvalUserId='" + approvalUserId + '\'' +
                    ", workflowName='" + workflowName + '\'' +
                    '}';
        }
}
}
