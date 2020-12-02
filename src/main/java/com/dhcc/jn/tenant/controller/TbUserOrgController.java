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
import com.dhcc.jn.tenant.entity.TbUserOrg;
import com.dhcc.jn.tenant.service.TbUserOrgService;

/**
 * 
 * 账户组织关系controller
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
@RequestMapping("/tbUserOrg")
public class TbUserOrgController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbUserOrgService tbUserOrgService;

	
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
		
		return "test/tbUserOrgSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbUserOrg
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbUserOrg tbUserOrg,Page<TbUserOrg> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbUserOrgService.findByPage(tbUserOrg, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbUserOrgList";
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
	@RequestMapping("/tbUserOrg")
	public String tbUserOrg(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbUserOrg tbUserOrg = tbUserOrgService.getById(id);
				request.setAttribute("tbUserOrg", tbUserOrg);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbUserOrg";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbUserOrg
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbUserOrg tbUserOrg){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbUserOrg.getId())){
				
				tbUserOrgService.update(tbUserOrg);
			}
			// 新增
			else{
				
				tbUserOrgService.add(tbUserOrg);
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
			
			tbUserOrgService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
