package com.jeecg.ask.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.ask.entity.AskStatusEntity;
import com.jeecg.ask.entity.LhDsAskColumnEntity;
import com.jeecg.ask.entity.LhDsAskEntity;
import com.jeecg.ask.service.LhDsAskColumnService;
import com.jeecg.ask.service.LhDsAskService;
import com.jeecg.ask.utils.LstConstants;

 /**
 * 描述：提问表
 * @author: www.jeecg.org
 * @since：2019年03月31日 15时06分00秒 星期日 
 * @version:1.0
 */
@Controller
@RequestMapping("/jeecg/lhDsAsk")
public class LhDsAskController extends BaseController{
  @Autowired
  private LhDsAskService lhDsAskService;
  @Autowired
  private LhDsAskColumnService lhDsAskColumnService;
  
	private String baseUpload = "/upload/img/lst/";
	private String uploadOpenId = "longshi";
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute LhDsAskEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<LhDsAskColumnEntity> clist =  lhDsAskColumnService.getAll(new LhDsAskColumnEntity(),1,100);
				MiniDaoPage<LhDsAskEntity> list =  lhDsAskService.getAll(query,pageNo,pageSize);
				List<AskStatusEntity> statusList = getStatusList();
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("lhDsAsk",query);
				velocityContext.put("columnList", clist.getResults());
				velocityContext.put("statusList", statusList);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/ask/lhDsAsk-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void lhDsAskDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/ask/lhDsAsk-detail.vm";
			LhDsAskEntity lhDsAsk = lhDsAskService.get(id);
			velocityContext.put("lhDsAsk",lhDsAsk);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		MiniDaoPage<LhDsAskColumnEntity> list =  lhDsAskColumnService.getAll(new LhDsAskColumnEntity(),1,100);
		VelocityContext velocityContext = new VelocityContext();
		String sessionid = request.getSession().getId();
		velocityContext.put("sessionid", sessionid);
		velocityContext.put("columnList", list.getResults());
		velocityContext.put("baseUpload",baseUpload);
		velocityContext.put("uploadOpenId",uploadOpenId);
		String viewName = "jeecg/ask/lhDsAsk-add.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute LhDsAskEntity lhDsAsk){
		AjaxJson j = new AjaxJson();
		try {
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    String sDate = simpleDateFormat.format(new Date()); 
		    
		    lhDsAsk.setAskDate(simpleDateFormat.parse(sDate));
			lhDsAsk.setAskStatus(LstConstants.TRANS_ANSWER);
			lhDsAsk.setStatusName("回答已翻译");
		    lhDsAskService.insert(lhDsAsk);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		MiniDaoPage<LhDsAskColumnEntity> list =  lhDsAskColumnService.getAll(new LhDsAskColumnEntity(),1,100);
		VelocityContext velocityContext = new VelocityContext();
		LhDsAskEntity lhDsAsk = lhDsAskService.get(id);
		List<AskStatusEntity> statusList = getStatusList();
		
		String sessionid = request.getSession().getId();
		velocityContext.put("sessionid", sessionid);
		velocityContext.put("lhDsAsk",lhDsAsk);
		velocityContext.put("columnList", list.getResults());
		velocityContext.put("baseUpload",baseUpload);
		velocityContext.put("uploadOpenId",uploadOpenId);
		
		velocityContext.put("statusList", statusList);
		String viewName = "jeecg/ask/lhDsAsk-edit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	private List<AskStatusEntity> getStatusList() {
		List<AskStatusEntity> statusList=new ArrayList<AskStatusEntity>();
		statusList.add(new AskStatusEntity(LstConstants.CREATE_ASK,"提问待审核"));
		statusList.add(new AskStatusEntity(LstConstants.AUDIT_ASK,"提问已审核"));
		statusList.add(new AskStatusEntity(LstConstants.TRANS_ASK,"提问已翻译"));
		statusList.add(new AskStatusEntity(LstConstants.ANSWER_ASK,"回答待审核"));
		statusList.add(new AskStatusEntity(LstConstants.AUDIT_ANSWER,"回答已审核"));
		statusList.add(new AskStatusEntity(LstConstants.TRANS_ANSWER,"回答已翻译"));
		return statusList;
	}
	
	@RequestMapping(params="toAudit",method = RequestMethod.GET)
	public void toAudit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		MiniDaoPage<LhDsAskColumnEntity> list =  lhDsAskColumnService.getAll(new LhDsAskColumnEntity(),1,100);
		VelocityContext velocityContext = new VelocityContext();
		LhDsAskEntity lhDsAsk = lhDsAskService.get(id);
		List<AskStatusEntity> statusList = getStatusList();
		for(AskStatusEntity status : statusList){
			if(status.getId()==lhDsAsk.getAskStatus()){
				lhDsAsk.setStatusName(status.getStatusName());
				break;
			}
		}

//		lhDsAsk.setAskUrl(lhDsAsk.getAskUrl().trim());
 		String sessionid = request.getSession().getId();
		velocityContext.put("sessionid", sessionid);
		velocityContext.put("lhDsAsk",lhDsAsk);
		velocityContext.put("baseUpload",baseUpload);
		velocityContext.put("columnList", list.getResults());
//		velocityContext.put("statusList", statusList);
		String viewName = "jeecg/ask/lhDsAsk-audit.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute LhDsAskEntity lhDsAsk){
		AjaxJson j = new AjaxJson();
		try {
			lhDsAsk.setDealDate(new Date());
			lhDsAskService.update(lhDsAsk);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		    e.printStackTrace();
		}
		return j;
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doAudit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAudit(@ModelAttribute LhDsAskEntity lhDsAsk){
		AjaxJson j = new AjaxJson();
		try {
//			LhDsAskEntity oriAsk = lhDsAskService.get(lhDsAsk.getId());
			Integer status = lhDsAsk.getAskStatus();
			if(lhDsAsk.getReply().equals("pass")){
				if(status==LstConstants.CREATE_ASK){
					lhDsAsk.setAskStatus(LstConstants.AUDIT_ASK);
				}
				if(status==LstConstants.ANSWER_ASK){
					lhDsAsk.setAskStatus(LstConstants.AUDIT_ANSWER);
				}
			}
			lhDsAskService.update(lhDsAsk);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		    e.printStackTrace();
		}
		return j;
	}

	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
				lhDsAskService.delete(id);
				j.setMsg("删除成功");
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("删除失败");
			    e.printStackTrace();
			}
			return j;
	}
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping(params="batchDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			lhDsAskService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

