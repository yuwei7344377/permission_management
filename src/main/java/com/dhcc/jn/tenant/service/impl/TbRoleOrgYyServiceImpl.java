package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbRoleOrgYyDao;
import com.dhcc.jn.tenant.entity.TbRoleOrgYy;
import com.dhcc.jn.tenant.service.TbRoleOrgYyService;

/**
 * 
 * 运营角色组织关系表service实现类
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
@Service("tbRoleOrgYyService")
public class TbRoleOrgYyServiceImpl implements TbRoleOrgYyService {

	@Resource
	private TbRoleOrgYyDao tbRoleOrgYyDao;
	
	@Override
	public Page<TbRoleOrgYy> findByPage(TbRoleOrgYy tbRoleOrgYy, Page<TbRoleOrgYy> page) {

		page.setResult(tbRoleOrgYyDao.find(tbRoleOrgYy, page));
		
		return page;
	}
	
	@Override
	public List<TbRoleOrgYy> findBySearch(TbRoleOrgYy tbRoleOrgYy) {

		return tbRoleOrgYyDao.find(tbRoleOrgYy);
	}
	
	@Override
	public TbRoleOrgYy getById(String id) {

		return tbRoleOrgYyDao.getById(id);
	}

	@Override
	public void add(TbRoleOrgYy tbRoleOrgYy) {

		tbRoleOrgYy.setId(ResourceUtils.getUUID());
		tbRoleOrgYyDao.add(tbRoleOrgYy);
	}
	
	@Override
	public void update(TbRoleOrgYy tbRoleOrgYy) {

		tbRoleOrgYyDao.update(tbRoleOrgYy);
	}

	@Override
	public void delete(String id) {

		tbRoleOrgYyDao.delete(id);
	}
 	
}