package com.jeecg.ask.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.ask.entity.LhDsAskEntity;

/**
 * 描述：提问表
 * @author：www.jeecg.org
 * @since：2019年03月31日 15时06分00秒 星期日 
 * @version:1.0
 */
@Repository
public interface LhDsAskDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_ds_ask WHERE ID = :id")
	LhDsAskEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhDsAsk
	 * @return
	 */
	int update(@Param("lhDsAsk") LhDsAskEntity lhDsAsk);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhDsAsk") LhDsAskEntity lhDsAsk);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhDsAsk
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhDsAskEntity.class)
	public MiniDaoPage<LhDsAskEntity> getAll(@Param("lhDsAsk") LhDsAskEntity lhDsAsk,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_ds_ask WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_ds_ask WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

