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
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleData;
import com.dhcc.jn.tenant.service.TbTenantTypeRoleDataService;

/**
 * 
 * 用户类型默认角色数据资源关系表controller
 * 
 * <pre>
 * 	历史记录：
 * 	2020-07-23 jlf
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
@RequestMapping("/tbTenantTypeRoleData")
public class TbTenantTypeRoleDataController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbTenantTypeRoleDataService tbTenantTypeRoleDataService;
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "test/tbTenantTypeRoleDataSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleData
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbTenantTypeRoleData tbTenantTypeRoleData,Page<TbTenantTypeRoleData> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbTenantTypeRoleDataService.findByPage(tbTenantTypeRoleData, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbTenantTypeRoleDataList";
	}

	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/tbTenantTypeRoleData")
	public String tbTenantTypeRoleData(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbTenantTypeRoleData tbTenantTypeRoleData = tbTenantTypeRoleDataService.getById(id);
				request.setAttribute("tbTenantTypeRoleData", tbTenantTypeRoleData);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbTenantTypeRoleData";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleData
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbTenantTypeRoleData tbTenantTypeRoleData){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbTenantTypeRoleData.getId())){
				
				tbTenantTypeRoleDataService.update(tbTenantTypeRoleData);
			}
			// 新增
			else{
				
				tbTenantTypeRoleDataService.add(tbTenantTypeRoleData);
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
	 * 	2020-07-23 jlf
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
			
			tbTenantTypeRoleDataService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
