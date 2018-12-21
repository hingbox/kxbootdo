package com.bootdo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.util
 * @ClassName: HttpClientDemo
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/21 12:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/21 12:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HttpClientDemo {
    private static Logger logger = LoggerFactory.getLogger(HttpClientDemo.class);
    public static String  httpPostWithJson(JSONObject jsonObj, String url, String appId){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("content", "你好，我好");
        jsonObj = new JSONObject(data);
        boolean isSuccess = false;

        HttpPost post = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();

            // 设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

            post = new HttpPost(url);
            // 构造消息头
            post.setHeader("Content-type", "application/json; charset=utf-8");
            post.setHeader("Connection", "Close");
            String sessionId = getSessionId();
            post.setHeader("SessionId", sessionId);
//            post.setHeader("appid", appid);

            // 构建消息实体
            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = httpClient.execute(post);
            String httpEntityContent = getHttpEntityContent(response);
            post.abort();
            return httpEntityContent;
//
//            // 检验返回码
//            int statusCode = response.getStatusLine().getStatusCode();
//            if(statusCode != HttpStatus.SC_OK){
//                logger.info("请求出错: "+statusCode);
//                isSuccess = false;
//            }else{
//                int retCode = 0;
//                String sessendId = "";
//                // 返回码中包含retCode及会话Id
//                for(Header header : response.getAllHeaders()){
//                    if(header.getName().equals("retcode")){
//                        retCode = Integer.parseInt(header.getValue());
//                    }
//                    if(header.getName().equals("SessionId")){
//                        sessendId = header.getValue();
//                    }
//                }
//
////                if(ErrorCodeHelper.IAS_SUCCESS != retCode ){
////                    // 日志打印
////                    //logger.info("error return code,  sessionId: "sessendId"\t"+"retCode: "+retCode);
////                    isSuccess = false;
////                }else{
////                    isSuccess = true;
////                }
//                isSuccess = true;
//            }
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }finally{
            if(post != null){
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    // 构建唯一会话Id
    public static String getSessionId(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

    public static void main(String[]arg) throws IOException {


        String f = httpPostWithJson(null,"http://123.206.46.153:7911/wordcloud/",null);
        logger.info("===============HttpClientDemo==============",f);
//        String url="http://www.baidu.com";
//        HttpPost httppost=new HttpPost(url); //建立HttpPost对象
//        List<NameValuePair> params=new ArrayList<NameValuePair>();
//        //建立一个NameValuePair数组，用于存储欲传送的参数
//        params.add(new BasicNameValuePair("pwd","2544"));
//        //添加参数
//        httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
//        //设置编码
//        HttpResponse response=new DefaultHttpClient().execute(httppost);
//        //发送Post,并返回一个HttpResponse对象
    }

    private static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
        //通过HttpResponse 的getEntity()方法获取返回信息
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }
            br.close();
            is.close();
            return sb.toString();
        }
        return "";
    }
}