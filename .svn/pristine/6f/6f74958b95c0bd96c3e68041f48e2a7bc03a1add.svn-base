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
import com.dhcc.jn.tenant.entity.VRoletype;
import com.dhcc.jn.tenant.service.VRoletypeService;

/**
 * 
 * 角色类型字典表controller
 * 
 * <pre>
 * 	历史记录：
 * 	2020-08-26 jlf
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
@RequestMapping("/vRoletype")
public class VRoletypeController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private VRoletypeService vRoletypeService;
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "roleType/vRoletypeSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vRoletype
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(VRoletype vRoletype,Page<VRoletype> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", vRoletypeService.findByPage(vRoletype, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "roleType/vRoletypeList";
	}

	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/vRoletype")
	public String vRoletype(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				VRoletype vRoletype = vRoletypeService.getById(id);
				request.setAttribute("vRoletype", vRoletype);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "roleType/vRoletype";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param vRoletype
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(VRoletype vRoletype){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(vRoletype.getId())){
				
				vRoletypeService.update(vRoletype);
			}
			// 新增
			else{
				
				vRoletypeService.add(vRoletype);
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
	 * 	2020-08-26 jlf
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
			
			vRoletypeService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
