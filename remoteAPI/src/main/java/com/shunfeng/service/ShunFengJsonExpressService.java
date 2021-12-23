package com.lyl.shunfeng.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyl.shunfeng.bean.CreateExpressOrderReq;
import com.lyl.shunfeng.bean.json.CancelOrderReq;
import com.lyl.shunfeng.bean.json.CreateExpressOrderJsonDTO;
import com.lyl.shunfeng.bean.json.SearchRouteReq;
import com.lyl.shunfeng.enums.ShunFengOperation;
import com.lyl.shunfeng.enums.ShunFengServieCodeEnum;
import com.lyl.shunfeng.util.HttpClientUtil;
import com.lyl.shunfeng.util.VerifyCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ShunFengJsonExpressService {

    private static Logger logger = LoggerFactory.getLogger(ShunFengJsonExpressService.class);
    /**
     * jackson的json转化类
     */


    // 测试环境请求url
    private static final String CALL_URL_BOX = "https://sfapi-sbox.sf-express.com/std/service";
    // 正式环境请求url
    private static final String CALL_URL_PROD = "https://sfapi.sf-express.com/std/service";
    // 顾客编码
    private static final String CLIENT_CODE = "Yg4Zf06w_sxZs3A5D";
    // 丰桥平台获取的校验码
    private static final String CHECKWORD = "3Xdk1jqeG1Xod9nUXus8Op7DNOkchTnw";
    // 顺丰月结卡号
    private static final String CUST_ID = "7551234567";

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 顺丰接口操作集合
     *
     * @param requestContent    请求内容
     * @param shunFengOperation 操作类型
     * @return
     */
    public String shunFengOperationProcessor(Object requestContent, ShunFengOperation shunFengOperation) {
        // 请求数据
        String requestJson = "";
        // 请求服务的类别
        ShunFengServieCodeEnum servieCode = null;
        switch (shunFengOperation) {
            case CRETE_ORDER: //创建订单
                CreateExpressOrderReq createExpressOrderReq = (CreateExpressOrderReq) requestContent;
                requestJson = getOrderServiceRequestJson(createExpressOrderReq);
                servieCode = ShunFengServieCodeEnum.EXP_RECE_CREATE_ORDER;
                break;
            case CANCEL_ORDER: //取消订单
                String orderNo = (String) requestContent;
                requestJson = getOrderCancelServiceRequestJson(orderNo);
                servieCode = ShunFengServieCodeEnum.EXP_RECE_UPDATE_ORDER;
                break;
            case ROUTE_SEARCH: //路由查询
                String mailNo = (String) requestContent;
                requestJson = getRouteServiceRequestJson(mailNo);
                servieCode = ShunFengServieCodeEnum.EXP_RECE_SEARCH_ROUTES;
                break;
            default:
                break;
        }

        Map<String, String> params = new HashMap<>(8);
        String timeStamp = String.valueOf(System.currentTimeMillis());
        // 合作伙伴编码（即顾客编码）
        params.put("partnerID", CLIENT_CODE);
        params.put("requestID", UUID.randomUUID().toString().replace("-", ""));
        // 接口服务代码（到API接口详情查看具体服务代码）
        params.put("serviceCode", servieCode.name());
        // 时间戳
        params.put("timestamp", timeStamp);
        // 业务数据报文
        params.put("msgData", requestJson);
        // 数字签名  加密串规则 msgData（业务报文）+ timestamp+checkWord(客户校验码)
        try {
            params.put("msgDigest", VerifyCodeUtil.getDigest(requestJson + timeStamp + CHECKWORD));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = null;
        try {
            result = HttpClientUtil.post(CALL_URL_BOX, params);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("请求报文：{}", params.get("msgData"));
        logger.info("响应报文：{}", result);
        return result;
    }

    /**
     * 获取下单请求体
     *
     * @param createExpressOrderReq
     * @return
     */
    private String getOrderServiceRequestJson(CreateExpressOrderReq createExpressOrderReq) {

        CreateExpressOrderJsonDTO req = new CreateExpressOrderJsonDTO();
        req.setLanguage("zh_CN");
        // 月结卡号
        req.setMonthlyCard(CUST_ID);
        req.setOrderId(createExpressOrderReq.getOrderId());
        req.setParcelQty(createExpressOrderReq.getParcelQuantity());
        req.setExpressTypeId(createExpressOrderReq.getExpressType());
        // 寄件基本信息
        CreateExpressOrderJsonDTO.CargoDetailsBean detailsBean = new CreateExpressOrderJsonDTO.CargoDetailsBean();
        detailsBean.setCurrency("HKD");
        detailsBean.setName("医药");
        detailsBean.setSourceArea("CHN");
        List<CreateExpressOrderJsonDTO.CargoDetailsBean> cargoDetailsBeanList = Collections.singletonList(detailsBean);
        req.setCargoDetails(cargoDetailsBeanList);
        // 寄件人信息
        CreateExpressOrderJsonDTO.ContactInfoListBean senderInfo = new CreateExpressOrderJsonDTO.ContactInfoListBean();
        senderInfo.setCountry("CN");
        senderInfo.setContactType(1);
        senderInfo.setProvince(createExpressOrderReq.getJProvince());
        senderInfo.setCity(createExpressOrderReq.getJCity());
        senderInfo.setAddress(createExpressOrderReq.getJAddress());
        senderInfo.setCompany(createExpressOrderReq.getJCompany());
        senderInfo.setContact(createExpressOrderReq.getJContact());
        senderInfo.setTel(createExpressOrderReq.getJTel());
        // 收件人信息
        CreateExpressOrderJsonDTO.ContactInfoListBean receiverInfo = new CreateExpressOrderJsonDTO.ContactInfoListBean();
        receiverInfo.setCountry("CN");
        receiverInfo.setContactType(2);
        receiverInfo.setProvince(createExpressOrderReq.getDProvince());
        receiverInfo.setCity(createExpressOrderReq.getDCity());
        receiverInfo.setAddress(createExpressOrderReq.getDAddress());
        receiverInfo.setCompany(createExpressOrderReq.getDCompany());
        receiverInfo.setContact(createExpressOrderReq.getDContact());
        receiverInfo.setTel(createExpressOrderReq.getDTel());
        List<CreateExpressOrderJsonDTO.ContactInfoListBean> contactInfoListBeanList = Arrays.asList(senderInfo, receiverInfo);
        req.setContactInfoList(contactInfoListBeanList);

        return objectToJson(req);
    }

    /**
     * 根据快递号查询快递记录
     *
     * @param mailNo 快递运单号
     * @return
     */
    private String getRouteServiceRequestJson(String mailNo) {
        SearchRouteReq searchRouteReq = new SearchRouteReq();
        searchRouteReq.setLanguage(0);
        searchRouteReq.setMethodType(1);
        // 根据快递号查询
        searchRouteReq.setTrackingType(1);
        searchRouteReq.setTrackingNumber(Collections.singletonList(mailNo));
        return objectToJson(searchRouteReq);
    }

    /**
     * 取消顺丰订单请求体
     *
     * @param orderNo 订单号
     * @return
     */
    private String getOrderCancelServiceRequestJson(String orderNo) {
        CancelOrderReq req = new CancelOrderReq();
        req.setDealType(2);
        req.setConfirmType(3);
        req.setLanguage("zh-CN");
        req.setOrderId(orderNo);
        return objectToJson(req);
    }

    /**
     * object转为json
     *
     * @param obj 实体类
     * @return java.lang.String
     * @author Li Yulong
     * @date 2020-08-12 21:38
     */
    private String objectToJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}