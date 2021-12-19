package com.hongyi.test;

import com.alibaba.fastjson.JSONObject;
import com.hongyi.utils.impl.FileTestUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @version : V1.0
 * @date : 2021/12/19 20:52
 * @Author : LLH
 * @Desc :
 */
public class TransitionOA {
    public static void main(String[] args) {


        String write = " {\"nextId\":2,\"items\":[[\"0\",\"新人手册.docx\"],[\"1\",\"财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf\"]]}";
        System.out.println("write = " + write);

        Map stringToMap =  JSONObject.parseObject(write);
        System.out.println("stringToMap = " + stringToMap);


        List items = (List) stringToMap.get("items");
        for (Object item : items) {
            System.out.println("=================================【测试输出开始】==============================================");

            String element = item.toString();
            System.out.println("测试一下item是否执行完毕:ELEMENT = " + element); //["0","新人手册.docx"]

            //处理首位数据;
            String s3 = trimFirstAndLastChar(element, "[");
            String s4 = trimFirstAndLastChar(s3, "]");
            System.out.println("看看调试完成后的数据形式如何:s4 = " + s4);

            //将首尾干净数据再处理;
            List split = Arrays.asList(s4.split(","));
            System.out.println("split = " + split);
            for (Object o : split) {
                System.out.println("o = " + o);
            }

            String title = (String) split.get(0);
            String content = (String) split.get(1);

            title = trimFirstAndLastChar(title, "\"");
            content = trimFirstAndLastChar(content, "\"");

            String QTColumn1 ="QT";
            int QTnoNo = Integer.valueOf(title);
            String QTcontent = content;

            System.out.println("QTnoNo = " + QTnoNo);
            System.out.println("QTcontent = " + QTcontent);


            String s2 = FileTestUtil.fileTransation(QTColumn1, QTcontent, 270,QTnoNo);

            System.out.println("=================================【测试输出完成】==============================================");
        }
        System.out.println("测试完成");

    }

    /**
     * 去除首尾指定字符
     * @param str   字符串
     * @param element   指定字符
     * @return
     */
    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }


    class Item {
        int fileId;
        String fileName;

        public int getFileId() {
            return fileId;
        }

        public void setFileId(int fileId) {
            this.fileId = fileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "fileId=" + fileId +
                    ", fileName='" + fileName + '\'' +
                    '}';
        }
    }

}
