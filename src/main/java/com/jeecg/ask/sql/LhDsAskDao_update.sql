UPDATE lh_ds_ask
SET 
	   <#if lhDsAsk.id ?exists>
		   ID = :lhDsAsk.id,
		</#if>
	   <#if lhDsAsk.askTitle ?exists>
		   ASK_TITLE = :lhDsAsk.askTitle,
		</#if>
	   <#if lhDsAsk.description ?exists>
		   DESCRIPTION = :lhDsAsk.description,
		</#if>
	   <#if lhDsAsk.categoryId ?exists>
		   CATEGORY_ID = :lhDsAsk.categoryId,
		</#if>
	   <#if lhDsAsk.askUrl ?exists>
		   ASK_URL = :lhDsAsk.askUrl,
		</#if>
	   <#if lhDsAsk.transAskUrl ?exists>
		   TRANS_ASK_URL = :lhDsAsk.transAskUrl,
		</#if>
	   <#if lhDsAsk.answerUrl ?exists>
		   ANSWER_URL = :lhDsAsk.answerUrl,
		</#if>
	   <#if lhDsAsk.transAnswerUrl ?exists>
		   TRANS_ANSWER_URL = :lhDsAsk.transAnswerUrl,
		</#if>
	   <#if lhDsAsk.askNum ?exists>
		   ASK_NUM = :lhDsAsk.askNum,
		</#if>
	   <#if lhDsAsk.askStatus ?exists>
		   ASK_STATUS = :lhDsAsk.askStatus,
		</#if>
	   <#if lhDsAsk.askPersonId ?exists>
		   ASK_PERSON_ID = :lhDsAsk.askPersonId,
		</#if>
	   <#if lhDsAsk.askOpenId ?exists>
		   ASK_OPEN_ID = :lhDsAsk.askOpenId,
		</#if>
	    <#if lhDsAsk.askDate ?exists>
		   ASK_DATE = :lhDsAsk.askDate,
		</#if>
	   <#if lhDsAsk.dealPersonId ?exists>
		   DEAL_PERSON_ID = :lhDsAsk.dealPersonId,
		</#if>
	   <#if lhDsAsk.dealOpenId ?exists>
		   DEAL_OPEN_ID = :lhDsAsk.dealOpenId,
		</#if>
	    <#if lhDsAsk.dealDate ?exists>
		   DEAL_DATE = :lhDsAsk.dealDate,
		</#if>
	   <#if lhDsAsk.answerOpenId ?exists>
		   ANSWER_OPEN_ID = :lhDsAsk.answerOpenId,
		</#if>
	   <#if lhDsAsk.audit ?exists>
		   AUDIT = :lhDsAsk.audit,
		</#if>
	   <#if lhDsAsk.reply ?exists>
		   REPLY = :lhDsAsk.reply,
		</#if>
	   <#if lhDsAsk.processinstanceid ?exists>
		   PROCESSINSTANCEID = :lhDsAsk.processinstanceid,
		</#if>
	   <#if lhDsAsk.remark ?exists>
		   REMARK = :lhDsAsk.remark,
		</#if>
	   <#if lhDsAsk.formId ?exists>
		   FORM_ID = :lhDsAsk.formId,
		</#if>
WHERE id = :lhDsAsk.id