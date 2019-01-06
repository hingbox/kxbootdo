package com.bootdo.cipin.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-22 21:14:14
 */
public class ProcessDataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private Integer value;
	//
	private String pubDate;
	//
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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	/**
	 * 获取：
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * 设置：
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
