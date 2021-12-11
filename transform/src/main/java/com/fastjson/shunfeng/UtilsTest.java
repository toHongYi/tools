package com.fastjson.shunfeng;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @version : V1.0
 * @date : 2021/12/2 11:24
 * @Author : LLH
 * @Description :
 */
public class UtilsTest {
    public static void main(String[] args) {

        String str1 = "{\n" +
                "  \"apiErrorMsg\": \"\",\n" +
                "  \"apiResponseID\": \"00017D791483CF3FDEE7928FA577EA3F\",\n" +
                "  \"apiResultCode\": \"A1000\",\n" +
                "  \"apiResultData\": \"{\\\"success\\\":true,\\\"errorCode\\\":\\\"S0000\\\",\\\"errorMsg\\\":null,\\\"msgData\\\":{\\\"routeResps\\\":[{\\\"mailNo\\\":\\\"SF1412955438811\\\",\\\"routes\\\":[{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-21 17:15:11\\\",\\\"remark\\\":\\\"顺丰速运 已收取快件\\\",\\\"opCode\\\":\\\"54\\\"},{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-21 17:16:24\\\",\\\"remark\\\":\\\"顺丰速运 已收取快件\\\",\\\"opCode\\\":\\\"50\\\"},{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-21 19:48:18\\\",\\\"remark\\\":\\\"快件在【苏州市太仓市国际塑化城营业点】完成分拣,准备发往 【苏州昆山中转场】\\\",\\\"opCode\\\":\\\"30\\\"},{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-21 20:57:09\\\",\\\"remark\\\":\\\"快件已发车\\\",\\\"opCode\\\":\\\"36\\\"},{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-21 21:49:24\\\",\\\"remark\\\":\\\"快件到达 【苏州昆山中转场】\\\",\\\"opCode\\\":\\\"31\\\"},{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-21 23:38:42\\\",\\\"remark\\\":\\\"快件在苏州昆山中转场完成分拣,准备发往下一站\\\",\\\"opCode\\\":\\\"30\\\"},{\\\"acceptAddress\\\":\\\"苏州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 00:47:32\\\",\\\"remark\\\":\\\"快件已发车\\\",\\\"opCode\\\":\\\"36\\\"},{\\\"acceptAddress\\\":\\\"杭州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 07:04:08\\\",\\\"remark\\\":\\\"快件到达 【龙都营业站】\\\",\\\"opCode\\\":\\\"31\\\"},{\\\"acceptAddress\\\":\\\"杭州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 07:52:45\\\",\\\"remark\\\":\\\"正在派送途中,请您准备签收(派件人:周阳,电话:18658112859)\\\",\\\"opCode\\\":\\\"44\\\"},{\\\"acceptAddress\\\":\\\"杭州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 07:55:27\\\",\\\"remark\\\":\\\"快件交给周阳,正在派送途中（联系电话：18658112859,顺丰已开启“安全呼叫”保护您的电话隐私,请放心接听！）（主单总件数：1件）\\\",\\\"opCode\\\":\\\"204\\\"},{\\\"acceptAddress\\\":\\\"杭州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 08:57:09\\\",\\\"remark\\\":\\\"快件派送至【丰巢智能快递柜】,请您凭取件码至康新花园B幢 电梯候梯厅旁丰巢柜领取您的快递.\\\",\\\"opCode\\\":\\\"125\\\"},{\\\"acceptAddress\\\":\\\"杭州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 19:03:18\\\",\\\"remark\\\":\\\"已签收(丰巢签收),感谢使用顺丰,期待再次为您服务（主单总件数：1件）\\\",\\\"opCode\\\":\\\"80\\\"},{\\\"acceptAddress\\\":\\\"杭州市\\\",\\\"acceptTime\\\":\\\"2021-11-22 19:03:19\\\",\\\"remark\\\":\\\"在官网\\\\\\\"运单资料&签收图\\\\\\\",可查看签收人信息\\\",\\\"opCode\\\":\\\"8000\\\"}]}]}}\"\n" +
                "}";
        //System.out.println("str1 = " + str1);
//        System.out.println(json);//输出 Hello
     //   String str12 = "{\"resourceId\":\"dfead70e4ec5c11e43514000ced0cdcaf\",\"properties\":{\"process_id\":\"process4\",\"name\":\"\",\"documentation\":\"\",\"processformtemplate\":\"\"}}";
        //JSONObject parseObject = JSONObject.parseObject(str1);

        //先把字符串转对象;再获取其中一段字符串;再将这一段字符串转为需要的格式;

        //5.jsonObject转map
        Map jsonObject = JSONObject.parseObject(str1);
        System.out.println("parseObject = " + jsonObject);
        //获取其中报文;
        Object apiResultData = jsonObject.get("apiResultData");
        System.out.println("apiResultData:"+apiResultData);

//        jsonObject.put("apiResultData",apiResultData);
//        System.out.println("apiResultData再试试 = " + jsonObject);

    }
}
