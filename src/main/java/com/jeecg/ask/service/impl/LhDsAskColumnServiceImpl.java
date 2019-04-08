package com.jeecg.ask.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.ask.dao.LhDsAskColumnDao;
import com.jeecg.ask.entity.LhDsAskColumnEntity;
import com.jeecg.ask.service.LhDsAskColumnService;

/**
 * 描述：提问分类表
 * @author: www.jeecg.org
 * @since：2019年04月01日 09时14分08秒 星期一 
 * @version:1.0
 */

@Service("lhDsAskColumnService")
public class LhDsAskColumnServiceImpl implements LhDsAskColumnService {
	@Resource
	private LhDsAskColumnDao lhDsAskColumnDao;

	@Override
	public LhDsAskColumnEntity get(String id) {
		return lhDsAskColumnDao.get(id);
	}

	@Override
	public int update(LhDsAskColumnEntity lhDsAskColumn) {
		return lhDsAskColumnDao.update(lhDsAskColumn);
	}

	@Override
	public void insert(LhDsAskColumnEntity lhDsAskColumn) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhDsAskColumn.setId(randomSeed);
		lhDsAskColumnDao.insert(lhDsAskColumn);
		
	}

	@Override
	public MiniDaoPage<LhDsAskColumnEntity> getAll(LhDsAskColumnEntity lhDsAskColumn, int page, int rows) {
		return lhDsAskColumnDao.getAll(lhDsAskColumn, page, rows);
	}

	@Override
	public void delete(String id) {
		lhDsAskColumnDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhDsAskColumnDao.deleteById(id);
		}
	}
}
