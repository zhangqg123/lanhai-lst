package com.jeecg.ask.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：提问表
 * @author: www.jeecg.org
 * @since：2019年03月31日 15时06分00秒 星期日 
 * @version:1.0
 */
public class LhDsAskEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
