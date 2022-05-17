package com.hongyi.inputList;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @version : V1.0
 * @date : 2022/3/9 8:48
 * @Author : LLH
 * @Desc :
 */
public class InputrList {
    public static void main(String[] args) {
        String URL_DOWN_HEAD = "HHHH-MM-SS";
        String DATABASE = "lcCPPSLC_CPXX";
        String QT ="{\"nextId\":1,\"items\":[[\"0\",\"20211215110625466证券理财参数信息表（财运通、财鑫通）.xlsx\"]]}";

        String QT2="{\"items\":[{\"产品代码\":111,\"产品简称\":\"大太阳\"},{\"产品代码\":322,\"产品简称\":\"小西瓜\"},{\"产品代码\":233,\"产品简称\":\"黑眼圈\"}]}";

        int id = 1021;
        HashMap<String, String> mapQT = new HashMap<>();

        qtTranFormToMap(URL_DOWN_HEAD,DATABASE,QT, id,mapQT);

    }


    /**
     * 其他字段处理
     * @param URL_DOWN_HEAD
     * @param DATABASE      //数据库名称;
     * @param qtString      //数据库中提取的数据;
     * @param id            //唯一ID
     * @param mapQT         //
     */
    public static void qtTranFormToMap(String URL_DOWN_HEAD,String DATABASE,String qtString, Integer id, HashMap<String, String> mapQT) {

        List<String> listQT = new ArrayList();

        //将字段转为map;
        Map stringToMap =  JSONObject.parseObject(qtString);

        //获取到需处理的数据;
        List items = (List) stringToMap.get("items");

        //处理此数组;
        for (Object item : items) {
            String element = item.toString();

            //处理首位数据: 去除 "[" 和 "]"
            String s3 = trimFirstAndLastChar(element, "[");
            String cleanS4 = trimFirstAndLastChar(s3, "]");
            //System.out.println("看看调试完成后的数据形式如何:cleanS4 = " + cleanS4);

            //将首尾干净数据再处理: 去除","
            List split = Arrays.asList(cleanS4.split(","));

            String  qTno = (String) split.get(0);
            //文件名
            String fileName = (String) split.get(1);

            qTno = trimFirstAndLastChar(qTno, "\"");
            fileName = trimFirstAndLastChar(fileName, "\"");

            //该组唯一ID;
            int initID = id;
            //字段名
            String QTColumn1 ="QT";
            //文件名
            String FileName = fileName;
            //第几位;
            int QTnoNo = Integer.valueOf(qTno);

            String fileTable = DATABASE;

            //格式转换;
            String urlQT = fileTransform(URL_DOWN_HEAD,fileTable,FileName, QTColumn1, initID,QTnoNo);
            listQT.add(urlQT);
            mapQT.put(FileName,urlQT);
        }
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
