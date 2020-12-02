package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbTenantTypeRoleResourceDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleResource;
import com.dhcc.jn.tenant.service.TbTenantTypeRoleResourceService;

/**
 * 
 * 用户类型角色资源清单表service实现类
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
@Service("tbTenantTypeRoleResourceService")
public class TbTenantTypeRoleResourceServiceImpl implements TbTenantTypeRoleResourceService {

	@Autowired
	private TbTenantTypeRoleResourceDao tbTenantTypeRoleResourceDao;
	
	@Override
	public Page<TbTenantTypeRoleResource> findByPage(TbTenantTypeRoleResource tbTenantTypeRoleResource, Page<TbTenantTypeRoleResource> page) {

		page.setResult(tbTenantTypeRoleResourceDao.find(tbTenantTypeRoleResource, page));
		
		return page;
	}
	
	@Override
	public List<TbTenantTypeRoleResource> findBySearch(TbTenantTypeRoleResource tbTenantTypeRoleResource) {

		return tbTenantTypeRoleResourceDao.find(tbTenantTypeRoleResource);
	}
	
	@Override
	public TbTenantTypeRoleResource getById(String id) {

		return tbTenantTypeRoleResourceDao.getById(id);
	}

	@Override
	public void add(TbTenantTypeRoleResource tbTenantTypeRoleResource) {

		tbTenantTypeRoleResource.setId(ResourceUtils.getUUID());
		tbTenantTypeRoleResourceDao.add(tbTenantTypeRoleResource);
	}
	
	@Override
	public void update(TbTenantTypeRoleResource tbTenantTypeRoleResource) {

		tbTenantTypeRoleResourceDao.update(tbTenantTypeRoleResource);
	}

	@Override
	public void delete(String id) {

		tbTenantTypeRoleResourceDao.delete(id);
	}

 	
}