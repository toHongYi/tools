package com.hongYi.http;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/22 21:20
 * @Author : LLH
 * @Desc :
 */
public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);


    /**
     * 发送post请求
     *
     * @param url        路径
     * @param jsonObject 参数(json类型)
     * @param encoding   编码格式
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String sendPostRequest(String url, JSONObject jsonObject, String encoding) throws ParseException,
            IOException {
        String body = "";
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                "application/json"));
        //设置参数到请求对象中
        httpPost.setEntity(s);
//        log.info("请求地址：{}", url);
//        log.info("请求入参：{}", JSONObject.toJSONString(jsonObject));


        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
//            log.info("远程调用结果：{}", body);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }

    public static String sendGetRequest(String url, List<NameValuePair> params){
        return sendGetRequest(url, params, "UTF-8");
    }

    public static String sendGetRequest(String url, List<NameValuePair> params, String encoding) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String paramStr = URLEncodedUtils.format(params, "UTF-8");
        String uri = url + "?" + paramStr;
        HttpGet httpGet = new HttpGet(uri);
        String responseStr = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getEntity() != null) {
                //按指定编码转换结果实体为String类型
                responseStr = EntityUtils.toString(response.getEntity(), encoding);
//                log.info("远程调用结果：{}", responseStr);
                EntityUtils.consume(response.getEntity());
            }
            //释放链接
            response.close();

        } catch (IOException e) {
            log.error("远程调用出错：{}", e);
        }
        return responseStr;
    }
}
