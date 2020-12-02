package com.dhcc.jn.tenant.service.impl;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.Constants;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbRoleResourceDao;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbRoleResource;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbRoleResourceService;

/**
 * 
 * 角色资源清单service实现类
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
@Service("tbRoleResourceService")
public class TbRoleResourceServiceImpl implements TbRoleResourceService {

	@Autowired
	private TbRoleResourceDao tbRoleResourceDao;
	
	@Override
	public Page<TbRoleResource> findByPage(TbRoleResource tbRoleResource, Page<TbRoleResource> page) {

		page.setResult(tbRoleResourceDao.find(tbRoleResource, page));
		
		return page;
	}
	
	@Override
	public List<TbRoleResource> findBySearch(TbRoleResource tbRoleResource) {

		return tbRoleResourceDao.find(tbRoleResource);
	}
	
	@Override
	public TbRoleResource getById(String id) {

		return tbRoleResourceDao.getById(id);
	}

	@Override
	public void add(TbRoleResource tbRoleResource) {

		tbRoleResource.setId(ResourceUtils.getUUID());
		tbRoleResourceDao.add(tbRoleResource);
	}
	
	@Override
	public void update(TbRoleResource tbRoleResource) {

		tbRoleResourceDao.update(tbRoleResource);
	}

	@Override
	public void delete(String id) {

		tbRoleResourceDao.delete(id);
	}

	@Override
	public List<TbRoleResource> getzhIdAndroleIdByRoleResource(String zhId, String roleId) {
		return tbRoleResourceDao.getzhIdAndroleIdByRoleResource(zhId,roleId);
	}
    
    /**
     * 获取右侧系统
     */
	@Override
	public List<Map<String, Object>> findResourceTree(String roleId, String zhTypeId) {
		return tbRoleResourceDao.getByzhTypeId(roleId,zhTypeId);
	}
	
	/**
	 * 获取左侧功能资源
	 */
    @Override
	public List<TbResource> findResource(String zhTypeId,String roleId,String appTypeCode) {
		return tbRoleResourceDao.findResource(zhTypeId,roleId,appTypeCode);
		
	}
    
    /**
     * 列出菜单树子节点
     * @param map
     * @return
     */
    public List<TbResource> findRoleResourcesParentResourceId(Map map){
    	
    	return tbRoleResourceDao.findRoleResourcesParentResourceId(map);
    }
    
    
    
	/**
	 * 给角色分配功能资源
	 * 先查出原来分配的功能资源，删除后重新分配
	 */
	@Override
	public boolean operateRoleResource(TbUser user, String zhId, String roleId, String resourceIds,String appTypeCode) {
		if (null != user.getUserId()) {
			if (null != roleId) {
				tbRoleResourceDao.deleteByRoleId(roleId,appTypeCode);
				
				if(null != resourceIds && !resourceIds.equals("")) {
					
					String[] resourceId = resourceIds.split(",");
					for(String resource : resourceId) {
						TbRoleResource entity = new TbRoleResource();
						entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
						entity.setZhId(zhId);
						entity.setRoleId(roleId);
						entity.setResourceId(resource);
						entity.setAppTypeCode(appTypeCode);
						entity.setState(Constants.STATE);
						tbRoleResourceDao.add(entity);
					}
				}
				
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
 	
}