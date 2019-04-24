package com.jeecg.ask.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.jeecg.ask.entity.LhDsAskEntity;

/**
 * 描述：提问表
 * @author: www.jeecg.org
 * @since：2019年03月31日 15时06分00秒 星期日 
 * @version:1.0
 */
public interface LhDsAskService {
	public LhDsAskEntity get(String id);

	public int update(LhDsAskEntity lhDsAsk);

	public void insert(LhDsAskEntity lhDsAsk);

	public MiniDaoPage<LhDsAskEntity> getAll(LhDsAskEntity lhDsAsk,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public void doBlack(LhDsAskEntity lhDsAsk);

	public void doRestore(LhDsAskEntity lhDsAsk);
	
}
