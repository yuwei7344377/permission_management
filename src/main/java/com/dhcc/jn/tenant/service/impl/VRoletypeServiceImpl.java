package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.VRoletypeDao;
import com.dhcc.jn.tenant.entity.VRoletype;
import com.dhcc.jn.tenant.service.VRoletypeService;

/**
 * 
 * 角色类型字典表service实现类
 * 
 * <pre>
 * 	历史记录：
 * 	2020-08-26 jlf
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
@Service("vRoletypeService")
public class VRoletypeServiceImpl implements VRoletypeService {

	@Resource
	private VRoletypeDao vRoletypeDao;
	
	@Override
	public Page<VRoletype> findByPage(VRoletype vRoletype, Page<VRoletype> page) {

		page.setResult(vRoletypeDao.find(vRoletype, page));
		
		return page;
	}
	
	@Override
	public List<VRoletype> findBySearch(VRoletype vRoletype) {

		return vRoletypeDao.find(vRoletype);
	}
	
	@Override
	public VRoletype getById(String id) {

		return vRoletypeDao.getById(id);
	}

	@Override
	public void add(VRoletype vRoletype) {

		vRoletype.setId(ResourceUtils.getUUID());
		vRoletypeDao.add(vRoletype);
	}
	
	@Override
	public void update(VRoletype vRoletype) {

		vRoletypeDao.update(vRoletype);
	}

	@Override
	public void delete(String id) {

		vRoletypeDao.delete(id);
	}
 	
}