//package com.shunfeng.controller;
//
//
//import com.lyl.shunfeng.bean.xml.ShunFengResponse;
//import com.lyl.shunfeng.util.XmlHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/callback/")
//public class CallbackController {
//
//	private static Logger LOGGER = LoggerFactory.getLogger(CallbackController.class);
//
//	@PostMapping(value="sf/route")
//	public String shunFengCallback(String content) {
//
//		LOGGER.info("顺丰路由推送响应参数  content:{}", content);
//		ShunFengResponse response = XmlHelper.xmlToBeanForSF(content);
//		// 根据接收到的content进行具体操作
//
//		return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
//				"<Response service=\"RoutePushService\">" +
//				"<Head>OK</Head>" +
//				"</Response>";
//	}
//}
