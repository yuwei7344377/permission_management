package com.dhcc.jn.tenant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbRoleResource;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbRoleResourceService;

/**
 * 
 * 角色资源清单controller
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
@RequestMapping("/tbRoleResource")
public class TbRoleResourceController extends BaseController {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbRoleResourceService tbRoleResourceService;
	
	/**
	 * //获取功能资源树
	 * @param roleId
	 * @param zhTypeId
	 * @return
	 */
	@PostMapping("/findResourceTree")
	@ResponseBody
	public JSONObject findResourceTree(String roleId,String zhTypeId) {
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			if (null != roleId) {
				if (null != zhTypeId) {
					List<Map<String, Object>> list = tbRoleResourceService.findResourceTree(roleId,zhTypeId);
					if (null != list && !list.isEmpty()) {
						return ResponseMessage.returnInfo(true, list, null, null);
					}else {
						return ResponseMessage.returnInfo(true, null, null, null);
					}
				}else {
					return ResponseMessage.returnInfoSpecial(false, null, null, "租户类型ID缺失");
				}
			}else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "角色ID缺失");
			}
		}else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}

	/**
	 * // 根据该角色id列出所有应用系统+功能资源list
	 * // tb_tenant_type_role_resource和tb_tenant_type_role中rolecode=admin拥有 的最大的资源
	 * @param roleId
	 * @return
	 */
	@PostMapping("/findResource")
	@ResponseBody
	public JSONObject findResource(String zhTypeId,String roleId,String appTypeCode) {
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			if (null != roleId) {
				List<TbResource> list = tbRoleResourceService.findResource(zhTypeId,roleId,appTypeCode);
				if(null != list && list.size()>0) {
					for(int i=0;i<list.size();i++) {
						
						TbResource info = list.get(i);
						List<TbResource> list1 = getTbResourceInfoByParentId(zhTypeId,roleId,appTypeCode,info.getResourceId());
						if (list1 != null && list1.size() > 0) {
							
							 info.setListTbResources(list1);
		                }
					}
				}
				
				if (list != null && !list.isEmpty()) {
					return ResponseMessage.returnInfo(true, list, null, null);
				}else {
					return ResponseMessage.returnInfo(true, null, null, null);
				}
			}else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "请选择角色");
			}
		}else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}
	
	public List<TbResource> getTbResourceInfoByParentId(String zhTypeId,String roleId,String appTypeCode,String parentId) {
    	
        Map map = new HashMap();
        map.put("zhTypeId", zhTypeId);
        map.put("roleId", roleId);
        map.put("appTypeCode", appTypeCode);
        map.put("parentId", parentId);
        List<TbResource> resources = tbRoleResourceService.findRoleResourcesParentResourceId(map);

        if (resources != null && resources.size() > 0) {
            for (int i = 0; i < resources.size(); i++) {
                
            	TbResource tbResource1 = resources.get(i);
                List<TbResource> tbResourceInfoByParentId = getTbResourceInfoByParentId(zhTypeId,roleId,appTypeCode,tbResource1.getResourceId());

                if(null != tbResourceInfoByParentId && tbResourceInfoByParentId.size()>0){	
                
                	tbResource1.setListTbResources(tbResourceInfoByParentId);
                }
            }
            return resources;
        }
        return null;
    }
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取功能资源树
	 * @param zhTypeId
	 * @param roleId
	 * @param appTypeCode
	 * @return
	 */
//	@PostMapping("/getResourceTree")
//	@ResponseBody
//	public JSONObject getResourceTree(String zhTypeId,String roleId,String appTypeCode) {
//		List<Map<String, Object>> list = tbRoleResourceService.findResource(zhTypeId,roleId,appTypeCode);
//		if(null != list && !list.isEmpty()) {
//			for(int i=0 ;i<list.size();i++) {
//				List<Map<String, Object>> list1 = getResourceByParentResourceId(tbResource.getResourceId());
//				if(null != list1 && !list1.isEmpty()) {
//					tbResource.setChildren(list1);
//				}
//			}
//			return ResponseMessage.returnInfo(true,list,null,null);
//		}
//		return ResponseMessage.returnInfo(true,null,null,null);
//	}
//	
	/**
	 * 获取parentResourceId下所有子节点
	 * @param parentResourceId
	 * @return
	 */
//	public List<TbResource> getResourceByParentResourceId(String parentResourceId){
//		List<TbResource> list = tbRoleResourceService.findByParentResourceId(parentResourceId);
//		if(null != list && list.size()>0){
//			
//			for(int i=0 ;i<list.size();i++) {
//				
//				TbResource tbResource = list.get(i);
//				List<TbResource> list1 = getResourceByParentResourceId(tbResource.getResourceId());
//				if(null != list1 && list1.size()>0){
//					
//					tbResource.setChildren(list1);	
//				}
//			}
//			return list;
//		}
//		return null;	
//	}
	
	/**
	 * //为角色分配功能资源（TbRoleResource生成一条数据）
	 * 先查出原来分配的功能资源，删除后重新分配
	 * @param entity
	 * @param request
	 * @return
	 */
	@PostMapping("/saveRoleResource")
	@ResponseBody
	public JSONObject saveRoleResource(String zhId,String roleId,String resourceIds,String appTypeCode) {
		// 获取登录用户信息
		TbUser user = getCurrentUser();
		if (null != user.getUserId()) {
			if (null != zhId) {
				if(null != roleId) {
					if (null != resourceIds) {
						boolean seccess = tbRoleResourceService.operateRoleResource(user,zhId,roleId,resourceIds,appTypeCode);
						if (seccess) {
							return ResponseMessage.returnInfo(true, null, null, "operate_success");
						} else {
							return ResponseMessage.returnInfo(false, null, null, "operate_fail");
						}
					}else {
						return ResponseMessage.returnInfoSpecial(false, null, null, "资源ID缺失");
					}
				}else {
					return ResponseMessage.returnInfoSpecial(false, null, null, "角色ID缺失");
				}
			}else {
				return ResponseMessage.returnInfoSpecial(false, null, null, "租户ID缺失");
			}
		} else {
			return ResponseMessage.returnInfo(false, null, null, "error");
		}
	}
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbRoleResource
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TbRoleResource tbRoleResource,Page<TbRoleResource> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tbRoleResourceService.findByPage(tbRoleResource, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbRoleResourceList";
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
	@RequestMapping("/tbRoleResource")
	public String tbRoleResource(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TbRoleResource tbRoleResource = tbRoleResourceService.getById(id);
				request.setAttribute("tbRoleResource", tbRoleResource);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/tbRoleResource";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	保存
	 * </pre>
	 * 
	 * @param tbRoleResource
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TbRoleResource tbRoleResource){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tbRoleResource.getId())){
				
				tbRoleResourceService.update(tbRoleResource);
			}
			// 新增
			else{
				
				tbRoleResourceService.add(tbRoleResource);
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
			
			tbRoleResourceService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
