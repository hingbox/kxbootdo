package com.bootdo.test.domain;

import com.alibaba.fastjson.JSON;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.test.dao
 * @ClassName: Words
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2019/1/8 10:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/8 10:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Document
public class Words {
    @Id
    private String id;
    private String aggs_result;
    private String detail_result;
    private String error;
    private String info;
    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAggs_result() {
        return aggs_result;
    }

    public void setAggs_result(String aggs_result) {
        this.aggs_result = aggs_result;
    }

    public String getDetail_result() {
        return detail_result;
    }

    public void setDetail_result(String detail_result) {
        this.detail_result = detail_result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}