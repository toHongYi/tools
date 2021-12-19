package com.request.controller.ctFlowToOA.mapper;

import com.apexsoft.crm.ctFlowToOA.model.ReceiveModelByInstID;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CTFlowToOAMapper {

    /**
     * 获取数据库中文件数据;
     *
     * @param instTD
     * @return
     */
    List<ReceiveModelByInstID> queryModelByInstID(int instTD);
}
