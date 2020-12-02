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
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleResource;
import com.dhcc.jn.tenant.service.TbTenantTypeRoleResourceService;

/**
 * 
 * 用户类型角色资源清单表controller
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
@RequestMapping("/tbTenantTypeRoleResource")
public class TbTenantTypeRoleResourceController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbTenantTypeRoleResourceService tbTenantTypeRoleResourceService;
	
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
		
		return "test/tbTenantTypeRoleResourceSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleResource
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbTenantTypeRoleResource tbTenantTypeRoleResource,Page<TbTenantTypeRoleResource> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbTenantTypeRoleResourceService.findByPage(tbTenantTypeRoleResource, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbTenantTypeRoleResourceList";
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
	@RequestMapping("/tbTenantTypeRoleResource")
	public String tbTenantTypeRoleResource(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbTenantTypeRoleResource tbTenantTypeRoleResource = tbTenantTypeRoleResourceService.getById(id);
				request.setAttribute("tbTenantTypeRoleResource", tbTenantTypeRoleResource);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbTenantTypeRoleResource";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleResource
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbTenantTypeRoleResource tbTenantTypeRoleResource){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbTenantTypeRoleResource.getId())){
				
				tbTenantTypeRoleResourceService.update(tbTenantTypeRoleResource);
			}
			// 新增
			else{
				
				tbTenantTypeRoleResourceService.add(tbTenantTypeRoleResource);
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
			
			tbTenantTypeRoleResourceService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
