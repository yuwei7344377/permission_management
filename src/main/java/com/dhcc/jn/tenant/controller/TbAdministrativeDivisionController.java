package com.dhcc.jn.tenant.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.entity.TbAdministrativeDivision;
import com.dhcc.jn.tenant.service.TbAdministrativeDivisionService;


/**
 * 
 * 行政区划controller
 * 
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	jlf
 * PG
 *	jlf
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Controller
@RequestMapping("/tbAdministrativeDivision")
public class TbAdministrativeDivisionController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TbAdministrativeDivisionService tbAdministrativeDivisionService;
	
	/**
	 * //查询山西省（tb_administrative_division）
	 * @param parentId
	 * @return
	 */
	/*public JSONObject findByParentId() {
		//获取登录用户信息
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			//在tb_administrative_division表中查询该行政区划下得所有租户信息
			List<TbAdministrativeDivision> list = tbAdministrativeDivisionService.findByParentId();
			if (list != null && !list.isEmpty()) {
				return ResponseMessage.returnInfo(true,list,null,null);
			} else {
				return ResponseMessage.returnInfo(false,null,null,null);
			}
		}else {
			return ResponseMessage.returnInfo(false,null,null,"error");
		}
	}*/
	
	/**
	   *   获取行政区划树
	 * @return
	 */
	@RequestMapping(value="/getTbAdministrativeDivisionTree",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getTbAdministrativeDivisionTree() {
		
		//先查找父节点
		List<TbAdministrativeDivision> list =tbAdministrativeDivisionService.findByParentId();
		if(null != list && list.size()>0){
			
			for(int i=0 ;i<list.size();i++) {
				
				TbAdministrativeDivision tbAdministrativeDivision = list.get(i);
				
				List<TbAdministrativeDivision> list1 = getTbAdministrativeDivisionInfoByParentId(tbAdministrativeDivision.getAdId());
				if(null != list1 && list1.size()>0){
					
					tbAdministrativeDivision.setChildren(list1);	
				}
			}
			return ResponseMessage.returnInfo(true,list,null,null);
		}
		return ResponseMessage.returnInfo(true,null,null,null);
	}
	
	
	/**
	 * 获取 parentId下所有子节点
	 * @param parentId
	 * @return
	 */
	public List<TbAdministrativeDivision>  getTbAdministrativeDivisionInfoByParentId(String parentId) {
		
		TbAdministrativeDivision a = new TbAdministrativeDivision();
		a.setParentId(parentId);
		List<TbAdministrativeDivision> list = tbAdministrativeDivisionService.findBySearch(a);
		
		if(null != list && list.size()>0){
			
			for(int i=0 ;i<list.size();i++) {
				
				TbAdministrativeDivision tbAdministrativeDivision = list.get(i);
				
				List<TbAdministrativeDivision> list1 = getTbAdministrativeDivisionInfoByParentId(tbAdministrativeDivision.getAdId());
				if(null != list1 && list1.size()>0){
					
					tbAdministrativeDivision.setChildren(list1);	
				}
			}
			return list;
		}
		return null;	
	}

	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param adId
	 * @param request
	 * @return
	 */
	@RequestMapping("/tbAdministrativeDivision")
	public String tbAdministrativeDivision(String adId,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(adId)){
				
				TbAdministrativeDivision tbAdministrativeDivision = tbAdministrativeDivisionService.getById(adId);
				request.setAttribute("tbAdministrativeDivision", tbAdministrativeDivision);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbAdministrativeDivision";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbAdministrativeDivision
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbAdministrativeDivision tbAdministrativeDivision){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbAdministrativeDivision.getAdId())){
				
				tbAdministrativeDivisionService.update(tbAdministrativeDivision);
			}
			// 新增
			else{
				
				tbAdministrativeDivisionService.add(tbAdministrativeDivision);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param adId
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String adId){
		
		JSONObject json = new JSONObject();
		
		try {
			
			tbAdministrativeDivisionService.delete(adId);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
