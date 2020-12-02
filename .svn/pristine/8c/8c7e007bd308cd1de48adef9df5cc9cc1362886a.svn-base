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
import com.dhcc.jn.tenant.entity.TbCoalPound;
import com.dhcc.jn.tenant.service.TbCoalPoundService;

/**
 * 
 * 企业进出磅道设置controller
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
@RequestMapping("/tbCoalPound")
public class TbCoalPoundController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private TbCoalPoundService tbCoalPoundService;
	
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
		
		return "test/tbCoalPoundSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbCoalPound
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbCoalPound tbCoalPound,Page<TbCoalPound> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbCoalPoundService.findByPage(tbCoalPound, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbCoalPoundList";
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
	@RequestMapping("/tbCoalPound")
	public String tbCoalPound(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbCoalPound tbCoalPound = tbCoalPoundService.getById(id);
				request.setAttribute("tbCoalPound", tbCoalPound);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbCoalPound";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbCoalPound
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbCoalPound tbCoalPound){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbCoalPound.getId())){
				
				tbCoalPoundService.update(tbCoalPound);
			}
			// 新增
			else{
				
				tbCoalPoundService.add(tbCoalPound);
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
			
			tbCoalPoundService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
