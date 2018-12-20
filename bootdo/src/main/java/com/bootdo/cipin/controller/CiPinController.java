package com.bootdo.cipin.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Map;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.cipin.controller
 * @ClassName: CiPinController
 * @Description: 这个类是用来查询原始数据，并调用三方接口进行分词
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/20 17:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/20 17:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api")
public class CiPinController {

    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String getContentInfo(@RequestBody Map<String, Object> reqMap) throws IOException {
//        String cid = reqMap.get("cid").toString();
//        //首先需要先创建一个DefaultHttpClient的实例
//        HttpClient httpClient = new DefaultHttpClient();
//        //先创建一个HttpGet对象,传入目标的网络地址,然后调用HttpClient的execute()方法即可:
//        HttpGet httpGet = new HttpGet();
//        httpGet.setURI(URI.create("http://www.miguvideo.com/wap/resource/miguPC_client/data/detailData.jsp?cid="+cid));
//        HttpResponse response = httpClient.execute(httpGet);
//        String httpEntityContent = getHttpEntityContent(response);
//        httpGet.abort();
//        return httpEntityContent;
        return "heh";
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