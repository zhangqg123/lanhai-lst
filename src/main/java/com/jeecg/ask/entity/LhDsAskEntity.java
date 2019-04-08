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
		/**	 *ID标识	 */	private String id;	/**	 *提问标题	 */	private String askTitle;	/**	 * 问题描述	 */	private String description;	/**	 *分类	 */	private String categoryId;
	private String categoryName;	/**	 *提问视频	 */	private String askUrl;	/**	 *提问翻译视频	 */	private String transAskUrl;	/**	 *回答视频	 */	private String answerUrl;	/**	 *回答翻译视频	 */	private String transAnswerUrl;	/**	 *问题数量	 */	private Integer askNum;	/**	 *提问状态	 */	private Integer askStatus;	/**	 *提问人	 */	private String askPersonId;	/**	 *提问人openid	 */	private String askOpenId;	/**	 *提问日期 	 */	private Date askDate;	/**	 *办理人员	 */	private String dealPersonId;	/**	 *办理人员openid	 */	private String dealOpenId;	/**	 *办理日期	 */	private Date dealDate;	/**	 *审核人 	 */	private String audit;	/**	 *回复	 */	private String reply;	/**	 *流程号	 */	private String processinstanceid;	/**	 *备注	 */	private String remark;	/**	 *formId	 */	private String formId;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getAskTitle() {	    return this.askTitle;	}	public void setAskTitle(String askTitle) {	    this.askTitle=askTitle;	}	public String getDescription() {	    return this.description;	}	public void setDescription(String description) {	    this.description=description;	}	public String getCategoryId() {	    return this.categoryId;	}	public void setCategoryId(String categoryId) {	    this.categoryId=categoryId;	}	public String getAskUrl() {	    return this.askUrl;	}	public void setAskUrl(String askUrl) {	    this.askUrl=askUrl;	}	public String getTransAskUrl() {	    return this.transAskUrl;	}	public void setTransAskUrl(String transAskUrl) {	    this.transAskUrl=transAskUrl;	}	public String getAnswerUrl() {	    return this.answerUrl;	}	public void setAnswerUrl(String answerUrl) {	    this.answerUrl=answerUrl;	}	public String getTransAnswerUrl() {	    return this.transAnswerUrl;	}	public void setTransAnswerUrl(String transAnswerUrl) {	    this.transAnswerUrl=transAnswerUrl;	}	public Integer getAskNum() {	    return this.askNum;	}	public void setAskNum(Integer askNum) {	    this.askNum=askNum;	}	public Integer getAskStatus() {	    return this.askStatus;	}	public void setAskStatus(Integer askStatus) {	    this.askStatus=askStatus;	}	public String getAskPersonId() {	    return this.askPersonId;	}	public void setAskPersonId(String askPersonId) {	    this.askPersonId=askPersonId;	}	public String getAskOpenId() {	    return this.askOpenId;	}	public void setAskOpenId(String askOpenId) {	    this.askOpenId=askOpenId;	}	public Date getAskDate() {	    return this.askDate;	}	public void setAskDate(Date askDate) {	    this.askDate=askDate;	}	public String getDealPersonId() {	    return this.dealPersonId;	}	public void setDealPersonId(String dealPersonId) {	    this.dealPersonId=dealPersonId;	}	public String getDealOpenId() {	    return this.dealOpenId;	}	public void setDealOpenId(String dealOpenId) {	    this.dealOpenId=dealOpenId;	}	public Date getDealDate() {	    return this.dealDate;	}	public void setDealDate(Date dealDate) {	    this.dealDate=dealDate;	}	public String getAudit() {	    return this.audit;	}	public void setAudit(String audit) {	    this.audit=audit;	}	public String getReply() {	    return this.reply;	}	public void setReply(String reply) {	    this.reply=reply;	}	public String getProcessinstanceid() {	    return this.processinstanceid;	}	public void setProcessinstanceid(String processinstanceid) {	    this.processinstanceid=processinstanceid;	}	public String getRemark() {	    return this.remark;	}	public void setRemark(String remark) {	    this.remark=remark;	}	public String getFormId() {	    return this.formId;	}	public void setFormId(String formId) {	    this.formId=formId;	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}

