package com.bootdo.cipin.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-22 21:02:32
 */
public class TotalContentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//每天查询的内容汇总
	private String totalContent;
	//发布时间
	private String pubDate;
	//创建时间
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：每天查询的内容汇总
	 */
	public void setTotalContent(String totalContent) {
		this.totalContent = totalContent;
	}
	/**
	 * 获取：每天查询的内容汇总
	 */
	public String getTotalContent() {
		return totalContent;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：发布时间
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
