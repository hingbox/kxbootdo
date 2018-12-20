package com.bootdo.cipin.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.controller
 * @ClassName: vcc
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018-12-20 13:34:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2018-12-20 13:34:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class QaDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//根据title和source_from生成的唯一标识
	private String uuid;
	//用户昵称
	private String nickName;
	//提问日期
	private Date pubDate;
	//提问内容
	private String content;
	//来源，上证(sh),深圳(sz)
	private String source;
	//股票名称
	private String stock;
	//股票代码
	private String code;
	//0,提问，1回答
	private String qa;
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
	 * 设置：根据title和source_from生成的唯一标识
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * 获取：根据title和source_from生成的唯一标识
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 设置：用户昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：用户昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：提问日期
	 */
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：提问日期
	 */
	public Date getPubDate() {
		return pubDate;
	}
	/**
	 * 设置：提问内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：提问内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：来源，上证(sh),深圳(sz)
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：来源，上证(sh),深圳(sz)
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：股票名称
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}
	/**
	 * 获取：股票名称
	 */
	public String getStock() {
		return stock;
	}
	/**
	 * 设置：股票代码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：股票代码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：0,提问，1回答
	 */
	public void setQa(String qa) {
		this.qa = qa;
	}
	/**
	 * 获取：0,提问，1回答
	 */
	public String getQa() {
		return qa;
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
