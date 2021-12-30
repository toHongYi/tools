//package com.apexsoft.crm.ctFlowToOA.provider;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.apex.ams.server.AmsService;
//import com.apexsoft.crm.ctFlowToOA.dao.CTFlowToOADao;
//import com.apexsoft.crm.ctFlowToOA.model.DelParamModel;
//import com.apexsoft.crm.ctFlowToOA.model.dao.CreaterModel;
//import com.apexsoft.crm.ctFlowToOA.model.dao.ReceiveModelByInstIDModel;
//import com.apexsoft.crm.utils.HttpClientUtils;
//import com.apexsoft.utils.GbiccEncryptUtil;
//
//import com.apexsoft.crm.ctFlowToOA.utils.ReceiveModeToRequestModelUtils;
//import com.esotericsoftware.minlog.Log;
//import io.grpc.stub.StreamObserver;
//import ip.base.ctFlowToOA.*;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.util.DigestUtils;
//import org.springframework.util.StringUtils;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//import java.util.List;
//
///**
// * @Author zws
// * @Date 2021/12/15 17:23
// * @Version : V1.0
// */
//@AmsService(version = "1.0.1")
//public class CTFlowToOAProvider extends CTFlowToOAServiceGrpc.CTFlowToOAServiceImplBase {
//
//    private static final Logger log = LoggerFactory.getLogger(CTFlowToOAProvider.class);
//
//    @Autowired
//    private CTFlowToOADao ctFlowToOADao;
//
//    @Value("${ct.oa.start-oa-url}")
//    private String ctStartOaUrl;
//
//    @Value("${ct.oa.moduleName}")
//    private String moduleName;
//
//    @Value(("${ct.oa.urgencyLevel}"))
//    private String urgencyLevel;
//
//    @Value("${ct.oa.systemId}")
//    private String systemId;
//
//    @Value("${ct.oa.version}")
//    private String version;
//
//    @Value("${ct.oa.algorithm}")
//    private String algorithm;
//
//    @Value("${ct.oa.charset}")
//    private String charset;
//
//    @Value("${ct.oa.appEncryptKey}")
//    private String appEncryptKey;
//
//    @Value("${ct.oa.start-function-no}")
//    private String startFunctioNo;
//
//    @Value("${ct.oa.delete-function-no}")
//    private String deleteFunctioNo;
//
////    下载地址固定头部;OA下载附件地址:
////    @Value("${ct.oa.URL_DOWN_HEAD}")
////    private String URL_DOWN_HEAD;
//
//    private static String deleteKey = "delete";
//
//    private static String startKey = "start";
//
//    /**
//     * 新建OA流程
//     */
//    @Override
//    public void createOaWorkFlow(CreateOaWorkFlowRequest request, StreamObserver<CreateOaWorkFlowResponse> responseObserver) {
//        CreateOaWorkFlowResponse.Builder response = CreateOaWorkFlowResponse.newBuilder();
//
//        /**
//         * 项目主要分为四类:
//         *     1、执行验证;
//         *          -|OA状态判定;
//         *          -|必传参数非空;
//         *          -|指定数据,指定类型;
//         *
//         *     2、个性化参数获取;
//         *     3、参数包裹,发送请求;
//         *     4、回参处理;
//         */
//        Integer verifyOAhasOK = ctFlowToOADao.verifyOAhasOK();
//        if (verifyOAhasOK != null && verifyOAhasOK == 1) {
//            int instID = request.getInstID();
//            int initiator = request.getInitiator();
//            String workflowName = request.getWorkflowName();
//            String workflowId = request.getWorkflowId();
//            String sqlx = request.getSqlx();
//            if (StringUtils.isEmpty(workflowName) || StringUtils.isEmpty(workflowId) || StringUtils.isEmpty(sqlx) || instID != 0 || initiator != 0) {
//
//                HashMap<String, Object> requestMap = new HashMap<>();
//                requestMap.put("INST_ID", request.getInstID());
//                requestMap.put("INITIATOR", request.getInitiator());
//                requestMap.put("REQUEST_SUBJECT", request.getRequestSubject());
//                requestMap.put("REMARK", request.getRemark());
//                requestMap.put("CREATE_TIME", request.getCreateTime());
//                requestMap.put("CREATE_DATE", request.getCreateDate());
//                requestMap.put("PROCESS_TITLE", request.getProcessTitle());
//                requestMap.put("APPROVAL_ACTION", request.getApprovalAction());
//                requestMap.put("APPROVA_USER_ID", request.getApprovaUserId());
//                requestMap.put("WORK_FLOW_NAME", request.getWorkflowName());
//                requestMap.put("WORK_FLOW_ID", request.getWorkflowId());
//                requestMap.put("SQLX", request.getSqlx());
//
//                log.info("获取传过来的前端输入map :{}", requestMap.toString());
//                Integer initiator1 = (Integer) requestMap.get("INITIATOR");
//                CreaterModel createrModel = ctFlowToOADao.queryCreater(initiator1);
//                log.info("获取到的createrModel:{}", createrModel.toString());
//                Integer instID1 = (Integer) requestMap.get("INST_ID");
//                //再次更换;
//                String ctFlowSQLX = (String) requestMap.get("WORK_FLOW_NAME");
//                Log.info("本次请求的申请类型为:{}", ctFlowSQLX);
//
//
//                /** DESC:  根据SQLX的不同,选取不容的执行逻辑;获取到到需要发送至requestData中的数据; */
//                // 个性化;  BUILD-;
//                //
//                Object buildWorkFlowData = null;
//                List<ReceiveModelByInstIDModel> receiveModelByInstIDS = ctFlowToOADao.queryModelByInstID(instID1);
//                log.info("获取到的receiveModelByInstIDS:{}", receiveModelByInstIDS);
//                //build WorkFlowData作为一个接口,当不同的调用;不同的实现;
//                buildWorkFlowData = ReceiveModeToRequestModelUtils.send(receiveModelByInstIDS, requestMap, createrModel, ctFlowSQLX);
//
//
//                String toOAWorkFlowData = requestDataCreate(buildWorkFlowData, requestMap, createrModel, ctFlowSQLX);   //包裹
//                log.info("发送给OA的数据最终为: {}", toOAWorkFlowData);
//                String responseMethodName = "";
//                try {
//                    String result = HttpClientUtils.sendPostRequest(ctStartOaUrl, JSONObject.parseObject(toOAWorkFlowData), "UTF-8");
//                    log.debug(toOAWorkFlowData);
//                    JSONObject parseObject = JSON.parseObject(result);
//                    responseMethodName = "创建OA流程";
//                    if (parseObject.getInteger("code") == 0) {
//                        response.setMessageCode(1);
//                        response.setSuccess(true);
//                        //将该buildId添加至数据库中;
//                        Map<String, Object> innerMap = parseObject.getInnerMap();
//                        Map message = (Map) innerMap.get("responseData");
//                        Object billId1 = message.get("billId");
//                        Integer billId101 = Integer.valueOf(billId1.toString());
//                        ctFlowToOADao.setCtFlowToOAbillId(billId101, instID1);
//                        response.setMessage(responseMethodName + "成功" + parseObject.getString("responseData"));
//                    } else {
//                        response.setMessageCode(-1);
//                        response.setSuccess(false);
//                        //此处根据switch中处理的不同,指向不同的对象实例;
//                        //methodTest01.testMethod02(parseObject);
//                        response.setMessage(responseMethodName + "失败：" + parseObject.getString("message"));
//                    }
//                } catch (IOException e) {
//                    response.setMessageCode(-1);
//                    response.setSuccess(false);
//                    response.setMessage(responseMethodName + "失败：" + e.getMessage());
//                    e.printStackTrace();
//                }
//
//            } else {
//                response.setMessageCode(-1);
//                response.setSuccess(false);
//                response.setMessage("新增OA流程失败：" + "入参异常，未指定流程或流程类型！");
//            }
//        } else {
//            response.setMessageCode(-1);
//            response.setSuccess(false);
//            response.setMessage("请校验OA状态");
//        }
//        //log.debug(toOA);
//        CreateOaWorkFlowResponse resp = response.build();
//        responseObserver.onNext(resp);
//        responseObserver.onCompleted();
//        log.info("");
//        log.info("执行到此,新增阶段结束");
//    }
//
//
//    /**
//     * 删除OA流程
//     */
//    @Override
//    public void deleteOaWorkFlow(DeleteOaWorkFlowRequest request, StreamObserver<DeleteOaWorkFlowResponse> responseObserver) {
//        DeleteOaWorkFlowResponse.Builder response = DeleteOaWorkFlowResponse.newBuilder();
//        String workFlowId = request.getWorkflowId();
//        String tableName = request.getTableName();
//        String flowId = request.getFlowId();
//        if (StringUtils.isEmpty(tableName) || StringUtils.isEmpty(flowId)) {
//            response.setMessageCode(-1);
//            response.setSuccess(false);
//            response.setMessage("删除OA流程失败：" + "入参异常，未指定流程或流程类型！");
//        } else {
//            DelParamModel delParamModel = ctFlowToOADao.getDelParam(flowId, workFlowId, moduleName, urgencyLevel, tableName);
//
//            Map<String, DelParamModel> boxparam = new HashMap();
//            boxparam.put(deleteKey, delParamModel);
//            Map requestParam = boxParam(boxparam, deleteKey);
//            log.debug("删除OA流程远程调用入参：{}", requestParam);
//            try {
//                String result = HttpClientUtils.sendPostRequest(ctStartOaUrl, JSONObject.parseObject(JSON.toJSONString(requestParam)), "UTF-8");
//                log.debug(JSON.toJSONString(requestParam));
//                //解析响应结果
//                JSONObject parseObject = JSON.parseObject(result);
//                if (parseObject.getInteger("code") == 0) {
//                    response.setMessageCode(1);
//                    response.setSuccess(true);
//                    response.setMessage("删除OA流程成功");
//                } else {
//                    // result中拿到错误信息并封装
//                    response.setMessageCode(-1);
//                    response.setSuccess(false);
//                    response.setMessage("删除OA流程失败：" + parseObject.getString("message"));
//                }
//            }  catch (IOException e) {
//                response.setMessageCode(-1);
//                response.setSuccess(false);
//                response.setMessage("删除OA流程失败：" + e.getMessage() );
//                e.printStackTrace();
//                //使用log打印错误日志;
//                log.error("删除OA流程失败",e);
//            }
//        }
//        responseObserver.onNext(response.build());
//        responseObserver.onCompleted();
//    }
//
//
//    /**
//     * 补全请求体内部相关信息;
//     * @param send          //WorkFlowData转JSON后的数据;
//     * @param map           //requestMap传入参数;
//     * @param createrModel  //创建人信息;
//     * @param ctFlowSQLX    //申请类型;
//     * @return map          //
//     */
//    private String requestDataCreate(Object send, HashMap<String, Object> map, CreaterModel createrModel, String ctFlowSQLX) {
//        Map<String, Object> requestMap = new HashMap<>();
//        requestMap.put("creater",createrModel.getCreater());
//        requestMap.put("moduleName",moduleName);
//        requestMap.put("requestId",map.get("INST_ID"));
//        requestMap.put("requestSubject",map.get("PROCESS_TITLE"));
//        requestMap.put("urgencyLevel",urgencyLevel);
//        requestMap.put("workflowId",map.get("WORK_FLOW_ID"));
//        requestMap.put("remark",map.get("REMARK"));
//        requestMap.put("workflowData",send);
//
//        HashMap<Object, Object> objectMap = new HashMap<>();
//        objectMap.put(startKey,requestMap);
//        Map map1 = boxParam(objectMap, startKey);
//        return JSON.toJSONString(map1);
//
//    }
//
//    /**
//     * 包裹生成的数据组成完整的请求内容
//     * @param param     //存储requestdata数据
//     * @param key       //param的key，用于取值与判断是create还是delete
//     * @return
//     */
//    public Map boxParam(Map param, String key) {
//        String functionNo = "";
//        if (key.equals(deleteKey)) {
//            functionNo = deleteFunctioNo;
//        } else {
//            functionNo = startFunctioNo;
//        }
//        String uniqueNo = UUID.randomUUID().toString();
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        StringBuilder inputSource = new StringBuilder();
//        inputSource.append(functionNo).append(systemId).append(uniqueNo).append(version).append(algorithm)
//                .append(timestamp).append(charset).append(param.get(key));
//
//        String md5str = DigestUtils.md5DigestAsHex(inputSource.toString().getBytes());
//        //String md5str = MD5Utils.MD5Encode(inputSource.toString(), true);
//        String signature = GbiccEncryptUtil.getInstance().AESencode(md5str, appEncryptKey);
//        //String signature = AESUtil.encrypt(md5str, appEncryptKey);
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("functionNo", functionNo);
//        params.put("systemId", systemId);
//        params.put("uniqueNo", uniqueNo);
//        params.put("version", version);
//        params.put("algorithm", algorithm);
//        params.put("charset", charset);
//        params.put("timestamp", timestamp);
//        params.put("signature", signature);
//        params.put("requestData", param.get(key));
//        return params;
//    }
//
//    /**
//     * 该类用于被重写: 对返回数据进行不同的处理;重写不同的方法,再对指针进行转移;
//     *      1、testMethod01  调用成功后对传入的数据进行判断;
//     *      2、testMethod02  调用失败后的处理;
//     *          在case中进行对象指针的迁移;
//     */
//    class MethodTest01{
//
//        void testMethod01(JSONObject parseObject) {
//            System.out.println("");
//            System.out.println("");
//            System.out.println("\033[31m"+"未重写success方法;");
//            System.out.println("");
//            System.out.println("");
//        }
//        void testMethod02(JSONObject parseObject){
//            System.out.println("");
//            System.out.println("");
//            System.out.println("\033[31m"+"未重写failure方法;");
//            System.out.println("");
//            System.out.println("");
//        }
//    }
//
//}
