package com.jeecg.ask.service.impl;

import javax.annotation.Resource;

import java.util.UUID;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.ask.dao.LhDsAskDao;
import com.jeecg.ask.entity.LhDsAskEntity;
import com.jeecg.ask.service.LhDsAskService;
import com.jeecg.ask.utils.LstConstants;
import com.jeecg.lhs.dao.LhSBlacklistDao;
import com.jeecg.lhs.dao.LhSUserDao;
import com.jeecg.lhs.entity.LhSBlacklistEntity;
import com.jeecg.lhs.entity.LhSUserEntity;

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
	@Resource
	private LhSUserDao lhSUserDao;
	@Resource
	private LhSBlacklistDao lhSBlacklistDao;
	
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
	
	@Override
	@Transactional
	public void doBlack(LhDsAskEntity lhDsAsk) {
		LhDsAskEntity oldLhDsAsk = lhDsAskDao.get(lhDsAsk.getId());
		String openId = oldLhDsAsk.getAskOpenId();
		LhSUserEntity lhSUser = lhSUserDao.getByOpenId(openId);
		LhSBlacklistEntity lhSBlacklist=new LhSBlacklistEntity();
		lhSBlacklist.setPhone(lhSUser.getPhone());
		lhSBlacklist.setIdcard(lhSUser.getIdcard());
		lhSBlacklist.setOpenId(lhSUser.getOpenid());
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		lhSBlacklist.setId(randomSeed);
		lhSBlacklistDao.insert(lhSBlacklist);
		lhDsAsk.setAskStatus(LstConstants.BLACK_LIST);//77、黑名单
//		lhDsAsk.setAskUrl("");
//		lhDsAsk.setBlack(1);
		lhDsAskDao.update(lhDsAsk);
		lhSUser.setStatus(LstConstants.BLACK_LIST);// 77、黑名单
		lhSUserDao.update(lhSUser);
	}

	@Override
	@Transactional
	public void doRestore(LhDsAskEntity lhDsAsk) {
		lhDsAsk.setAskStatus(LstConstants.CREATE_ASK);// 11、创建和解冻
		lhDsAskDao.update(lhDsAsk);
		LhDsAskEntity oldLhDsAsk = lhDsAskDao.get(lhDsAsk.getId());
		String openId = oldLhDsAsk.getAskOpenId();
		LhSUserEntity lhSUser = lhSUserDao.getByOpenId(openId);
		lhSUser.setStatus(3);// 3、未实名用户
		lhSUserDao.update(lhSUser);
		lhSBlacklistDao.deleteByOpenId(openId);
	}

}
