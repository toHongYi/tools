package com.hongyi.mode;

/**
 * @version : V1.0
 * @date : 2021/12/15 10:07
 * @Author : LLH
 * @Desc :  此为数据库表中的文件字段;   用于文件名与对接OA所需的字段转换;
 *          接收数据库中需转换的文件名相关字段;
 */
public class Model01 {

    //表ID;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //1、产品招募说明书
    String CPZMSMS;

    //2、产品说明书
    String CPSMS;

    //3、产品风险揭示书
    String CPJSS;

    //4、产品合同
    String CPHT;

    //5、产品尽职调查报告
    String CPJZDCBG;

    //6、产品价值分析报告
    String CPJZFXBG;

    //7、产品风险等级评价表
    String CPFXDJPJB;

    //8、表决书
    String BJS;

    //9、代销产品洗钱风险评估表
    String DXCPXQFXPGB;

    //10、其他附件 发送字段: "accessory" ;  表中所需字段: "QT";
    String QT;

    //11、相关文档
    String docids;

    //12、相关流程
    String wfids;

    public String getCPZMSMS() {
        return CPZMSMS;
    }

    public void setCPZMSMS(String CPZMSMS) {
        this.CPZMSMS = CPZMSMS;
    }

    public String getCPSMS() {
        return CPSMS;
    }

    public void setCPSMS(String CPSMS) {
        this.CPSMS = CPSMS;
    }

    public String getCPJSS() {
        return CPJSS;
    }

    public void setCPJSS(String CPJSS) {
        this.CPJSS = CPJSS;
    }

    public String getCPHT() {
        return CPHT;
    }

    public void setCPHT(String CPHT) {
        this.CPHT = CPHT;
    }

    public String getCPJZDCBG() {
        return CPJZDCBG;
    }

    public void setCPJZDCBG(String CPJZDCBG) {
        this.CPJZDCBG = CPJZDCBG;
    }

    public String getCPJZFXBG() {
        return CPJZFXBG;
    }

    public void setCPJZFXBG(String CPJZFXBG) {
        this.CPJZFXBG = CPJZFXBG;
    }

    public String getCPFXDJPJB() {
        return CPFXDJPJB;
    }

    public void setCPFXDJPJB(String CPFXDJPJB) {
        this.CPFXDJPJB = CPFXDJPJB;
    }

    public String getBJS() {
        return BJS;
    }

    public void setBJS(String BJS) {
        this.BJS = BJS;
    }

    public String getDXCPXQFXPGB() {
        return DXCPXQFXPGB;
    }

    public void setDXCPXQFXPGB(String DXCPXQFXPGB) {
        this.DXCPXQFXPGB = DXCPXQFXPGB;
    }

    public String getQT() {
        return QT;
    }

    public void setQT(String QT) {
        this.QT = QT;
    }

    public String getDocids() {
        return docids;
    }

    public void setDocids(String docids) {
        this.docids = docids;
    }

    public String getWfids() {
        return wfids;
    }

    public void setWfids(String wfids) {
        this.wfids = wfids;
    }
}
