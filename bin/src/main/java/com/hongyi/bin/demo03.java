package com.hongyi.bin;

/**
 * @version : V1.0
 * @date : 2021/12/22 15:56
 * @Author : LLH
 * @Desc :
 */
public class demo03 {
    /**
     * {
     *   "uniqueNo": "a8cb08d9-001c-4c58-a263-864a390b26f9",
     *   "charset": "UTF-8",
     *   "systemId": "DEMO",
     *   "signature": "F4615A4867E41F3F4E7B14B815214A10F303665E4E36628C2F34C23A71D322F69BE4BB93614D96707708DFB47007DCF1",
     *   "functionNo": "10000100",
     *   "requestData": {
     *     "workflowId": "F5581",
     *     "requestId": "0F202112250003",
     *     "creater": "6992",
     *     "moduleName": "waibao",
     *     "requestSubject": "string",
     *     "urgencyLevel": 0,
     *     "workflowData": {
     *       "formtableMain": {
     *         "accessory": [
     *           "第一个.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxNywiZW50cnlObyI6MX0=",
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxNywiZW50cnlObyI6M30=",
     *           "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxNywiZW50cnlObyI6NH0=",
     *           "示例接口入参.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxNiwiZW50cnlObyI6M30=",
     *           "第二个.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IlFUIiwiaWQiOjMxNywiZW50cnlObyI6Mn0="
     *         ],
     *         "bjs": [
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkJKUyIsImlkIjozMTYsImVudHJ5Tm8iOjB9",
     *           "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkJKUyIsImlkIjozMTcsImVudHJ5Tm8iOjB9"
     *         ],
     *         "cpfxdjpjb": [
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQRlhESlBKQiIsImlkIjozMTcsImVudHJ5Tm8iOjB9",
     *           "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQRlhESlBKQiIsImlkIjozMTYsImVudHJ5Tm8iOjB9"
     *         ],
     *         "cpfxjss": [
     *           "表结构.xlsx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQRlhESlNTIiwiaWQiOjMxNywiZW50cnlObyI6MH0="
     *         ],
     *         "cpht": [
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSFQiLCJpZCI6MzE2LCJlbnRyeU5vIjowfQ==",
     *           "OA流程对接.vsdx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSFQiLCJpZCI6MzE3LCJlbnRyeU5vIjowfQ=="
     *         ],
     *         "cpjsfxbg": [
     *           "财通证券流程处理接口.doc|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpGWEJHIiwiaWQiOjMxNiwiZW50cnlObyI6MH0=",
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpGWEJHIiwiaWQiOjMxNSwiZW50cnlObyI6MH0=",
     *           "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpGWEJHIiwiaWQiOjMxNywiZW50cnlObyI6MH0="
     *         ],
     *         "cpjzdcbg": [
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpEQ0JHIiwiaWQiOjMxNywiZW50cnlObyI6MH0=",
     *           "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQSlpEQ0JHIiwiaWQiOjMxNiwiZW50cnlObyI6MH0="
     *         ],
     *         "cpsms": [
     *           "OA流程对接.vsdx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQU01TIiwiaWQiOjMxNiwiZW50cnlObyI6MH0=",
     *           "表结构.xlsx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQU01TIiwiaWQiOjMxNywiZW50cnlObyI6MH0="
     *         ],
     *         "cpzmsms": [
     *           "表结构.xlsx|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkNQWk1TTVMiLCJpZCI6MzE3LCJlbnRyeU5vIjowfQ=="
     *         ],
     *         "createdate": "2021-12-21",
     *         "creater": 663,
     *         "creatercompany": 0,
     *         "createrdepartmentid": 6992,
     *         "createtime": "14:49",
     *         "docids": [],
     *         "dxcpxqfxpgbg": [
     *           "流程入参.json|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkRYQ1BYUUZYUEdCIiwiaWQiOjMxNywiZW50cnlObyI6MH0=",
     *           "oa接口.txt|http://172.15.7.109:8001/product/commonbase/v1/downloadFileByCt?sign=eyJmaWxlVGFibGUiOiJsY0NQUFNMQ19DUFhYIiwiZmlsZUNvbHVtbiI6IkRYQ1BYUUZYUEdCIiwiaWQiOjMxNiwiZW50cnlObyI6MH0="
     *         ],
     *         "pifflowinfo": "{\"approvalAction\":0,\"approvalUserId\":\"1\",\"instID\":2040,\"workflowName\":\"XXX\"}",
     *         "requestmark": "{\"instID\":2040}",
     *         "wfids": []
     *       },
     *       "formtableMainDt1": [
     *         {
     *           "cpdm": "010106",
     *           "cpfxdj": "R4 中高风险",
     *           "cpglr": "华夏基金",
     *           "cpjc": "华夏核心科技6个月定开混合A",
     *           "cplx": "公募",
     *           "cpmc": "华夏核心科技6个月定期开放混合型证券投资基金A类",
     *           "cptabh": "101",
     *           "cptgr": "中国银行",
     *           "jjjl": "周克平",
     *           "sclx": "场外;委外"
     *         },
     *         {
     *           "cpdm": "010305",
     *           "cpfxdj": "R4 中高风险",
     *           "cpglr": "华夏基金",
     *           "cpjc": "华夏创新驱动混合A",
     *           "cplx": "公募",
     *           "cpmc": "华夏创新驱动混合型证券投资基金A类",
     *           "cptabh": "101",
     *           "cptgr": "建设银行",
     *           "jjjl": "张帆",
     *           "sclx": "场外"
     *         },
     *         {
     *           "cpdm": "012963",
     *           "cpfxdj": "R3 中风险",
     *           "cpglr": "招商基金",
     *           "cpjc": "招商稳健平衡混合A",
     *           "cplx": "公募",
     *           "cpmc": "招商稳健平衡混合型证券投资基金A类",
     *           "cptabh": "54",
     *           "cptgr": "银河证券（总）",
     *           "jjjl": "李崟",
     *           "sclx": "场外"
     *         }
     *       ]
     *     }
     *   },
     *   "version": "v1.0",
     *   "algorithm": "AES",
     *   "timestamp": "1640143656440"
     * }
     */
}
