package com.stringDemo;

/**
 * @version : V1.0
 * @date : 2022/6/6 16:00
 * @Author : LLH
 * @Desc :
 */
public class SnowBallProdReturn {

    public SnowBallProdReturn(String description, String prodReturn) {
        this.description = description;
        this.prodReturn = prodReturn;
    }

    //场景描述
    private String description;
    //产品回报
    private String prodReturn;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProdReturn() {
        return prodReturn;
    }

    public void setProdReturn(String prodReturn) {
        this.prodReturn = prodReturn;
    }

    @Override
    public String toString() {
        return "SnowBallProdReturn{" +
                "description='" + description + '\'' +
                ", prodReturn='" + prodReturn + '\'' +
                '}';
    }

    public String toConcat(){
        String returnsString;
        returnsString = this.description.concat(this.prodReturn);
        return returnsString;
    }
}
