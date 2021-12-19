package com.request.ctFlowToOA.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author zws
 * @Date 2021/12/15 17:01
 * @Version : V1.0
 */
@ApiModel(description = "删除OA流程")
public class DeleteOaWorkFlowRequestVO {

    @ApiModelProperty(notes = "本系统流程id")
    private String flowId;

    @Override
    public String toString() {
        return "DeleteOaWorkFlowRequestVO{" +
                "flowId='" + flowId + '\'' +
                '}';
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
}
