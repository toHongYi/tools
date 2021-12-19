package com.request.controller.ctFlowToOA.dao.impl;

import com.apexsoft.crm.ctFlowToOA.dao.CTFlowToOADao;
import com.apexsoft.crm.ctFlowToOA.mapper.CTFlowToOAMapper;
import com.apexsoft.crm.ctFlowToOA.model.ReceiveModelByInstID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zws
 * @Date 2021/12/15 17:28
 * @Version : V1.0
 */
@Repository
public class CTFlowToOADaoImpl implements CTFlowToOADao {

    @Autowired
    private CTFlowToOAMapper ctFlowToOAMapper;

    /**
     *
     * @param instTD
     * @return
     */
    @Override
    public List<ReceiveModelByInstID> queryModelByInstID(int instTD) {
        return ctFlowToOAMapper.queryModelByInstID(instTD);
    }
}
