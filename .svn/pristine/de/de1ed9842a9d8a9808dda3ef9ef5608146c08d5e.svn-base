package com.dhcc.jn.tenant.controller;
import java.util.List;
import java.util.Map;

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
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbCoalRelated;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbCoalRelatedService;


/**
 * 
 * 企业表controller
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
@RequestMapping("/tbCoalRelated")
public class TbCoalRelatedController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbCoalRelatedService tbCoalRelatedService;
	
	/**
	 * 获取企业信息
	 * @param parentId
	 * @return
	 */
	@PostMapping("/getByParentId")
	@ResponseBody
	public JSONObject getByParentId(String parentId) {
		// 获取登录用户信息
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			if (null != parentId) {
				List<TbCoalRelated> list = tbCoalRelatedService.getByParentId(parentId);
				if (list != null && !list.isEmpty()) {
					return ResponseMessage.returnInfo(true, list, null, null);
				}else {
					return ResponseMessage.returnInfo(true, list, null, null);
				}
			} else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "请选择区域规划");
			}
		} else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}
	
	/**
	 * 获取企业信息
	 * @param parentId
	 * @return
	 */
	@PostMapping("/findByOrgCode")
	@ResponseBody
	public JSONObject findByOrgCode(String orgCode,String roleId) {
		// 获取登录用户信息
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			if (null != orgCode) {
				List<TbCoalRelated> list = tbCoalRelatedService.findByOrgCode(orgCode,roleId);
				if (list != null && !list.isEmpty()) {
					return ResponseMessage.returnInfo(true, list, null, null);
				}else {
					return ResponseMessage.returnInfo(true, list, null, null);
				}
			} else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "请选择区域规划");
			}
		} else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}
	
	/**
	 * 获取企业下的磅房
	 * @param orgCode
	 * @return
	 */
	@PostMapping("/findrelatedBF")
	@ResponseBody
	public JSONObject findrelatedBF(String qyCode,String roleId) {
		// 获取登录用户信息
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			if (null != qyCode) {
				List<Map<String, Object>> list = tbCoalRelatedService.findrelatedBF(qyCode,roleId);
				if (list != null && !list.isEmpty()) {
					return ResponseMessage.returnInfo(true, list, null, null);
				}else {
					return ResponseMessage.returnInfo(true, null, null, null);
				}
			} else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "请选择企业");
			}
		} else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}
	
	/**
	 * 订阅功能接口
	 * @param qyCode
	 * @return
	 */
	//@PostMapping("/subscribe")
	@RequestMapping(value="/subscribe",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject subscribe(String qyCode) {
		TbUser user = getCurrentUser();
		if(null != user.getUserId()) {
			if(null != qyCode) {
				List<Map<String, Object>> list = tbCoalRelatedService.subscribe(qyCode);
				if(list != null && !list.isEmpty()) {
					return ResponseMessage.returnInfo(true, list, null, null);
				}else {
					return ResponseMessage.returnInfo(true, null, null, null);
				}
			}else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "请选择企业");
			}
		}else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}
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
		
		return "test/tbCoalRelatedSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbCoalRelated
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbCoalRelated tbCoalRelated,Page<TbCoalRelated> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbCoalRelatedService.findByPage(tbCoalRelated, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbCoalRelatedList";
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
	@RequestMapping("/tbCoalRelated")
	public String tbCoalRelated(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbCoalRelated tbCoalRelated = tbCoalRelatedService.getById(id);
				request.setAttribute("tbCoalRelated", tbCoalRelated);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbCoalRelated";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbCoalRelated
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbCoalRelated tbCoalRelated){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbCoalRelated.getId())){
				
				tbCoalRelatedService.update(tbCoalRelated);
			}
			// 新增
			else{
				
				tbCoalRelatedService.add(tbCoalRelated);
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
			
			tbCoalRelatedService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
