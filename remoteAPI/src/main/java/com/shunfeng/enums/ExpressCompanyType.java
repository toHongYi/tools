package com.lyl.shunfeng.enums;

/**
 * 快递公司
 *
 * @author 李宇龙
 * @date 2018/5/30 14:27
 */
public enum ExpressCompanyType {

    shunfeng("顺丰快递");

    ExpressCompanyType(String chName) {
        this.chName = chName;
    }

    /**
     * 中文名称.
     */
    private String chName;

    /**
     * Gets the 中文名称.
     *
     * @return the 中文名称
     */
    public String getChName() {
        return chName;
    }
}
