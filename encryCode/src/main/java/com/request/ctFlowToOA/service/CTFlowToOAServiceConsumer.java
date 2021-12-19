package com.request.ctFlowToOA.service;


import com.apex.ams.annotation.AmsBlockingStub;
import com.apexsoft.crm.ctFlowToOA.model.CreateOaWorkFlowRequestVO;
import com.apexsoft.crm.ctFlowToOA.model.DeleteOaWorkFlowRequestVO;
import ip.base.ctFlowToOA.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author zws
 * @Date 2021/12/15 16:41
 * @Version : V1.0
 */
@Service
public class CTFlowToOAServiceConsumer {

    private static final Logger log = LoggerFactory.getLogger(CTFlowToOAServiceConsumer.class);

    //将XXX.proto中生成的XXXGrpc中的内部类XXXStub生成出来,调用其server方法;
    @AmsBlockingStub
    private CTFlowToOAServiceGrpc.CTFlowToOAServiceBlockingStub stub;

    public CreateOaWorkFlowResponse createOaWorkflow(CreateOaWorkFlowRequestVO queryModel) throws IOException {
        CreateOaWorkFlowRequest.Builder request = CreateOaWorkFlowRequest.newBuilder().
                setInstID(queryModel.getInstID()).
                setApprovalAction(queryModel.getApprovalAction());

        log.debug("新建OA流程 入参 {}" +  request.toString());
        log.debug("新建OA流程 入参 request.build() {}" +  request.build().toString());
        return stub.createOaWorkFlow(request.build());
    }

    public DeleteOaWorkFlowResponse deleteOaWorkFlow(DeleteOaWorkFlowRequestVO queryModel) throws IOException {
        DeleteOaWorkFlowRequest.Builder request = DeleteOaWorkFlowRequest.newBuilder();
        log.debug("删除OA流程 入参" +  request.toString());
        return stub.deleteOaWorkFlow(request.build());
    }
}
