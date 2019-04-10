package com.jeecg.ask.web.api;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.jeecg.ask.entity.LhDsAskEntity;
import com.jeecg.ask.service.LhDsAskService;
import com.jeecg.ask.utils.ImageUtil;

/**
 * CMS API
 * 
 * @author zhangdaihao
 * 
 */
@Controller
@RequestMapping("/api/lst")
public class ApiLstController extends BaseController {
	@Autowired
	private LhDsAskService lhDsAskService;
	
	@RequestMapping(value= "/createAsk", method = RequestMethod.POST)
	public @ResponseBody AjaxJson createAsk(HttpServletRequest request, @RequestBody LhDsAskEntity lstAsk) {
		AjaxJson j = new AjaxJson();
		try {

		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    String sDate = simpleDateFormat.format(new Date());  
			lstAsk.setAskDate(simpleDateFormat.parse(sDate));
			lhDsAskService.insert(lstAsk);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}
	  
	@RequestMapping(value= "/updateAsk", method = RequestMethod.POST)
	public @ResponseBody AjaxJson updateAsk(HttpServletRequest request, @RequestBody LhDsAskEntity lstAsk) {
		AjaxJson j = new AjaxJson();
		try {
			LhDsAskEntity tmpAsk = lhDsAskService.get(lstAsk.getId());
			if(lstAsk.getDescription()!=null && lstAsk.getDescription()!=""){
				tmpAsk.setDescription(lstAsk.getDescription());				
			}
			if(lstAsk.getTransAskUrl()!=null && lstAsk.getTransAskUrl()!=""){
				tmpAsk.setTransAskUrl(lstAsk.getTransAskUrl());			
			}
			if(lstAsk.getAnswerUrl()!=null && lstAsk.getAnswerUrl()!=""){
				tmpAsk.setAnswerUrl(lstAsk.getAnswerUrl());			
			}
			if(lstAsk.getTransAnswerUrl()!=null && lstAsk.getTransAnswerUrl()!=""){
				tmpAsk.setTransAnswerUrl(lstAsk.getTransAnswerUrl());			
			}
			if(lstAsk.getAskStatus()!=null){
				tmpAsk.setAskStatus(lstAsk.getAskStatus());		
			}
			
			tmpAsk.setDealOpenId(lstAsk.getDealOpenId());
			lhDsAskService.update(tmpAsk);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}
	
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    @ResponseBody
    public  AjaxJson doUpload(MultipartHttpServletRequest request, HttpServletResponse response) {
    	AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		try {
//			String existFile = request.getParameter("existFile");
//			String basePath = request.getSession().getServletContext().getRealPath("/");
			//获取所有文件名称  
//	        String basePath=ResourceUtil.getConfigByName("webUploadpath");//demo中设置为D://upFiles,实际项目应因事制宜
	        String basePath = ContextHolderUtils.getRequest().getSession().getServletContext().getRealPath("/");   
			Iterator<String> it = request.getFileNames();  
			while(it.hasNext()){  
			    //根据文件名称取文件  
			    MultipartFile multifile = request.getFile(it.next());  
//			    String fileName = multifile.getOriginalFilename(); 
		        String realFilename=multifile.getOriginalFilename();
		        String fileExtension = realFilename.substring(realFilename.lastIndexOf("."));
				String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 初始化种子
		        String fileName=RandomStringUtils.random(8, str)+System.currentTimeMillis()+fileExtension;
//				if(existFile!=null&existFile!=""){
//					fileName=existFile+fileExtension;
//				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        String datedir = sdf.format(new Date());  
//			    String filePath = "upload/img/lst/"+datedir+"/"; 
			    String filePath = "upload/img/lst/"; 
			    File file = new File(basePath+filePath);
				if (!file.exists()) {
					file.mkdirs();// 创建文件根目录
				}
				filePath = filePath+fileName;
			    String savePath = basePath+filePath;

			    System.out.println(savePath);
			    File newFile = new File(savePath);  
			    //上传的文件写入到指定的文件中  
			    multifile.transferTo(newFile);  
//	    		FileCopyUtils.copy(realFilename.getBytes(), newFile);
				ImageUtil.zoomImageScale(newFile, savePath,300);
			    attributes.put("url", filePath);
			    attributes.put("fileKey", fileName);
			}
			j.setMsg("文件上传成功");
			j.setAttributes(attributes);
		}  catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("文件上传失败");
		}  

		return j;
    }
}
