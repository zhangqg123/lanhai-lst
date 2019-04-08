		<#if ( lhDsAsk.id )?? && lhDsAsk.id ?length gt 0>
		    /* ID标识 */
			and lda.ID = :lhDsAsk.id
		</#if>
		<#if ( lhDsAsk.askTitle )?? && lhDsAsk.askTitle ?length gt 0>
		    /* 提问标题 */
			and lda.ASK_TITLE = :lhDsAsk.askTitle
		</#if>
		<#if ( lhDsAsk.description )?? && lhDsAsk.description ?length gt 0>
		    /*  问题描述 */
			and lda.DESCRIPTION = :lhDsAsk.description
		</#if>
		<#if ( lhDsAsk.categoryId )?? && lhDsAsk.categoryId ?length gt 0>
		    /* 分类 */
			and lda.CATEGORY_ID = :lhDsAsk.categoryId
		</#if>
		<#if ( lhDsAsk.askUrl )?? && lhDsAsk.askUrl ?length gt 0>
		    /* 提问视频 */
			and lda.ASK_URL = :lhDsAsk.askUrl
		</#if>
		<#if ( lhDsAsk.transAskUrl )?? && lhDsAsk.transAskUrl ?length gt 0>
		    /* 提问翻译视频 */
			and lda.TRANS_ASK_URL = :lhDsAsk.transAskUrl
		</#if>
		<#if ( lhDsAsk.answerUrl )?? && lhDsAsk.answerUrl ?length gt 0>
		    /* 回答视频 */
			and lda.ANSWER_URL = :lhDsAsk.answerUrl
		</#if>
		<#if ( lhDsAsk.transAnswerUrl )?? && lhDsAsk.transAnswerUrl ?length gt 0>
		    /* 回答翻译视频 */
			and lda.TRANS_ANSWER_URL = :lhDsAsk.transAnswerUrl
		</#if>
		<#if ( lhDsAsk.askNum )?? && lhDsAsk.askNum ?length gt 0>
		    /* 问题数量 */
			and lda.ASK_NUM = :lhDsAsk.askNum
		</#if>
		<#if ( lhDsAsk.askStatus )?? && lhDsAsk.askStatus ?length gt 0>
		    /* 提问状态 */
			and lda.ASK_STATUS = :lhDsAsk.askStatus
		</#if>
		<#if ( lhDsAsk.askPersonId )?? && lhDsAsk.askPersonId ?length gt 0>
		    /* 提问人 */
			and lda.ASK_PERSON_ID = :lhDsAsk.askPersonId
		</#if>
		<#if ( lhDsAsk.askOpenId )?? && lhDsAsk.askOpenId ?length gt 0>
		    /* 提问人openid */
			and lda.ASK_OPEN_ID = :lhDsAsk.askOpenId
		</#if>
	    <#if ( lhDsAsk.askDate )??>
		    /* 提问日期  */
			and lda.ASK_DATE = :lhDsAsk.askDate
		</#if>
		<#if ( lhDsAsk.dealPersonId )?? && lhDsAsk.dealPersonId ?length gt 0>
		    /* 办理人员 */
			and lda.DEAL_PERSON_ID = :lhDsAsk.dealPersonId
		</#if>
		<#if ( lhDsAsk.dealOpenId )?? && lhDsAsk.dealOpenId ?length gt 0>
		    /* 办理人员openid */
			and lda.DEAL_OPEN_ID = :lhDsAsk.dealOpenId
		</#if>
	    <#if ( lhDsAsk.dealDate )??>
		    /* 办理日期 */
			and lda.DEAL_DATE = :lhDsAsk.dealDate
		</#if>
		<#if ( lhDsAsk.audit )?? && lhDsAsk.audit ?length gt 0>
		    /* 审核人  */
			and lda.AUDIT = :lhDsAsk.audit
		</#if>
		<#if ( lhDsAsk.reply )?? && lhDsAsk.reply ?length gt 0>
		    /* 回复 */
			and lda.REPLY = :lhDsAsk.reply
		</#if>
		<#if ( lhDsAsk.processinstanceid )?? && lhDsAsk.processinstanceid ?length gt 0>
		    /* 流程号 */
			and lda.PROCESSINSTANCEID = :lhDsAsk.processinstanceid
		</#if>
		<#if ( lhDsAsk.remark )?? && lhDsAsk.remark ?length gt 0>
		    /* 备注 */
			and lda.REMARK = :lhDsAsk.remark
		</#if>
		<#if ( lhDsAsk.formId )?? && lhDsAsk.formId ?length gt 0>
		    /* formId */
			and lda.FORM_ID = :lhDsAsk.formId
		</#if>
