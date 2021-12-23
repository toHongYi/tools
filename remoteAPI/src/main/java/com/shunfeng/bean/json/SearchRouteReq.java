package com.lyl.shunfeng.bean.json;

import lombok.Data;

import java.util.List;

/**
 * 路由查询请求ti
 * @author Li Yulong
 * @date 2020-08-12 21:30
 */
@Data
public class SearchRouteReq {


    /**
     * language : 0
     * trackingType : 1
     * trackingNumber : ["444003077898","441003077850"]
     * methodType : 1
     */
    // 返回描述语语言 0：中文 1：英文 2：繁体
    private int language;
    // 查询号类别:
    //1:根据顺丰运单号查询,trackingNumber将被当作顺丰运单号处理
    //2:根据客户订单号查询,trackingNumber将被当作客户订单号处理
    private int trackingType;
    // 路由查询类别: 1:标准路由查询 2:定制路由查询
    private int methodType;
    // 查询号:
    //trackingType=1,则此值为顺丰运单号
    //如果trackingType=2,则此值为客户订单号
    private List<String> trackingNumber;
}
