package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbUserOrgDao;
import com.dhcc.jn.tenant.entity.TbUserOrg;
import com.dhcc.jn.tenant.service.TbUserOrgService;

/**
 * 
 * 账户组织关系service实现类
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
@Service("tbUserOrgService")
public class TbUserOrgServiceImpl implements TbUserOrgService {

	@Autowired
	private TbUserOrgDao tbUserOrgDao;
	
	@Override
	public Page<TbUserOrg> findByPage(TbUserOrg tbUserOrg, Page<TbUserOrg> page) {

		page.setResult(tbUserOrgDao.find(tbUserOrg, page));
		
		return page;
	}
	
	@Override
	public List<TbUserOrg> findBySearch(TbUserOrg tbUserOrg) {

		return tbUserOrgDao.find(tbUserOrg);
	}
	
	@Override
	public TbUserOrg getById(String id) {

		return tbUserOrgDao.getById(id);
	}

	@Override
	public void add(TbUserOrg tbUserOrg) {

		tbUserOrg.setId(ResourceUtils.getUUID());
		tbUserOrgDao.add(tbUserOrg);
	}
	
	@Override
	public void update(TbUserOrg tbUserOrg) {

		tbUserOrgDao.update(tbUserOrg);
	}

	@Override
	public void delete(String id) {

		tbUserOrgDao.delete(id);
	}

	/**
	 * 验证组织下是否有账户信息
	 */
	@Override
	public List<TbUserOrg> findByOrgId(String orgId) {
		return tbUserOrgDao.findByOrgId(orgId);
	}
 	
}