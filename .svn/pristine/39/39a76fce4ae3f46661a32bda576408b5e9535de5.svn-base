package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbTenantTypeRoleDataDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleData;
import com.dhcc.jn.tenant.service.TbTenantTypeRoleDataService;

/**
 * 
 * 用户类型默认角色数据资源关系表service实现类
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
@Service("tbTenantTypeRoleDataService")
public class TbTenantTypeRoleDataServiceImpl implements TbTenantTypeRoleDataService {

	@Autowired
	private TbTenantTypeRoleDataDao tbTenantTypeRoleDataDao;
	
	@Override
	public Page<TbTenantTypeRoleData> findByPage(TbTenantTypeRoleData tbTenantTypeRoleData, Page<TbTenantTypeRoleData> page) {

		page.setResult(tbTenantTypeRoleDataDao.find(tbTenantTypeRoleData, page));
		
		return page;
	}
	
	@Override
	public List<TbTenantTypeRoleData> findBySearch(TbTenantTypeRoleData tbTenantTypeRoleData) {

		return tbTenantTypeRoleDataDao.find(tbTenantTypeRoleData);
	}
	
	@Override
	public TbTenantTypeRoleData getById(String id) {

		return tbTenantTypeRoleDataDao.getById(id);
	}

	@Override
	public void add(TbTenantTypeRoleData tbTenantTypeRoleData) {

		tbTenantTypeRoleData.setId(ResourceUtils.getUUID());
		tbTenantTypeRoleDataDao.add(tbTenantTypeRoleData);
	}
	
	@Override
	public void update(TbTenantTypeRoleData tbTenantTypeRoleData) {

		tbTenantTypeRoleDataDao.update(tbTenantTypeRoleData);
	}

	@Override
	public void delete(String id) {

		tbTenantTypeRoleDataDao.delete(id);
	}
}