package com.dhcc.jn.tenant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbTenantTypeResource;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbResourceService;
import com.dhcc.jn.tenant.service.TbTenantTypeResourceService;

/**
 * 功能资源controller
 */
@RestController
@RequestMapping("/tbResource")
public class TbResourceController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbResourceService tbResourceService;

    @Autowired
    private TbTenantTypeResourceService tbTenantTypeResourceService;


    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	列出系统对应的功能清单 ,分页查询
     * </pre>
     *
     * @param tbResource
     * @param
     * @param
     * @return
     */
    @RequestMapping("/list")
    public JSONObject list(TbResource tbResource) {

        try {
            return ResponseMessage.returnInfo(true, tbResourceService.findBySearch(tbResource), null, null);
            
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * 获取父级别菜单list信息
     */
    @RequestMapping("getParentMenu")
    public JSONObject getParentMenu(@RequestParam("appTypeCode") String appTypeCode) {

        try {
            return ResponseMessage.returnInfo(true, tbResourceService.getParentMenu(appTypeCode), null, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }
    
    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增功能资源清单
     * </pre>
     *
     * @param tbResource
     * @return
     */
    @PostMapping("/save")
    public JSONObject save(TbResource tbResource, TbTenantTypeResource tbTenantTypeResource, String zhTypeIds) {

        //获取登陆人信息
        TbUser user = getCurrentUser();

        if (null == tbResource) {
            return ResponseMessage.returnInfo(false, null, null, "save_fail");
        }

        try {

            //添加功能资源表信息
            tbResourceService.add(tbResource, tbTenantTypeResource, user, zhTypeIds);

            return ResponseMessage.returnInfo(true, null, null, "save_success");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }
    
    /**
             * 根据应用资源id获取应用资源信息
     * @param tbResource
     * @return
     */
    @RequestMapping("/getById")
    public JSONObject getById(TbResource tbResource) {

        try {
        	
            return ResponseMessage.returnInfo(true, tbResourceService.getById(tbResource.getResourceId()), null, null);
            
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }
    
    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	修改功能资源清单
     * </pre>
     *
     * @param tbResource
     * @param tbTenantTypeResource
     * @return
     */
    @RequestMapping("/update")
    public JSONObject update(TbResource tbResource, TbTenantTypeResource tbTenantTypeResource) {

        //获取登陆人信息
        TbUser user = getCurrentUser();

        if (null == tbResource && tbTenantTypeResource == null) {
            return ResponseMessage.returnInfo(false, null, null, "save_fail");
        }

        try {
            // 修改
            if (ValidateUtils.isNotEmpty(tbResource.getResourceId())) {

                tbResourceService.updateNotNull(tbResource, tbTenantTypeResource, user);

                return ResponseMessage.returnInfo(true, null, null, "save_success");

            } else {

                return ResponseMessage.returnInfo(false, null, null, "save_fail");

            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	删除功能资源清单
     * </pre>
     *
     * @param tb
     * @return
     */
    @RequestMapping("/delete")
    public JSONObject delete(TbTenantTypeResource tb) {

        try {
            //删除之前验证功能清单下是否存在用户类型
            List<TbTenantTypeResource> number = tbTenantTypeResourceService.findBySearch(tb);

            if (number.size() > 0) {
                return ResponseMessage.returnInfoSpecial(false, null, null, "该应用资源已分配给用户类型，不可以删除！");
            }
            tbResourceService.delete(tb.getResourceId());
            return ResponseMessage.returnInfo(true, null, null, "delete_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }

    /**
     * 启用/停用某一个应用资源
     */
    @RequestMapping("/operateResource")
    public JSONObject operateResource(TbResource tbResource) {

        //获取登陆人信息
        TbUser user = getCurrentUser();

        try {
            tbResourceService.updateNotNull(tbResource, null, user);

            return ResponseMessage.returnInfo(true, null, null, "operate_success");
        } catch (Exception e) {

            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }

    /**
     * 判断功能资源标识唯一性
     */
    @RequestMapping("/findEffectiveResourceLogo")
    public JSONObject findEffectiveResourceLogo(TbResource tbresource) {

        if (StringUtils.isEmpty(tbresource.getResourceFlag())) {
            return ResponseMessage.returnInfoSpecial(false, null, null, "参数不合法");
        }

        try {
            Boolean flag = tbResourceService.findEffectiveResourceLogo(tbresource.getResourceFlag());

            if (!flag) {
                return ResponseMessage.returnInfo(false, null, null, "资源标识already_exists");
            }

            return ResponseMessage.returnInfo(true, null, null, null);
        } catch (Exception e) {
            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }


    /**
     * 获取角色下的应用资源
     *
     * @param roleId
     * @param zhTypeId
     * @param appTypeCode
     * @return
     */
    //@RequestMapping("/getUserRoleResources")
    @RequestMapping(value="/getUserRoleResources",method=RequestMethod.GET)
    public JSONObject getUserRoleResources(@RequestParam("roleId") String roleId, @Param("zhTypeId") String zhTypeId,
                                           @RequestParam("appTypeCode") String appTypeCode) {

        try {
            //查找父节点
            List<TbResource> resourceList = tbResourceService.findRoleResourcesParent(zhTypeId,appTypeCode,roleId);
            List<Map<String, Object>> rolelist = tbResourceService.getUserRoleResources(roleId);//
            
            if (resourceList != null && !resourceList.isEmpty()) {
            	
                for (int i = 0; i < resourceList.size(); i++) {
                
                	TbResource tbResource = resourceList.get(i);
                	
                	//查找子节点，将一授权的设置checked为1
                	List<TbResource> list = getTbResourceInfoByParentId(zhTypeId,tbResource.getResourceId());
                    if (list != null && list.size() > 0) {
                        for (TbResource resource : list){
                        	
                            for (Map<String, Object> map : rolelist) {
                                if (resource.getResourceId().equals(map.get("resource_id"))){
                                    resource.setChecked(1);
                                    break;
                                }else {
                                    resource.setChecked(0);
                                }
                            }
                        }
                        resourceList.get(i).setListTbResources(list);
                    }
                }
                return ResponseMessage.returnInfo(true, resourceList, null, null);
            }

            return ResponseMessage.returnInfo(true, null, null, null);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");

        }
    }

    public List<TbResource> getTbResourceInfoByParentId(String zhTypeId,String parentId) {
    	
        Map map = new HashMap();
        map.put("zhTypeId", zhTypeId);
        map.put("parentId", parentId);
        List<TbResource> resources = tbResourceService.findRoleResourcesParentResourceId(map);

        if (resources != null && resources.size() > 0) {
            for (int i = 0; i < resources.size(); i++) {
                
            	TbResource tbResource1 = resources.get(i);
                List<TbResource> tbResourceInfoByParentId = getTbResourceInfoByParentId(zhTypeId,tbResource1.getResourceId());

                if(null != tbResourceInfoByParentId && tbResourceInfoByParentId.size()>0){	
                
                	tbResource1.setListTbResources(tbResourceInfoByParentId);
                }
            }
            return resources;
        }
        return null;
    }

}
