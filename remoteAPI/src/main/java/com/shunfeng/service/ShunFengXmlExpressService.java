package com.shunfeng.service;

import com.jarTest.shunfeng.util.HttpClientUtil;
import com.jarTest.shunfeng.util.VerifyCodeUtil;

import com.shunfeng.bean.CreateExpressOrderReq;
import com.shunfeng.bean.xml.ShunFengResponse;
import com.shunfeng.enums.ShunFengOperation;
import com.shunfeng.util.XmlHelper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class ShunFengXmlExpressService {

    private static Logger logger = LoggerFactory.getLogger(ShunFengXmlExpressService.class);
    /**
     * 顺丰快递请求url
     */
    private static final String REQUEST_URL = "http://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
    /**
     * 丰桥平台获取的校验码
     */
    private static final String CHECKWORD = "FBIqMkZjzxbsZgo7jTpeq7PD8CVzLT4Q";
    /**
     * 顺丰月结卡号
     */
    private static final String CUST_ID = "7551234567";
    /**
     * 顾客编码
     */
    private static final String CLIENT_CODE = "SLKJ2019";

    /**
     * 顺丰接口操作集合
     *
     * @param requestContent    请求内容
     * @param shunFengOperation 操作类型
     * @return
     */
    public ShunFengResponse shunFengOperationProcessor(Object requestContent, ShunFengOperation shunFengOperation) {
        String requestXml = "";
        switch (shunFengOperation) {
            case CRETE_ORDER: //创建订单
                CreateExpressOrderReq createExpressOrderReq = (CreateExpressOrderReq) requestContent;
                requestXml = getOrderServiceRequestXml(createExpressOrderReq);
                break;
            case CANCEL_ORDER: //取消订单
                String orderNo = (String) requestContent;
                requestXml = getOrderCancelServiceRequestXml(orderNo);
                break;
            case ROUTE_SEARCH: //路由查询
                String mailNo = (String) requestContent;
                requestXml = getRouteServiceRequestXml(mailNo);
                break;
            default:
                break;
        }

        /* 加密校验 */
        String verifyCode = VerifyCodeUtil.md5EncryptAndBase64(requestXml + CHECKWORD);
        String respXml = null;
        /* 请求顺丰服务器 */
        try {
            respXml = HttpClientUtil.postSFAPI(REQUEST_URL, requestXml, verifyCode);
        } catch (Exception var6) {
            logger.warn(" " + var6);
        }
//        logger.info("请求报文：{}", requestXml);
//        logger.info("响应报文：{}", respXml);
//        return XmlHelper.xmlToBeanForSF(respXml);
        return null;
    }

    /**
     * 获取下单请求体
     * @param createExpressOrderReq
     * @return
     */
    private String getOrderServiceRequestXml(CreateExpressOrderReq createExpressOrderReq) {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<?xml version='1.0' encoding='UTF-8'?>");
        strBuilder.append("<Request service='OrderService' lang='zh-CN'>");
        strBuilder.append("<Head>" + CLIENT_CODE + "</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<Order ");
        strBuilder.append("orderid='").append(createExpressOrderReq.getOrderId()).append("' ");
        //返回顺丰运单号
        strBuilder.append("express_type='1' ");
        //寄件方信息
        strBuilder.append("j_province='").append(createExpressOrderReq.getJProvince()).append("' ");
        strBuilder.append("j_city='").append(createExpressOrderReq.getJCity()).append("' ");
        strBuilder.append("j_county='").append(createExpressOrderReq.getJCounty()).append("' ");
        strBuilder.append("j_company='").append(createExpressOrderReq.getJCompany()).append("' ");
        strBuilder.append("j_contact='").append(createExpressOrderReq.getJContact()).append("' ");
        strBuilder.append("j_tel='").append(createExpressOrderReq.getJTel()).append("' ");
        strBuilder.append("j_address='").append(createExpressOrderReq.getJAddress()).append("' ");
        //收件方信息
        strBuilder.append("d_province='").append(createExpressOrderReq.getDProvince()).append("' ");
        strBuilder.append("d_city='").append(createExpressOrderReq.getDCity()).append("' ");
        strBuilder.append("d_county='").append(createExpressOrderReq.getDCounty()).append("' ");
        strBuilder.append("d_company='").append(createExpressOrderReq.getDCompany()).append("' ");
        strBuilder.append("d_tel='").append(createExpressOrderReq.getDTel()).append("' ");
        strBuilder.append("d_contact='").append(createExpressOrderReq.getDContact()).append("' ");
        strBuilder.append("d_address='").append(createExpressOrderReq.getDAddress()).append("' ");
        if (!StringUtils.isEmpty(createExpressOrderReq.getRemark())) {
            strBuilder.append("remark='").append(createExpressOrderReq.getRemark()).append("' ");
        }
        //货物信息
        strBuilder.append("parcel_quantity='1' ");
        strBuilder.append("pay_method='1' ");
        strBuilder.append("custid ='").append(ShunFengXmlExpressService.CUST_ID).append("' ");
        strBuilder.append("customs_batchs='' ");
        strBuilder.append("cargo='医药'").append(">");
//        strBuilder.append("<AddedService name='COD' value='1.01' value1='7551234567' />");
        strBuilder.append("</Order>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        return strBuilder.toString();
    }

    /**
     * 根据快递号查询快递记录
     * @param mailNo 快递运单号
     * @return
     */
    private String getRouteServiceRequestXml(String mailNo){
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<Request service='RouteService' lang='zh-CN'>" +
                "<Head>" + CLIENT_CODE + "</Head>" +
                "<Body>" +
                "<RouteRequest " +
                "tracking_type='1' " +
                "method_type='1' " +
                "tracking_number='" + mailNo + "'/>" +
                "</Body>" +
                "</Request>";
    }

    /**
     * 根据订单号查询下单请求体
     * @param orderNo 订单号
     * @return
     */
    private String getOrderSearchServiceRequestXml(String orderNo) {

        return "<Request service='OrderSearchService' lang='zh-CN'>" +
                "<Head>" + CLIENT_CODE + "</Head>" +
                "<Body>" +
                "<OrderSearch " +
                "orderid='" + orderNo + "'" + " /> " +
                "</Body>" +
                "</Request>";
    }

    /**
     * 取消顺丰订单请求体
     * @param orderNo 订单号
     * @return
     */
    private String getOrderCancelServiceRequestXml(String orderNo) {

        return "<Request service='OrderConfirmService' lang='zh-CN'>" +
                "<Head>" + CLIENT_CODE + "</Head>" +
                "<Body>" +
                "<OrderConfirm " +
                "orderid='" + orderNo + "' " +
                "dealtype='2'" +
                " /> " +
                "</Body>" +
                "</Request>";
    }
}