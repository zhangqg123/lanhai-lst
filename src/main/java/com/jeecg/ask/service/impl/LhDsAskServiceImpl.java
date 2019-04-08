package com.jeecg.ask.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.ask.dao.LhDsAskDao;
import com.jeecg.ask.entity.LhDsAskEntity;
import com.jeecg.ask.service.LhDsAskService;

/**
 * 描述：提问表
 * @author: www.jeecg.org
 * @since：2019年03月31日 15时06分00秒 星期日 
 * @version:1.0
 */

@Service("lhDsAskService")
public class LhDsAskServiceImpl implements LhDsAskService {
	@Resource
	private LhDsAskDao lhDsAskDao;

	@Override
	public LhDsAskEntity get(String id) {
		return lhDsAskDao.get(id);
	}

	@Override
	public int update(LhDsAskEntity lhDsAsk) {
		return lhDsAskDao.update(lhDsAsk);
	}

	@Override
	public void insert(LhDsAskEntity lhDsAsk) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhDsAsk.setId(randomSeed);
		lhDsAskDao.insert(lhDsAsk);
		
	}

	@Override
	public MiniDaoPage<LhDsAskEntity> getAll(LhDsAskEntity lhDsAsk, int page, int rows) {
		return lhDsAskDao.getAll(lhDsAsk, page, rows);
	}

	@Override
	public void delete(String id) {
		lhDsAskDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			lhDsAskDao.deleteById(id);
		}
	}
}
