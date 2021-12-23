package com.lyl.shunfeng.bean.json;

import lombok.Data;

import java.util.List;

/**
 * 下单请求体
 * @author Li Yulong
 * @date 2020-08-12 20:08
 */
@Data
public class CreateExpressOrderJsonDTO {

    /**
     * cargoDetails : [{"count":2.365,"unit":"个","weight":6.1,"amount":100.5111,"currency":"HKD","name":"护肤品1","sourceArea":"CHN"}]
     * contactInfoList : [{"address":"广东省深圳市南山区软件产业基地11栋","contact":"小曾","contactType":1,"country":"CN","postCode":"580058","tel":"4006789888"},{"address":"广东省广州市白云区湖北大厦","company":"顺丰速运","contact":"小邱","contactType":2,"country":"CN","postCode":"580058","tel":"18688806057"}]
     * language : zh_CN
     * orderId : OrderNum20200612223
     */
    // 月结卡号
    private String monthlyCard;
    private String language;
    private String orderId;
    // 包裹数，一个包裹对应一个运单号；若包裹数大于1，则返回一个母运单号和N-1个子运单号
    private int parcelQty;
    // 快件产品类别，支持附录《快件产品类别表》的产品编码值，仅可使用与顺丰销售约定的快件产品
    private Integer expressTypeId;
    private List<CargoDetailsBean> cargoDetails;
    private List<ContactInfoListBean> contactInfoList;
    @Data
    public static class CargoDetailsBean {
        /**
         * count : 2.365
         * unit : 个
         * weight : 6.1
         * amount : 100.5111
         * currency : HKD
         * name : 护肤品1
         * sourceArea : CHN
         */
        // 货物数量 跨境件报关需要填写。我们快递不跨境，所以以下四个字段可以不用
//        private double count;
        // 货物单位，如：个、台、本，跨境件报关需要填写
//        private String unit;
        // 订单货物单位重量，包含子母件，单位千克，精确到小数点后3位,跨境件报关需要填写
//        private double weight;
        // 	货物单价，精确到小数点后3位，跨境件报关需要填写
//        private double amount;
        // 货物单价的币别:参照附录币别代码附件
        private String currency;
        // 货物名称，如果需要生成电子运单，则为必填
        private String name;
        // 原产地国别，跨境件报关需要填写
        private String sourceArea;
    }
    @Data
    public static class ContactInfoListBean {
        /**
         * address : 广东省深圳市南山区软件产业基地11栋
         * contact : 小曾
         * contactType : 1
         * country : CN
         * postCode : 580058
         * tel : 4006789888
         * company : 顺丰速运
         */
        //地址类型：1，寄件方信息 2，到件方信息
        private int contactType;
        // 所在省级行政区名称，必须是标准的省级行政区名称如：北京、广东省、广西壮族自治区等
        private String province;
        // 所在地级行政区名称，必须是标准的城市称谓 如：北京市、深圳市、大理白族自治州等
        private String city;
        // 详细地址，若province/city 字段的值不传，此字段必须包
        //含省市信息，避免影响原寄地代码识别，如：广东省深圳市福田区新洲十一街万基商务大厦10楼；若需要生成电子运单，则为必填
        private String address;
        // 联系人
        private String contact;
        // 	国家或地区 2位代码 参照附录国家代码附件
        private String country;
        // 邮编，跨境件必填（中国内地，港澳台互寄除外）
//        private String postCode;
        // 联系电话
        private String tel;
        // 公司名称
        private String company;
    }
}
