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
import com.dhcc.jn.tenant.entity.TbTenantTypeResource;
import com.dhcc.jn.tenant.service.TbTenantTypeResourceService;

/**
 * 
 * 租户类型功能清单controller
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
@RequestMapping("/tbTenantTypeResource")
public class TbTenantTypeResourceController extends BaseController {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	private TbTenantTypeResourceService tbTenantTypeResourceService;
	
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
		
		return "test/tbTenantTypeResourceSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbTenantTypeResource
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbTenantTypeResource tbTenantTypeResource,Page<TbTenantTypeResource> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbTenantTypeResourceService.findByPage(tbTenantTypeResource, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbTenantTypeResourceList";
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
	@RequestMapping("/tbTenantTypeResource")
	public String tbTenantTypeResource(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbTenantTypeResource tbTenantTypeResource = tbTenantTypeResourceService.getById(id);
				request.setAttribute("tbTenantTypeResource", tbTenantTypeResource);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbTenantTypeResource";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbTenantTypeResource
	 * @return
	 *//*
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbTenantTypeResource tbTenantTypeResource){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbTenantTypeResource.getId())){
				
				tbTenantTypeResourceService.update(tbTenantTypeResource);
			}
			// 新增
			else{
				
				tbTenantTypeResourceService.add(tbTenantTypeResource);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}*/
	
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
			
			tbTenantTypeResourceService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
