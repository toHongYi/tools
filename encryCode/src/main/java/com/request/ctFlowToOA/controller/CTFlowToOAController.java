package com.request.ctFlowToOA.controller;

import com.apexsoft.crm.ams.constant.RequestCommonPathConstant;
import com.apexsoft.crm.ctFlowToOA.model.CreateOaWorkFlowRequestVO;
import com.apexsoft.crm.ctFlowToOA.model.DeleteOaWorkFlowRequestVO;
import com.apexsoft.crm.ctFlowToOA.service.CTFlowToOAServiceConsumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ip.base.ctFlowToOA.CreateOaWorkFlowResponse;
import ip.base.ctFlowToOA.DeleteOaWorkFlowResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author zws
 * @Date 2021/12/15 16:39
 * @Version : V1.0
 */
@RestController
@RequestMapping(value = RequestCommonPathConstant.REQUEST_PROJECT_PATH + "/CTFlowToOA")
@Api(tags = "OA流程对接")
public class CTFlowToOAController {

    @Autowired
    private CTFlowToOAServiceConsumer service;

    private static final Logger logger = LoggerFactory.getLogger(CTFlowToOAController.class);

    @PostMapping(value = "/createOaWorkflow", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "新建OA工作流", notes = "新建OA工作流")
    public CreateOaWorkFlowResponse createOaWorkFlow(@ApiParam(value = "入参JSON") @RequestBody CreateOaWorkFlowRequestVO queryModel) throws IOException {
        System.out.println("响应已发生,准备开始吧;HongYi。");
        return service.createOaWorkflow(queryModel);
    }

    @PostMapping(value = "/deleteOaWorkflow", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "删除OA工作流", notes = "删除OA工作流")
    public DeleteOaWorkFlowResponse deleteOaWorkFlow(@ApiParam(value = "入参JSON") @RequestBody DeleteOaWorkFlowRequestVO queryModel) throws IOException {
        return service.deleteOaWorkFlow(queryModel);
    }


}
