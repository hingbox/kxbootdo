package com.bootdo.api;

import com.bootdo.cipin.domain.CipinDO;
import com.bootdo.cipin.domain.ProcessDataDO;
import com.bootdo.cipin.domain.QaDO;
import com.bootdo.cipin.service.CipinService;
import com.bootdo.cipin.service.ProcessDataService;
import com.bootdo.cipin.service.QaService;
import com.bootdo.util.HttpClientUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    private static Logger logger = LoggerFactory.getLogger(CiPinController.class);
    @Autowired
    private QaService qaService;
    @Autowired
    private CipinService cipinService;
    @Autowired
    private ProcessDataService processDataService;

    /**
     * 获取原始数据 查询每一天的数，将返回的content 合并起来，调用第三方的接口，进行分词
     * @param reqMap
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/data", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String getContentInfo(@RequestBody Map<String, Object> reqMap) throws IOException {
        String pubDate = reqMap.get("pub_date").toString();
        String content = "";
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        Map<String, Object> map = new HashMap<>();
        map.put("pubDate", pubDate);
        List<QaDO> list = qaService.list(map);
        for (QaDO qa : list) {
            content += qa.getContent();
        }
        String result = HttpClientUtils.httpPostWithJson(content, "http://123.206.46.153:7911/wordcloud/", null);
        JSONObject data = JSONObject.fromObject(result);
        String resultData = data.getString("result");
        //原始数据保存到t_cipin
        CipinDO cipinDo = new CipinDO();
        cipinDo.setContent(resultData);
        cipinDo.setPubDate(pubDate);
        cipinDo.setCreateDate(new Date());
        cipinService.save(cipinDo);

        JSONArray myJsonArray = JSONArray.fromObject(resultData);
        if(myJsonArray.size()>0){
            for(int i=0;i<myJsonArray.size();i++){
                JSONObject job = myJsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println(job.get("name")+"="+job.get("value")+"=") ;  // 得到 每个对象中的属性值
                ProcessDataDO processDataDO = new ProcessDataDO();
                processDataDO.setName(job.get("name").toString());
                processDataDO.setValue(Integer.parseInt(job.get("value").toString()));
                processDataDO.setPubDate(pubDate);
                processDataDO.setCreateDate(new Date());

                processDataService.save(processDataDO);
            }
        }

        //将结果存到t_cipin表中
//        CipinDO cipinDo = new CipinDO();
//        cipinDo.setContent(resultDate);
//        cipinDo.setPubDate(pubDate);
//        cipinDo.setCreateDate(new Date());
//        cipinService.save(cipinDo);


        return "";
    }
}