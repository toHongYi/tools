package com.stream;

import java.util.Date;

/**
 * @version : V1.0
 * @date : 2022/6/16 12:40
 * @Author : LLH
 * @Desc :
 */
public class StockAccountDTO {
    private String statusName;
    private String status;
    private String companyName;
    private String accountType;
    private String accountTypeName;
    private String accountNo;
    private Date openDate;
    private String organName;
    private String bindStatusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getBindStatusName() {
        return bindStatusName;
    }

    public void setBindStatusName(String bindStatusName) {
        this.bindStatusName = bindStatusName;
    }

    @Override
    public String toString() {
        return "StockAccountDTO{" +
                "statusName='" + statusName + '\'' +
                ", status='" + status + '\'' +
                ", companyName='" + companyName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", openDate=" + openDate +
                ", organName='" + organName + '\'' +
                ", bindStatusName='" + bindStatusName + '\'' +
                '}';
    }
}
