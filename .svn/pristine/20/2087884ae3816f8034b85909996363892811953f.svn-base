package com.dhcc.jn.tenant.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.dhcc.jn.tenant.common.Constants;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbOrgDao;
import com.dhcc.jn.tenant.entity.TbOrg;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbOrgService;

/**
 * 
 * 组织表service实现类
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
@Service("tbOrgService")
public class TbOrgServiceImpl implements TbOrgService {

	@Autowired
	private TbOrgDao tbOrgDao;
	
	@Override
	public Page<TbOrg> findByPage(TbOrg tbOrg, Page<TbOrg> page) {

		page.setResult(tbOrgDao.find(tbOrg, page));
		
		return page;
	}
	
	@Override
	public List<TbOrg> findBySearch(TbOrg tbOrg) {

		return tbOrgDao.find(tbOrg);
	}
	
	@Override
	public TbOrg getById(String orgId) {

		return tbOrgDao.getById(orgId);
	}

	@Override
	public void add(TbOrg tbOrg) {

		tbOrg.setOrgId(ResourceUtils.getUUID());
		tbOrgDao.add(tbOrg);
	}

	@Override
	public void delete(String orgId) {

		tbOrgDao.delete(orgId);
	}

	@Override
	public List<TbOrg> findAll() {
		return tbOrgDao.findAll();
	}

	/**
	 * // 获取租户下的所有的组织（组织名称（模糊查询）、级别（精确查询）；）
	 */
	@Override
	public List<Map<String, Object>> findOrgByzhId(String zhId) {
		return tbOrgDao.findOrgByzhId(zhId);
	}

	/**
	 * 组织名唯一校验
	 */
	@Override
	public TbOrg getByOrgName(String orgName,String zhId) {
		return tbOrgDao.getByOrgName(orgName,zhId);
	}

	/**
	 * 新增组织
	 */
	@Override
	public boolean save(TbUser user,TbOrg entity) {
		String id = "";
		//判断租户ID是否为3
		if(Constants.TENANT_USER_ZHID_3.equals(entity.getZhId())) {
			//取县市级下面ID最大的数据
			String org = tbOrgDao.getMaxOrgId(entity.getParentOrgId());
			if (!StringUtils.isEmpty(org)) {
				id = String.valueOf(Integer.valueOf(org)+1);
				entity.setOrgId(id);
				entity.setOrgCode(id);
			}else {
				id = String.valueOf(Integer.valueOf(entity.getParentOrgId())+1);
				entity.setOrgId(id);
				entity.setOrgCode(id);
			}
		}else {
			id = UUID.randomUUID().toString().replaceAll("-", "");
			entity.setOrgId(id);
			entity.setOrgCode(id);
		}
		entity.setParentOrgId(entity.getParentOrgId());
		entity.setOrgType(Constants.ORGTYPE_2);
		entity.setCreateId(user.getUserId());
		entity.setCreateName(user.getUsername());
		entity.setCreateDate(new Date());
		tbOrgDao.add(entity);
		return true;
	}

	/**
	 * // 编辑组织
	 */
	@Override
	public boolean update(TbUser user, TbOrg entity) {
		entity.setUpdateId(user.getUserId());
		entity.setUpdateName(user.getUsername());
		entity.setUpdateDate(new Date());
		tbOrgDao.updateNotNull(entity);
		return true;
	}

	
	/**
	 * 更新
	 * @param tbOrg
	 */
	public void updateNotNull(TbOrg tbOrg) {
		
		tbOrgDao.updateNotNull(tbOrg);
	}
	
	/**
	 * //（组织名称（模糊查询）、级别（精确查询）；）
	 */
	@Override
	public List<TbOrg> getByOrgNameAndOrgType(String zhId,String orgName, String orgType) {
		return tbOrgDao.getByOrgNameAndOrgType(zhId,orgName,orgType);
	}

	@Override
	public List<TbOrg> getTbOrgTree() {
		return tbOrgDao.getTbOrgTree();
	}

	@Override
	public List<TbOrg> findBySearch(String parentOrgId) {
		return tbOrgDao.findBySearch(parentOrgId);
	}

	@Override
	public List<Map<String, Object>> findByzhId(String zhId) {
		return tbOrgDao.findByzhId(zhId);
	}

	/**
	 * 获取租户下组织树
	 */
	@Override
	public List<TbOrg> getTbOrgTreeByzhId(String zhId) {
		return tbOrgDao.getTbOrgTreeByzhId(zhId);
	}
 	
}