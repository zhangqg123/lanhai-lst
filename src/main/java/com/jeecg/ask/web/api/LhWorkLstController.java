package com.jeecg.ask.web.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeecg.ask.entity.LhDsAskColumnEntity;
import com.jeecg.ask.entity.LhDsAskEntity;
import com.jeecg.ask.service.LhDsAskColumnService;
import com.jeecg.ask.service.LhDsAskService;

/**
 * 描述：考试表
 * @author: www.jeecg.org
 * @since：2018年12月26日 07时46分03秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/work/lst")
public class LhWorkLstController extends BaseController{
  @Autowired
  private LhDsAskColumnService lhDsAskColumnService;
  @Autowired
  private LhDsAskService lhDsAskService;

	@RequestMapping(value="/columnList")
	public @ResponseBody String columnList(@ModelAttribute LhDsAskColumnEntity query, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MiniDaoPage<LhDsAskColumnEntity> list = lhDsAskColumnService.getAll(query, 1, 199);
		// 分页数据
		List<?> resut = list.getResults();
		return JSONArray.toJSONString(resut);
	}
	
	@RequestMapping(value="/askList")
	public @ResponseBody AjaxJson examList(@ModelAttribute LhDsAskEntity query, HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "6") int pageSize) throws Exception {
		AjaxJson j = new AjaxJson();
		String guideStatus = request.getParameter("guide_status");
		String categoryId = request.getParameter("category_id");
		if(categoryId!=null && categoryId!="" && !categoryId.equals("all")){
			query.setCategoryId(categoryId);
		}
		String openId = request.getParameter("openId");
		String mode = request.getParameter("mode");
		if(openId!=null && openId!=""){
			if(mode.equals("create")){
				query.setAskOpenId(openId);					
			}
			if(mode.equals("trans")){
				query.setDealOpenId(openId);					
			}
			if(mode.equals("answer")){
				query.setAnswerOpenId(openId);					
			}
		}
		MiniDaoPage<LhDsAskEntity> list = lhDsAskService.getAll(query, pageNo, pageSize);
		// 分页数据
//		List<?> resut = list.getResults();
		j.setObj(list.getResults());
		return j;
	}
	
	@RequestMapping("/queryOneAsk")
	public @ResponseBody AjaxJson queryOneArticles(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String askId = request.getParameter("askId");
		try {
			if(oConvertUtils.isNotEmpty(askId)) {
				LhDsAskEntity ask = lhDsAskService.get(askId);
				j.setObj(ask);
				j.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}

}

