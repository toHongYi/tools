package com.request.ctFlowToOA.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author zws
 * @Date 2021/12/15 16:55
 * @Version : V1.0
 * @Desc: 此处既是前方访问的接口入参
 */
@ApiModel(description = "新增OA流程")
public class CreateOaWorkFlowRequestVO {

    @ApiModelProperty(notes = "OA产品说明")
    private String prodRemark;
    @ApiModelProperty(notes = "流程id")
    private int InstID;
    @ApiModelProperty(notes = "发起人id")
    private int initiator;
    @ApiModelProperty(notes = "发起时间 yyyy-MM-dd")
    private String createDate;
    @ApiModelProperty(notes = "发起时间 格式：HH:MM")
    private String createTime;
    @ApiModelProperty(notes = "流程标题")
    private String processTitle;


    @ApiModelProperty(notes = "审核通过标志(不通审核节点通过id不同，需要livebos设置)")
    private int approvalAction;
    @ApiModelProperty(notes = "OA审核节点用户（默认节点配上1，ws_user）传“1”")
    private String approvaUserId;
    @ApiModelProperty(notes = "工作流程名称（不同流程名不一样）")
    private String workflowName;

    public String getProdRemark() {
        return prodRemark;
    }

    public void setProdRemark(String prodRemark) {
        this.prodRemark = prodRemark;
    }

    public int getInstID() {
        return InstID;
    }

    public void setInstID(int instID) {
        InstID = instID;
    }

    public int getInitiator() {
        return initiator;
    }

    public void setInitiator(int initiator) {
        this.initiator = initiator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProcessTitle() {
        return processTitle;
    }

    public void setProcessTitle(String processTitle) {
        this.processTitle = processTitle;
    }

    public int getApprovalAction() {
        return approvalAction;
    }

    public void setApprovalAction(int approvalAction) {
        this.approvalAction = approvalAction;
    }

    public String getApprovaUserId() {
        return approvaUserId;
    }

    public void setApprovaUserId(String approvaUserId) {
        this.approvaUserId = approvaUserId;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    @Override
    public String toString() {
        return "CreateOaWorkFlowRequestVO{" +
                "prodRemark='" + prodRemark + '\'' +
                ", InstID=" + InstID +
                ", initiator=" + initiator +
                ", createDate='" + createDate + '\'' +
                ", createTime='" + createTime + '\'' +
                ", processTitle='" + processTitle + '\'' +
                ", approvalAction=" + approvalAction +
                ", approvaUserId='" + approvaUserId + '\'' +
                ", workflowName='" + workflowName + '\'' +
                '}';
    }
}