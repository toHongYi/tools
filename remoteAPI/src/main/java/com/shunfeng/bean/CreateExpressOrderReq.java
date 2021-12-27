package com.shunfeng.bean;

import lombok.Data;

/**
 * 快递下单信息
 *
 * @author 李宇龙
 * @date 2019/2/14 11:52
 */
@Data
public class CreateExpressOrderReq {

    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 寄件人省份
     */
    private String jProvince;
    /**
     * 寄件人城市
     */
    private String jCity;
    /**
     * 寄件人区域
     */
    private String jCounty;
    /**
     * 寄件公司名称
     */
    private String jCompany;
    /**
     * 寄件联系人
     */
    private String jContact;
    /**
     * 寄件联系电话
     */
    private String jTel;
    /**
     * 寄件地址
     */
    private String jAddress;

    /**
     * 收件省份
     */
    private String dProvince;
    /**
     * 收件城市
     */
    private String dCity;
    /**
     * 收件人人区域
     */
    private String dCounty;
    /**
     * 收件公司名称
     */
    private String dCompany;
    /**
     * 收件联系人
     */
    private String dContact;
    /**
     * 收件联系电话
     */
    private String dTel;
    /**
     * 收件地址
     */
    private String dAddress;
    /**
     * 备注
     */
    private String remark;
    /**
     * 快递类别 1：顺丰标快
     */
    private int expressType;
    /**
     * 月结卡号
     */
    private String custId;
    /**
     * 包裹数
     */
    private Integer parcelQuantity;
    /**
     * 操作人编号
     */
    private String adminNo;
}
