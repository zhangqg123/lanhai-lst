package com.jeecg.ask.utils;

import java.util.ArrayList;
import java.util.List;

import com.jeecg.ask.entity.AskStatusEntity;

public class LstConstants {
	public static final Integer CREATE_ASK = 11;
	public static final Integer AUDIT_ASK = 12;
	public static final Integer ASK_DENY = 13;
	public static final Integer TRANS_ASK = 21;
	public static final Integer ANSWER_ASK = 31;
	public static final Integer AUDIT_ANSWER = 32;
	public static final Integer ANSWER_DENY = 33;
	public static final Integer TRANS_ANSWER = 41;
	public static final Integer BLACK_LIST = 77;
	
	public static List<AskStatusEntity> getStatusList() {
		List<AskStatusEntity> statusList=new ArrayList<AskStatusEntity>();
		statusList.add(new AskStatusEntity(LstConstants.CREATE_ASK,"提问待审核"));
		statusList.add(new AskStatusEntity(LstConstants.AUDIT_ASK,"提问已审核"));
		statusList.add(new AskStatusEntity(LstConstants.TRANS_ASK,"提问已翻译"));
		statusList.add(new AskStatusEntity(LstConstants.ASK_DENY,"提问未通过"));
		statusList.add(new AskStatusEntity(LstConstants.ANSWER_ASK,"回答待审核"));
		statusList.add(new AskStatusEntity(LstConstants.AUDIT_ANSWER,"回答已审核"));
		statusList.add(new AskStatusEntity(LstConstants.ANSWER_DENY,"回答未通过"));
		statusList.add(new AskStatusEntity(LstConstants.TRANS_ANSWER,"回答已翻译"));
		statusList.add(new AskStatusEntity(LstConstants.BLACK_LIST,"提问黑名单"));
		return statusList;
	}
}
