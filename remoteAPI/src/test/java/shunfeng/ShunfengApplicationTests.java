package com.lyl.shunfeng;

import com.lyl.shunfeng.bean.CreateExpressOrderReq;
import com.lyl.shunfeng.bean.xml.ShunFengResponse;
import com.lyl.shunfeng.enums.ShunFengOperation;
import com.lyl.shunfeng.service.ShunFengJsonExpressService;
import com.lyl.shunfeng.service.ShunFengXmlExpressService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShunfengApplicationTests {

    @Resource
    private ShunFengXmlExpressService shunFengXmlExpressService;
    @Resource
    private ShunFengJsonExpressService shunFengJsonExpressService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateOrderXml() {
        CreateExpressOrderReq createExpressOrderReq = new CreateExpressOrderReq();
        // 如果提示重复下单，把这个编号变一下
        createExpressOrderReq.setOrderId("20200121181653954019");
        createExpressOrderReq.setJProvince("广东省");
        createExpressOrderReq.setJCity("深圳市");
        createExpressOrderReq.setJCounty("南山区");
        createExpressOrderReq.setJCompany("金草中医");
        createExpressOrderReq.setJContact("李大宝");
        createExpressOrderReq.setJTel("18777276920");
        createExpressOrderReq.setJAddress("龙珠四路金谷创业园c座611");

        createExpressOrderReq.setDProvince("广东省");
        createExpressOrderReq.setDCity("广州市");
        createExpressOrderReq.setDCounty("海珠区");
        createExpressOrderReq.setDCompany("个人");
        createExpressOrderReq.setDContact("滕大宝");
        createExpressOrderReq.setDTel("18938905541");
        createExpressOrderReq.setDAddress("宝芝林大厦701室");
        ShunFengResponse shunFengResponse = shunFengXmlExpressService.shunFengOperationProcessor(createExpressOrderReq, ShunFengOperation.CRETE_ORDER);
    }

    @Test
    public void testSearchOrderXml() {
        // 下单返回的快递号
        String mailNo = "444021040295";
        ShunFengResponse shunFengResponse = shunFengXmlExpressService.shunFengOperationProcessor(mailNo, ShunFengOperation.ROUTE_SEARCH);
        System.out.println(shunFengResponse);
    }

    @Test
    public void testCancelOrderXml() {
        // 下单时传入的orderId
        String orderNo = "20200121181653954019";
        ShunFengResponse shunFengResponse = shunFengXmlExpressService.shunFengOperationProcessor(orderNo, ShunFengOperation.CANCEL_ORDER);
    }

    @Test
    public void testCreateOrderJson() {
        CreateExpressOrderReq createExpressOrderReq = new CreateExpressOrderReq();
        // 如果提示重复下单，把这个编号变一下
        createExpressOrderReq.setOrderId("20200121181653954088");
        createExpressOrderReq.setParcelQuantity(1);
        createExpressOrderReq.setExpressType(1);
        createExpressOrderReq.setJProvince("广东省");
        createExpressOrderReq.setJCity("深圳市");
        createExpressOrderReq.setJCounty("南山区");
        createExpressOrderReq.setJCompany("金草中医");
        createExpressOrderReq.setJContact("李大宝");
        createExpressOrderReq.setJTel("18777276920");
        createExpressOrderReq.setJAddress("龙珠四路金谷创业园c座611");

        createExpressOrderReq.setDProvince("广东省");
        createExpressOrderReq.setDCity("广州市");
        createExpressOrderReq.setDCounty("海珠区");
        createExpressOrderReq.setDCompany("个人");
        createExpressOrderReq.setDContact("滕大宝");
        createExpressOrderReq.setDTel("18938905541");
        createExpressOrderReq.setDAddress("宝芝林大厦701室");
        shunFengJsonExpressService.shunFengOperationProcessor(createExpressOrderReq, ShunFengOperation.CRETE_ORDER);
    }

    @Test
    public void testSearchOrderJson() {
        shunFengJsonExpressService.shunFengOperationProcessor("SF7444407995771", ShunFengOperation.ROUTE_SEARCH);
    }

    @Test
    public void testCancelOrderJson() {
        shunFengJsonExpressService.shunFengOperationProcessor("20200121181653954088", ShunFengOperation.CANCEL_ORDER);
    }
}
