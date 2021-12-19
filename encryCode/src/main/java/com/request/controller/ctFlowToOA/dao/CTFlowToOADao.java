package com.request.controller.ctFlowToOA.dao;

import com.apexsoft.crm.ctFlowToOA.model.ReceiveModelByInstID;

import java.util.List;

public interface CTFlowToOADao {
    /**
     * 获取数据库中文件数据;
     * @param instTD
     * @return
     */
    List<ReceiveModelByInstID> queryModelByInstID(int instTD);
}
