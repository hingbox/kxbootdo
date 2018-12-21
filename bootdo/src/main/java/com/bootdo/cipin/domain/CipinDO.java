package com.bootdo.cipin.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-21 13:30:49
 */
public class CipinDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//内容
	private String content;
	//发布日期
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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：发布日期
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：发布日期
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
