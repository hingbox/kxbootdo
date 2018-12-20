package com.bootdo.common.task;

import com.bootdo.oa.domain.Response;
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
        template.convertAndSend("/topic/getResponse", new Response("呵呵" ));
    }
}