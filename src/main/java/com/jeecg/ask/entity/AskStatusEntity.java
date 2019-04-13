package com.jeecg.ask.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：提问分类表
 * @author: www.jeecg.org
 * @since：2019年04月01日 09时14分08秒 星期一 
 * @version:1.0
 */
public class AskStatusEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *id	 */	private Integer id;	/**	 *状态名称	 */	private String statusName;
	
	public AskStatusEntity(int id, String statusName ){
		this.id=id;
		this.setStatusName(statusName);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}