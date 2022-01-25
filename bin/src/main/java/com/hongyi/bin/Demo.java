package com.hongyi.bin;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @version : V1.0
 * @date : 2022/1/10 9:28
 * @Author : LLH
 * @Desc :
 */
public class Demo {
    public static void main(String[] args) {

        /**
         *            for (PublicFundSearchRecordModel model : iPage.getRecords()) {
         *                 PublicFundSearchRecord.Builder publicFundSearchRecordBuilder = PublicFundSearchRecord.newBuilder();
         *                     //获取内部prodCode做唯一标识,与FavoriteList中数据进行对比,判断是否存在依存情况。
         *                     //增加返回前端字段,  该字段标记为是否是用户收藏。             工厂模式,对数据进行处理的一种方案,转移到主对象中;
         *                 BeanCopyUtils.toProtoBean(publicFundSearchRecordBuilder, model);    //??
         *                 builder.addRecords(publicFundSearchRecordBuilder.build());          //?将数据存入builder之中; 通过builder将数据转存成符合RPC需求的数据;
         *             }
         */
        String VISITOR_AUTHORIZATION_STATE = "用户未登录";

        String visitor = "test1";
        String visitor2 = "VISITOR_AUTHORIZATION_STATE";


        boolean visitor_authorization_state = visitor2.equals(VISITOR_AUTHORIZATION_STATE);
        System.out.println("visitor_authorization_state = " + visitor_authorization_state);

    }
}
