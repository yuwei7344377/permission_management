package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbUserRoleDao;
import com.dhcc.jn.tenant.entity.TbUserRole;
import com.dhcc.jn.tenant.service.TbUserRoleService;

/**
 * 
 * 账户角色关系service实现类
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
@Service("tbUserRoleService")
public class TbUserRoleServiceImpl implements TbUserRoleService {

	@Autowired
	private TbUserRoleDao tbUserRoleDao;
	
	@Override
	public Page<TbUserRole> findByPage(TbUserRole tbUserRole, Page<TbUserRole> page) {

		page.setResult(tbUserRoleDao.find(tbUserRole, page));
		
		return page;
	}
	
	@Override
	public List<TbUserRole> findBySearch(TbUserRole tbUserRole) {

		return tbUserRoleDao.find(tbUserRole);
	}
	
	@Override
	public TbUserRole getById(String id) {

		return tbUserRoleDao.getById(id);
	}

	@Override
	public void add(TbUserRole tbUserRole) {

		tbUserRole.setId(ResourceUtils.getUUID());
		tbUserRoleDao.add(tbUserRole);
	}
	
	@Override
	public void update(TbUserRole tbUserRole) {

		tbUserRoleDao.update(tbUserRole);
	}

	@Override
	public void delete(String id) {

		tbUserRoleDao.delete(id);
	}
 	
}