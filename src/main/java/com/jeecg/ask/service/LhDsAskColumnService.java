package com.jeecg.ask.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.ask.entity.LhDsAskColumnEntity;

/**
 * 描述：提问分类表
 * @author: www.jeecg.org
 * @since：2019年04月01日 09时14分08秒 星期一 
 * @version:1.0
 */
public interface LhDsAskColumnService {
	public LhDsAskColumnEntity get(String id);

	public int update(LhDsAskColumnEntity lhDsAskColumn);

	public void insert(LhDsAskColumnEntity lhDsAskColumn);

	public MiniDaoPage<LhDsAskColumnEntity> getAll(LhDsAskColumnEntity lhDsAskColumn,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
