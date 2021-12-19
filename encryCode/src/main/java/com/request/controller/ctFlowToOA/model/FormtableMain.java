package com.request.controller.ctFlowToOA.model;

import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/15 16:14
 * @Author : LLH
 * @Desc :
 */
public class FormtableMain {

    int creater;	            //申请人
    int createrdepartmentid;	//申请人所在部门
    int creatercompany;	        //申请人分部
    String createdate;	        //申请日期
    String createtime;	        //申请时间
    String requestmark;	        //申请编号
    String applicationreasons;	//申请事由
    String cpsm;	            //产品说明

    List<String> cpzmsms;	    //产品招募说明书
    List<String> cpsms;	        //产品说明书
    List<String> cpfxjss;	    //产品风险揭示书
    List<String> cpht;	        //产品合同
    List<String> cpjzdcbg;	    //产品尽职调查报告
    List<String> cpjsfxbg;	    //产品价值分析报告
    List<String> cpfxdjpjb;	    //产品风险等级评价表
    List<String> bjs;	        //表决书
    List<String> dxcpxqfxpgbg;	//代销产品洗钱风险评估表
    List<String> accessory;	    //其他附件

    String departmentlevel; 	//部门级别
    List<String> docids;	    //相关文档
    String pifflowinfo;
    List<String> wfids;	        //相关流程


    @Override
    public String toString() {
        return "FormtableMain{" +
                "creater=" + creater +
                ", createrdepartmentid=" + createrdepartmentid +
                ", creatercompany=" + creatercompany +
                ", createdate='" + createdate + '\'' +
                ", createtime='" + createtime + '\'' +
                ", requestmark='" + requestmark + '\'' +
                ", applicationreasons='" + applicationreasons + '\'' +
                ", cpsm='" + cpsm + '\'' +
                ", cpzmsms=" + cpzmsms +
                ", cpsms=" + cpsms +
                ", cpfxjss=" + cpfxjss +
                ", cpht=" + cpht +
                ", cpjzdcbg=" + cpjzdcbg +
                ", cpjsfxbg=" + cpjsfxbg +
                ", cpfxdjpjb=" + cpfxdjpjb +
                ", bjs=" + bjs +
                ", dxcpxqfxpgbg=" + dxcpxqfxpgbg +
                ", accessory=" + accessory +
                ", departmentlevel='" + departmentlevel + '\'' +
                ", docids=" + docids +
                ", pifflowinfo='" + pifflowinfo + '\'' +
                ", wfids=" + wfids +
                '}';
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public int getCreaterdepartmentid() {
        return createrdepartmentid;
    }

    public void setCreaterdepartmentid(int createrdepartmentid) {
        this.createrdepartmentid = createrdepartmentid;
    }

    public int getCreatercompany() {
        return creatercompany;
    }

    public void setCreatercompany(int creatercompany) {
        this.creatercompany = creatercompany;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRequestmark() {
        return requestmark;
    }

    public void setRequestmark(String requestmark) {
        this.requestmark = requestmark;
    }

    public String getApplicationreasons() {
        return applicationreasons;
    }

    public void setApplicationreasons(String applicationreasons) {
        this.applicationreasons = applicationreasons;
    }

    public String getCpsm() {
        return cpsm;
    }

    public void setCpsm(String cpsm) {
        this.cpsm = cpsm;
    }

    public List<String> getCpzmsms() {
        return cpzmsms;
    }

    public void setCpzmsms(List<String> cpzmsms) {
        this.cpzmsms = cpzmsms;
    }

    public List<String> getCpsms() {
        return cpsms;
    }

    public void setCpsms(List<String> cpsms) {
        this.cpsms = cpsms;
    }

    public List<String> getCpfxjss() {
        return cpfxjss;
    }

    public void setCpfxjss(List<String> cpfxjss) {
        this.cpfxjss = cpfxjss;
    }

    public List<String> getCpht() {
        return cpht;
    }

    public void setCpht(List<String> cpht) {
        this.cpht = cpht;
    }

    public List<String> getCpjzdcbg() {
        return cpjzdcbg;
    }

    public void setCpjzdcbg(List<String> cpjzdcbg) {
        this.cpjzdcbg = cpjzdcbg;
    }

    public List<String> getCpjsfxbg() {
        return cpjsfxbg;
    }

    public void setCpjsfxbg(List<String> cpjsfxbg) {
        this.cpjsfxbg = cpjsfxbg;
    }

    public List<String> getCpfxdjpjb() {
        return cpfxdjpjb;
    }

    public void setCpfxdjpjb(List<String> cpfxdjpjb) {
        this.cpfxdjpjb = cpfxdjpjb;
    }

    public List<String> getBjs() {
        return bjs;
    }

    public void setBjs(List<String> bjs) {
        this.bjs = bjs;
    }

    public List<String> getDxcpxqfxpgbg() {
        return dxcpxqfxpgbg;
    }

    public void setDxcpxqfxpgbg(List<String> dxcpxqfxpgbg) {
        this.dxcpxqfxpgbg = dxcpxqfxpgbg;
    }

    public List<String> getAccessory() {
        return accessory;
    }

    public void setAccessory(List<String> accessory) {
        this.accessory = accessory;
    }

    public String getDepartmentlevel() {
        return departmentlevel;
    }

    public void setDepartmentlevel(String departmentlevel) {
        this.departmentlevel = departmentlevel;
    }

    public List<String> getDocids() {
        return docids;
    }

    public void setDocids(List<String> docids) {
        this.docids = docids;
    }

    public String getPifflowinfo() {
        return pifflowinfo;
    }

    public void setPifflowinfo(String pifflowinfo) {
        this.pifflowinfo = pifflowinfo;
    }

    public List<String> getWfids() {
        return wfids;
    }

    public void setWfids(List<String> wfids) {
        this.wfids = wfids;
    }
}
