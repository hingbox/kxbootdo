package com.bootdo.common.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.common.task
 * @ClassName: TestJob
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/12/20 11:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/20 11:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestJob implements Job {
    @Autowired
    SimpMessagingTemplate template;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("====================开始执行任务=================");
//        template.convertAndSend("/topic/getResponse", new Response("呵呵" ));
        //获取当前时间 查询基础表 进行分析

    }
//    @RequestMapping(value = "/getContentInfo", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
//    public String getContentInfo(@RequestBody Map<String, Object> reqMap) throws IOException {
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
//    }
}