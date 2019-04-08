package com.jeecg.ask.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.ask.entity.LhDsAskColumnEntity;

/**
 * 描述：提问分类表
 * @author：www.jeecg.org
 * @since：2019年04月01日 09时14分08秒 星期一 
 * @version:1.0
 */
@Repository
public interface LhDsAskColumnDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM lh_ds_ask_column WHERE ID = :id")
	LhDsAskColumnEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param lhDsAskColumn
	 * @return
	 */
	int update(@Param("lhDsAskColumn") LhDsAskColumnEntity lhDsAskColumn);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("lhDsAskColumn") LhDsAskColumnEntity lhDsAskColumn);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param lhDsAskColumn
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(LhDsAskColumnEntity.class)
	public MiniDaoPage<LhDsAskColumnEntity> getAll(@Param("lhDsAskColumn") LhDsAskColumnEntity lhDsAskColumn,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from lh_ds_ask_column WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from lh_ds_ask_column WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

