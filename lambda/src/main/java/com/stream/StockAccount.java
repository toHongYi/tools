package com.stream;

import java.util.Date;

/**
 * @version : V1.0
 * @date : 2022/6/16 12:37
 * @Author : LLH
 * @Desc :
 */
public class StockAccount {
    private Long id;
    private Long acceptNo;
    private String accountType;
    private String accountTypeName;
    private String accountNo;
    private String status;
    private String statusName;
    private Date openDate;
    private String organName;
    private String bindStatusName;
    private String companyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcceptNo() {
        return acceptNo;
    }

    public void setAcceptNo(Long acceptNo) {
        this.acceptNo = acceptNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
