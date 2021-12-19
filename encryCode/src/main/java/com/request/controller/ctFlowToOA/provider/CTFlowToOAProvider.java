package com.request.controller.ctFlowToOA.provider;

import com.alibaba.fastjson.JSONObject;
import com.apex.ams.server.AmsService;
import com.apexsoft.crm.ctFlowToOA.dao.CTFlowToOADao;
import com.apexsoft.crm.ctFlowToOA.model.ReceiveModelByInstID;
import io.grpc.stub.StreamObserver;
import ip.base.ctFlowToOA.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @Author zws
 * @Date 2021/12/15 17:23
 * @Version : V1.0
 */
@AmsService(version = "1.0.1")
public class CTFlowToOAProvider extends CTFlowToOAServiceGrpc.CTFlowToOAServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(CTFlowToOAProvider.class);

    @Autowired
    private CTFlowToOADao ctFlowToOADao;

    @Value("${ctFlowToOA.createFlow}")
    private String createFlow;

    @Value("${ctFlowToOA.deleteFlow}")
    private String deleteFlow;

    /**
     * 新建OA流程
     * */
    @Override
    public void createOaWorkFlow(CreateOaWorkFlowRequest request, StreamObserver<CreateOaWorkFlowResponse> responseObserver) {

        int instID = request.getInstID();
        List<ReceiveModelByInstID> receiveModelByInstIDS = ctFlowToOADao.queryModelByInstID(instID);
        System.out.println(receiveModelByInstIDS);
        System.out.println("执行到此,一阶段结束");

    }

    /**
     * 删除OA流程
     * */
    @Override
    public void deleteOaWorkFlow(DeleteOaWorkFlowRequest request, StreamObserver<DeleteOaWorkFlowResponse> responseObserver) {
        DeleteOaWorkFlowResponse.Builder response = DeleteOaWorkFlowResponse.newBuilder();

    }

    public String sendPostRequest(String url, JSONObject jsonObject, String encoding) {
        String body = "";
        try {

            //创建httpclient对象
            CloseableHttpClient client = HttpClients.createDefault();
            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);

            //装填参数
            StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            //设置参数到请求对象中
            httpPost.setEntity(s);
            log.info("请求地址：{}", url);
            log.info("请求入参：{}", JSONObject.toJSONString(jsonObject));

            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("appSecretKey", "c467099d8fbe4beca6671c3171aa515f");
            httpPost.setHeader("appSystemName", "CPZX");

            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpPost);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            EntityUtils.consume(entity);
            //释放链接
            response.close();

        } catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("远程调用结果：{}", body);
        return body;
    }
}
