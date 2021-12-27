package com.shunfeng.bean.json;

import lombok.Data;

import java.util.List;

/**
 * 取消订单
 * @author Li Yulong
 * @date 2020-08-12 21:41
 */
@Data
public class CancelOrderReq {


    /**
     * confirmType : 3
     * dealType : 2
     * language : zh-CN
     * orderId : eb21c793-a45a-4d1e-9a2e-1b6e0cd49668
     * totalWeight : 1
     * waybillNoInfoList : []
     */

    private int confirmType;
    // 客户订单操作标识: 1:确认 2:取消
    private int dealType;
    // 语言 zh-CN
    private String language;
    // 客户订单号
    private String orderId;
}
