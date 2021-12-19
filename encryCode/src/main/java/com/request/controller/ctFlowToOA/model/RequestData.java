package com.request.controller.ctFlowToOA.model;

/**
 * @version : V1.0
 * @date : 2021/12/15 16:11
 * @Author : LLH
 * @Desc :
 */

public class RequestData {

    String creater;			//申请人
    String moduleName;		//模块名称
    int requestId;			//请求编号
    String requestSubject;	//请求标题
    String urgencyLevel;	//紧急程度
    String workflowId;		//工作流编号

    WorkFlowData workFlowData;//所需数据;


    public WorkFlowData getWorkFlowData() {
        return workFlowData;
    }

    public void setWorkFlowData(WorkFlowData workFlowData) {
        this.workFlowData = workFlowData;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "creater='" + creater + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", requestId=" + requestId +
                ", requestSubject='" + requestSubject + '\'' +
                ", urgencyLevel='" + urgencyLevel + '\'' +
                ", workflowId='" + workflowId + '\'' +
                ", workFlowData=" + workFlowData +
                '}';
    }


    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestSubject() {
        return requestSubject;
    }

    public void setRequestSubject(String requestSubject) {
        this.requestSubject = requestSubject;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }
}
