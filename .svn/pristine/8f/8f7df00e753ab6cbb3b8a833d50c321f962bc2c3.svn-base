package com.dhcc.jn.tenant.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbRoleOrgYy;
import com.dhcc.jn.tenant.service.TbRoleOrgYyService;

/**
 * 
 * 运营角色组织关系表controller
 * 
 * <pre>
 * 	历史记录：
 * 	2020-08-27 jlf
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
@RequestMapping("/tbRoleOrgYy")
public class TbRoleOrgYyController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private TbRoleOrgYyService tbRoleOrgYyService;
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "test/tbRoleOrgYySearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbRoleOrgYy
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbRoleOrgYy tbRoleOrgYy,Page<TbRoleOrgYy> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbRoleOrgYyService.findByPage(tbRoleOrgYy, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbRoleOrgYyList";
	}

	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/tbRoleOrgYy")
	public String tbRoleOrgYy(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbRoleOrgYy tbRoleOrgYy = tbRoleOrgYyService.getById(id);
				request.setAttribute("tbRoleOrgYy", tbRoleOrgYy);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbRoleOrgYy";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbRoleOrgYy
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbRoleOrgYy tbRoleOrgYy){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbRoleOrgYy.getId())){
				
				tbRoleOrgYyService.update(tbRoleOrgYy);
			}
			// 新增
			else{
				
				tbRoleOrgYyService.add(tbRoleOrgYy);
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
	 * 	2020-08-27 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		
		JSONObject json = new JSONObject();
		
		try {
			
			tbRoleOrgYyService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
