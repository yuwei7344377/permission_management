package com.dhcc.jn.tenant.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbRoleDao;
import com.dhcc.jn.tenant.dao.TbRoleOrgYyDao;
import com.dhcc.jn.tenant.entity.TbRole;
import com.dhcc.jn.tenant.entity.TbRoleOrgYy;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbRoleService;

/**
 * 角色表service实现类
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 * SD
 * 	jlf
 * PG
 * 	jlf
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 * <p>
 * <p/> $Id$
 */
@Service("tbRoleService")
public class TbRoleServiceImpl implements TbRoleService {

    @Autowired
    private TbRoleDao tbRoleDao;
    
    @Autowired
    private TbRoleOrgYyDao tbRoleOrgYyDao;
    
    @Override
    @Transactional
    public Page<TbRole> findByPage(TbRole tbRole, Page<TbRole> page) {

        page.setResult(tbRoleDao.find(tbRole, page));

        return page;
    }

    @Override
    @Transactional
    public List<TbRole> findBySearch(TbRole tbRole) {

        return tbRoleDao.find(tbRole);
    }

    @Override
    @Transactional
    public TbRole getById(String roleId) {

        return tbRoleDao.getById(roleId);
    }

    @Override
    @Transactional
    public void add(TbRole tbRole) {

        tbRole.setRoleId(ResourceUtils.getUUID());
        tbRoleDao.add(tbRole);
    }

    @Override
    @Transactional
    public void update(TbRole tbRole) {

        tbRoleDao.update(tbRole);
    }

    @Override
    @Transactional
    public void delete(String roleId) {

        tbRoleDao.delete(roleId);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> findAll(String zhTypeId,String zhId) {

        return tbRoleDao.findZhTypeIdByTenantTypeRoleAndZhIdByRole(zhId,zhTypeId);
    }

    @Override
    @Transactional
    public TbRole getByzhIdAndRoleCode(String zhId, String roleCode) {
        return tbRoleDao.getByzhIdAndRoleCode(zhId, roleCode);
    }

    @Override
    @Transactional
    public TbRole getByzhIdAndRoleName(String zhId, String roleName) {
        return tbRoleDao.getByzhIdAndRoleName(zhId, roleName);
    }

    @Override
    @Transactional
    public List<TbRole> getByzhId(String zhId) {
        return tbRoleDao.getByzhId(zhId);
    }

    @Override
    @Transactional
    public boolean save(TbUser user, TbRole role,TbRoleOrgYy tbRoleOrgYy) {
    	String roleId = UUID.randomUUID().toString().replaceAll("-", "");
        role.setRoleId(roleId);
        tbRoleDao.add(role);
        
        //如果是运营角色，还需要以下信息
        if(null != role && role.getZhId().equals("3")) {
        	tbRoleOrgYy.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbRoleOrgYy.setRoleId(roleId);
            tbRoleOrgYyDao.add(tbRoleOrgYy);
        }
        
        return true;
    }

    @Override
    @Transactional
    public boolean edit(TbUser user, TbRole role, TbRoleOrgYy tbRoleOrgYy) {
        TbRole entity = tbRoleDao.getById(role.getRoleId());
        if (null != entity.getRoleId()) {
            entity.setRoleCode(role.getRoleCode());
            entity.setRoleName(role.getRoleName());
            tbRoleDao.update(entity);
            
            TbRoleOrgYy tbRoleOrgYyEntity = tbRoleOrgYyDao.getRoleId(entity.getRoleId());
            if(tbRoleOrgYyEntity.getId() != null) {
            	tbRoleOrgYyEntity.setRoleType(tbRoleOrgYy.getRoleType());
            	tbRoleOrgYyEntity.setQyCode(tbRoleOrgYy.getQyCode());
            	tbRoleOrgYyEntity.setOrgCode(tbRoleOrgYy.getOrgCode());
            	tbRoleOrgYyEntity.setBfCode(tbRoleOrgYy.getBfCode());
            	tbRoleOrgYyDao.update(tbRoleOrgYyEntity);
            	return true;
            }
            return true;
        }
        return false;
    }

    /**
     * 获取角色类型
     */
	@Override
	public List<Map<String, Object>> findroleType() {
		return tbRoleDao.findroleType();
	}

	@Override
	public List<TbRole> getRoleByOrgCode(String orgCode) {
		String code = orgCode.replaceAll("(0)+$", "");
		return tbRoleDao.getRoleByOrgCode(code);
	}



}