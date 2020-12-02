package com.dhcc.jn.tenant.controller;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbUserRole;
import com.dhcc.jn.tenant.service.TbUserRoleService;

/**
 * 
 * 账户角色关系controller
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
@RequestMapping("/tbUserRole")
public class TbUserRoleController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbUserRoleService tbUserRoleService;
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "test/tbUserRoleSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbUserRole
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbUserRole tbUserRole,Page<TbUserRole> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbUserRoleService.findByPage(tbUserRole, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbUserRoleList";
	}

	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/tbUserRole")
	public String tbUserRole(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbUserRole tbUserRole = tbUserRoleService.getById(id);
				request.setAttribute("tbUserRole", tbUserRole);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbUserRole";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbUserRole
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbUserRole tbUserRole){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbUserRole.getId())){
				
				tbUserRoleService.update(tbUserRole);
			}
			// 新增
			else{
				
				tbUserRoleService.add(tbUserRole);
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
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		
		JSONObject json = new JSONObject();
		
		try {
			
			tbUserRoleService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
