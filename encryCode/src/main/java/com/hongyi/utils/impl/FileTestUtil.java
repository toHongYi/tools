package com.hongyi.utils.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/15 9:32
 * @Author : LLH
 * @Desc :  用于数据库中文件与字符串之间的拼接;
 *      需要传入唯一ID;
 */
public class FileTestUtil {
    public static void main(String[] args) {
        //{"nextId":2,"items":[["0","20211202 (1).xlsx"],["1","财通证券资管聚丰2401号集合资产管理计划资产管理合同.doc"]]}
        String s = FileTestUtil.fileTransation("lcCPPSLC_CPXX", "QT", 310, 0);
        System.out.println("s = " + s);

    }


    /**
     *
     * @param
     * @param fileColumn
     * @param id
     * @return
     */
    public static String fileTransation(String fileColumn,String fileName, int id)  {

        String n = fileColumn;
        int y = id;
        String  mask = "{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\""+ n + "\",\"id\":" + y + ",\"entryNo\":0}";
        System.out.println("mask = " + mask);

        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String head = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";
        //final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";

        // fileName需要与fileColumn对照;
        String url = fileName + "|" + head + encode;
        System.out.println(url);

        return url;
    }

    public static String fileTransation(String fileName, String fileColumn1, int id1, int no1) {
        //表名
        String fileTable = fileName;
        //字段
        String fileColumn = fileColumn1;
        //lcCPPSLC_CPXX 唯一ID
        int y = id1;
        //文件编号
        int entryNo = no1;

        String  mask = "{\"fileTable\":\"lcCPPSLC_CPXX\",\"fileColumn\":\""+ fileColumn + "\",\"id\":" + y + ",\"entryNo\":"+entryNo+"}";
        System.out.println("mask = " + mask);

        String encode=null;
        try {
            encode = Base64.getEncoder().encodeToString(mask.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String head = "http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=";
        //final String CPHT = "SELECT ？ from lcCPPSLC_CPXX where id = ？;";

        // fileName需要与fileColumn对照;
        String url = fileName + "|" + head + encode;
        System.out.println(url);

        return url;

    }

    static class QTtransfrom{
        String fileTable;
        String fileColumn;
        int id;
        int entryNo;

        public QTtransfrom(String fileTable, String fileColumn, int id, int entryNo) {
            this.fileTable = fileTable;
            this.fileColumn = fileColumn;
            this.id = id;
            this.entryNo = entryNo;
        }

        public String getFileTable() {
            return fileTable;
        }

        public void setFileTable(String fileTable) {
            this.fileTable = fileTable;
        }

        public String getFileColumn() {
            return fileColumn;
        }

        public void setFileColumn(String fileColumn) {
            this.fileColumn = fileColumn;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEntryNo() {
            return entryNo;
        }

        public void setEntryNo(int entryNo) {
            this.entryNo = entryNo;
        }

        @Override
        public String toString() {
            return "QTtransfrom{" +
                    "fileTable='" + fileTable + '\'' +
                    ", fileColumn='" + fileColumn + '\'' +
                    ", id=" + id +
                    ", entryNo=" + entryNo +
                    '}';
        }
    }


    /**
     * 输入获取到的后台字段数据;
     *      {"nextId":2,"items":[["0","新人手册.docx"],["1","财券人力字[2021]28号 关于进一步做好当前新冠肺炎疫情防控工作的通知.pdf"]]}
     *          {
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
     *
     *          该找该字段,进行内部便利;
     *      获取到所有的所需链接,
     *
     * 注意：
     *      其中存在数据删除,前移;
     * @return
     */
    public List<String> fileTransationForQT(){

        return null;
    };


}