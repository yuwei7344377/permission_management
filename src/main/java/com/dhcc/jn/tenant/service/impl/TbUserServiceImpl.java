package com.dhcc.jn.tenant.service.impl;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.Constants;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbUserDao;
import com.dhcc.jn.tenant.dao.TbUserOrgDao;
import com.dhcc.jn.tenant.dao.TbUserRoleDao;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.entity.TbUserOrg;
import com.dhcc.jn.tenant.entity.TbUserRole;
import com.dhcc.jn.tenant.service.TbUserService;
import com.dhcc.jn.tenant.utils.PasswordUtil;
import com.dhcc.jn.tenant.utils.oConvertUtils;

/**
 * 
 * 账户service实现类
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
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {

	@Autowired
	private TbUserDao tbUserDao;
	@Autowired
	private TbUserRoleDao tbUserRoleDao;
	@Autowired
	private TbUserOrgDao tbUserOrgDao;
	
	@Override
	public Page<TbUser> findByPage(TbUser tbUser, Page<TbUser> page) {
		
		page.setResult(tbUserDao.find(tbUser, page));
		
		return page;
	}
	

	/**
	 * 根据组织ID查询用户
	 */
	@Override
	public Page<TbUser> getByOrgId(TbUser tbUser, Page<TbUser> page) {
		tbUser.setOrgId(tbUser.getOrgId().replaceAll("(0)+$", ""));
		page.setResult(tbUserDao.getByOrgId(tbUser,page));
		return page;
	}
	
	@Override
	public List<TbUser> findBySearch(TbUser tbUser) {

		return tbUserDao.find(tbUser);
	}
	
	@Override
	public TbUser getById(String userId) {

		return tbUserDao.getById(userId);
	}

	@Override
	public void add(TbUser tbUser) {

		tbUser.setUserId(ResourceUtils.getUUID());
		tbUserDao.add(tbUser);
	}
	
	@Override
	public void update(TbUser tbUser) {

		tbUserDao.update(tbUser);
	}

	public void updateNotNull(TbUser tbUser) {
		
		tbUserDao.updateNotNull(tbUser);
	}
	
	@Override
	public void delete(String userId) {

		tbUserDao.delete(userId);
	}
	
	@Override
	public List<TbUser> getByzhId(String zhId) {
		return tbUserDao.getByzhId(zhId);
	}

	@Override
	public boolean save(TbUser user,String roleIds,String orgId,TbUser entity) {
		if (null != user.getUserId() && null != roleIds && !roleIds.equals("")) {
			//账号表tb_user（user_state=2,delete_flag=0）
			String userId = UUID.randomUUID().toString().replaceAll("-", "");
			entity.setUserId(userId);
			entity.setPassword(PasswordUtil.encrypt(entity.getUsername(), oConvertUtils.getString(entity.getPassword()), PasswordUtil.getStaticSalt()));
			entity.setDeleteFlag(Constants.DELETEFLAG);
			entity.setCreateBy(user.getUserId());
			entity.setCreateName(user.getUsername());
			entity.setCreateDate(new Date());
			entity.setDriver(Constants.DRIVER);
			entity.setDevFlag(Constants.DEVFLAG);
			entity.setUserState(Constants.userSTATE);
			tbUserDao.add(entity);
			
			if(null != roleIds && !roleIds.equals("")) {
				
				String[] roleIdInfos = roleIds.split(",");
				for(String rIdStr : roleIdInfos) {
					String[] roleIdStr = rIdStr.split("@");
					//账户角色表tb_user_role
					TbUserRole tbUserRole = new TbUserRole();
					tbUserRole.setId(UUID.randomUUID().toString().replaceAll("-", ""));
					tbUserRole.setZhId(entity.getZhId());
					tbUserRole.setUserId(userId);
					tbUserRole.setRoleId(roleIdStr[0]);//获取不到
					tbUserRole.setRoleSource(roleIdStr[1]);
					tbUserRoleDao.add(tbUserRole);
				}
			}
			
			//账户组织表tb_user_org
			TbUserOrg userOrg = new TbUserOrg();
			userOrg.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			userOrg.setZhId(entity.getZhId());
			userOrg.setUserId(userId);
			userOrg.setOrgId(orgId);//获取不到
			tbUserOrgDao.add(userOrg);
			return true;
		}
		return false;
	}

	@Override
	public TbUser getByUserName(String userName) {
		return tbUserDao.getByUserName(userName);
	}

	@Override
	public TbUser getByPhone(String phone) {
		return tbUserDao.getByPhone(phone);
	}

	@Override
	public boolean updateUser(TbUser user,TbUser entity) {
		if (null != user.getUserId()) {
			if (null != entity.getUserId()) {
				TbUser tbUser = tbUserDao.getById(entity.getUserId());
				tbUser.setDevFlag(tbUser.getDevFlag());
				tbUser.setUpdateBy(user.getUserId());
				tbUser.setUpdateName(user.getUsername());
				tbUser.setUpdateDate(new Date());
				tbUserDao.updateNotNull(tbUser);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updatePwd(TbUser user, String userId, String password) {
		TbUser entity = tbUserDao.getById(userId);
		if (null != entity.getUserId()) {
			TbUser tbUser = new TbUser();
			tbUser.setUserId(userId);
			//tbUser.setPassword(password);
			tbUser.setPassword(PasswordUtil.encrypt(entity.getUsername(), oConvertUtils.getString(password), PasswordUtil.getStaticSalt()));
			tbUser.setUpdateBy(user.getUserId());
			tbUser.setUpdateName(user.getUsername());
			tbUser.setUpdateDate(new Date());
			tbUserDao.updateNotNull(tbUser);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean operateActivate(TbUser user, String userId){
		
		TbUser entity = tbUserDao.getById(userId);
		if (null != entity.getUserId()) {
			TbUser tbUser = new TbUser();
			tbUser.setUserId(entity.getUserId());
			tbUser.setDeleteFlag("0");
			tbUser.setLockType("  ");
			tbUser.setLockTime(null);
			tbUser.setUpdateBy(user.getUserId());
			tbUser.setUpdateName(user.getUsername());
			tbUser.setUpdateDate(new Date());
			tbUserDao.updateNotNull(tbUser);
			return true;
			
		}else {
			
			return false;
		}
	}

	@Override
	public boolean operateLockUser(TbUser user, String userId) {
		TbUser entity = tbUserDao.getById(userId);
		if (null != entity.getUserId()) {
			
			TbUser tbUser = new TbUser();
			tbUser.setUserId(entity.getUserId());
			tbUser.setDeleteFlag("2");
			tbUser.setLockType("0");
			tbUser.setLockTime(new Date());
			tbUser.setUpdateBy(user.getUserId());
			tbUser.setUpdateName(user.getUsername());
			tbUser.setUpdateDate(new Date());
			tbUserDao.updateNotNull(tbUser);
			return true;
		
		}else {
			
			return false;
		}
	}

	@Override
	public boolean deleteUser(TbUser user, String userId) {
		TbUser entity = tbUserDao.getById(userId);
		
		if (null != entity.getUserId()) {
			TbUser tbUser = new TbUser();
			tbUser.setUserId(entity.getUserId());
			tbUser.setDeleteFlag("1");
			tbUser.setUpdateBy(user.getUserId());
			tbUser.setUpdateName(user.getUsername());
			tbUser.setUpdateDate(new Date());
			tbUserDao.updateNotNull(tbUser);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<TbUser> getRoleIdAndOrgByUserId(String userId) {
		return tbUserDao.getRoleIdAndOrgByUserId(userId);
	}
	
	/**
	 * 删除角色前，先判断角色下是否分配了账号
	 * @param roleId
	 * @return
	 */
	public String getUserCountByRoleId(String roleId) {
		
		return tbUserDao.getUserCountByRoleId(roleId);
	}

}