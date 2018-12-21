package com.bootdo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.util
 * @ClassName: HttpClientUtils
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/21 10:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/21 10:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HttpClientUtils {
    /**
     * 发送 get请求
     */
    public static String doGet(String url) {
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse httpResponse = httpCilent.execute(httpGet);
            BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent())));
            String info = "";
            StringBuffer sb = new StringBuffer();
            while (null != (info = br.readLine())){
                System.out.println(info);
                sb.append(info);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 发送 post请求
     */
    public static boolean httpPostWithJson(String jsonStr,String url){
        boolean isSuccess = false;

        HttpPost post = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            post = new HttpPost(url);
            // 构造消息头
//            post.setHeader("Content-type", "application/json; charset=utf-8");
//            post.setHeader("Connection", "Close");

            // 构建消息实体
            StringEntity entity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = httpClient.execute(post);

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != HttpStatus.SC_OK){
                System.out.println("请求出错: "+statusCode);
                isSuccess = false;
            }else{
                BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(response.getEntity().getContent())));
                String info = "";
                StringBuffer sb = new StringBuffer();
                while (null != (info = br.readLine())){
                    System.out.println(info);
                    sb.append(info);
                }

            }
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
        return isSuccess;
    }
    public static void main(String[] args) {
//        doGet("http://www.baidu.com");
//        doGet("https://www.oschina.net");
//        doGet("https://www.oschina.net/search?scope=project&q=sdfweef");
//        doGet("http://q.10jqka.com.cn/global/index/ajax/1/");
//        doGet("http://q.10jqka.com.cn/global/index/ajax/1/");
//        doGet("http://q.10jqka.com.cn/global/index/ajax/1/");
        String json = "{\n" +
                "\t\"content\":\"安迪苏(600299)近期国内猪肉价格持续低迷，而且这种情况有分析认为将要持续二年左右时间，请问董秘这种情况对公司产品销量会产生多大影响？是否意味着公司产品价格也将继续在低位震荡？另外国际市场是否也存在相类似情况。谢谢！\"\n" +
                "\n" +
                "}";
        httpPostWithJson(json,"http://123.206.46.153:7911/wordcloud/");
    }

    public static String  httpPostWithJson(String content, String url, String appId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("content", content);
        JSONObject jsonObj = new JSONObject(data);
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
            //String sessionId = getSessionId();
            //post.setHeader("SessionId", sessionId);
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

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (post != null) {
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