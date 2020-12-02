package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.VCompantypeDao;
import com.dhcc.jn.tenant.entity.VCompantype;
import com.dhcc.jn.tenant.service.VCompantypeService;

/**
 * 
 * 企业类型service实现类
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
@Service("vCompantypeService")
public class VCompantypeServiceImpl implements VCompantypeService {

	@Autowired
	private VCompantypeDao vCompantypeDao;
	
	@Override
	public Page<VCompantype> findByPage(VCompantype vCompantype, Page<VCompantype> page) {

		page.setResult(vCompantypeDao.find(vCompantype, page));
		
		return page;
	}
	
	@Override
	public List<VCompantype> findBySearch(VCompantype vCompantype) {

		return vCompantypeDao.find(vCompantype);
	}
	
	@Override
	public VCompantype getById(String id) {

		return vCompantypeDao.getById(id);
	}

	@Override
	public void add(VCompantype vCompantype) {

		vCompantype.setId(ResourceUtils.getUUID());
		vCompantypeDao.add(vCompantype);
	}
	
	@Override
	public void update(VCompantype vCompantype) {

		vCompantypeDao.update(vCompantype);
	}

	@Override
	public void delete(String id) {

		vCompantypeDao.delete(id);
	}

	/**
	 *  获取企业类型list
	 */
	@Override
	public List<VCompantype> findAll() {
		return vCompantypeDao.findAll();
	}
 	
}