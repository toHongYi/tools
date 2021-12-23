package com.lyl.shunfeng.bean.xml;

import com.lyl.shunfeng.bean.xml.CreateExpressOrderDTO;
import com.lyl.shunfeng.enums.ExpressCompanyType;
import lombok.Data;

import java.util.List;

/**
 * 顺丰响应实体
 * @author 李宇龙
 * @date 2019/2/14 17:49
 */
@Data
public class ShunFengResponse {
    
    /** 响应成功标志 */
    private boolean resultFlag;
    /** 错误信息 */
    private String errorMsg;
    /** 顺丰运单号 */
    private String mailNo;
    /** 快递公司拼音 */
    private ExpressCompanyType com;
    /** 快递公司中文 */
    private String comCN;
    /** 下单返回的信息封装的实体*/
    private CreateExpressOrderDTO orderResponse;
    /** 顺丰路由节点操作码 */
    private String opCode;
    /** 路由查询返回实体节点 */
    private List<DataBean> data;
    /** 路由推送返回的节点实体 */
    private List<WaybillRoute> waybillRouteList;
    @Data
    public static class DataBean {
        /**
         * time : 2018-05-21 17:48:44
         * ftime : 2018-05-21 17:48:44
         * context : [深圳市]已签收,感谢使用顺丰,期待再次为您服务
         */
        private String time;
        private String ftime;
        private String context;
    }
    @Data
    public static class WaybillRoute {
        /** 顺丰运单号 */
        private String mailNo;
        /** 顺丰路由节点操作码 */
        private String opCode;
    }
}
