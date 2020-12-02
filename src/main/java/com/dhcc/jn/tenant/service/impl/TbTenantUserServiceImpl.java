package com.dhcc.jn.tenant.service.impl;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.Constants;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbOrgDao;
import com.dhcc.jn.tenant.dao.TbTenantTypeRoleDao;
import com.dhcc.jn.tenant.dao.TbTenantUserDao;
import com.dhcc.jn.tenant.dao.TbUserDao;
import com.dhcc.jn.tenant.dao.TbUserOrgDao;
import com.dhcc.jn.tenant.dao.TbUserRoleDao;
import com.dhcc.jn.tenant.entity.TbOrg;
import com.dhcc.jn.tenant.entity.TbTenantTypeRole;
import com.dhcc.jn.tenant.entity.TbTenantUser;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.entity.TbUserOrg;
import com.dhcc.jn.tenant.entity.TbUserRole;
import com.dhcc.jn.tenant.service.TbTenantUserService;
import com.dhcc.jn.tenant.utils.PasswordUtil;
import com.dhcc.jn.tenant.utils.oConvertUtils;

/**
 * 
 * 租户service实现类
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
@Service("tbTenantUserService")
public class TbTenantUserServiceImpl implements TbTenantUserService {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbTenantUserDao tbTenantUserDao;
	@Autowired
	private TbUserDao tbUserDao;
	@Autowired
	private TbUserRoleDao tbUserRoleDao;
	@Autowired
	private TbOrgDao tbOrgDao;
	@Autowired
	private TbUserOrgDao tbUserOrgDao;
	@Autowired
	private TbTenantTypeRoleDao tbTenantTypeRoleDao;
	
	@Override
	public Page<TbTenantUser> findByPage(TbTenantUser tbTenantUser, Page<TbTenantUser> page) {

		page.setResult(tbTenantUserDao.find(tbTenantUser, page));
		
		return page;
	}
	
	@Override
	public List<TbTenantUser> findBySearch(TbTenantUser tbTenantUser) {

		return tbTenantUserDao.find(tbTenantUser);
	}
	
	@Override
	public TbTenantUser getById(String zhId) {

		return tbTenantUserDao.getById(zhId);
	}

	@Override
	public void add(TbTenantUser tbTenantUser) {

		tbTenantUser.setZhId(ResourceUtils.getUUID());
		tbTenantUserDao.add(tbTenantUser);
	}
	
	@Override
	public void update(TbTenantUser tbTenantUser) {

		tbTenantUserDao.update(tbTenantUser);
	}

	@Override
	public void delete(String zhId) {

		tbTenantUserDao.delete(zhId);
	}
 	

	@Override
	public TbTenantUser getByZhName(String adId,String zhName) {
		return tbTenantUserDao.getByZhName(adId,zhName);
	}

	@Override
	public boolean intsert(TbUser user, TbTenantUser entity, String userName,String passWord,String phone ) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		String ordId = UUID.randomUUID().toString().replaceAll("-", "");
		String userId = UUID.randomUUID().toString().replaceAll("-", "");
		if (null != entity) {
			try {
				//租户表tb_tenant_user
				entity.setZhId(id);
				tbTenantUserDao.add(entity);
				
				//组织表tb_org（顶级组织）
				TbOrg org = new TbOrg();
				org.setOrgId(ordId);
				org.setOrgCode(ordId);
				org.setZhId(id);
				org.setOrgName(entity.getZhName());
				org.setOrgType(Constants.ORGTYPE);
				org.setOrgOrder(Constants.ORGORDER);
				org.setCreateId(user.getUserId());
				org.setCreateName(user.getUsername());
				org.setCreateDate(new Date());
				tbOrgDao.add(org);
				
				//账号表tb_user（user_state=1,delete_flag=0）
				TbUser tbUser = new TbUser();
				tbUser.setUserId(userId);
				tbUser.setZhId(id);
				tbUser.setUsername(userName);
				tbUser.setPassword(PasswordUtil.encrypt(userName, oConvertUtils.getString(passWord), PasswordUtil.getStaticSalt()));
				tbUser.setRealname(entity.getZhShortName() + "管理员");
				tbUser.setPhone(phone);
				tbUser.setUserState(Constants.USERSTATE);//状态
				tbUser.setDeleteFlag(Constants.DELETEFLAG);
				tbUser.setDevFlag(Constants.DEVFLAG);
				tbUser.setCreateBy(user.getUserId());
				tbUser.setCreateName(user.getUsername());
				tbUser.setCreateDate(new Date());
				tbUser.setDriver(Constants.DRIVER);
				tbUserDao.add(tbUser);
				
				TbTenantTypeRole tbTenantTypeRole = tbTenantTypeRoleDao.getByzhTypeIdAndRoleCode(entity.getZhTypeId());
				
				//角色表tb_user_role
				TbUserRole userRole = new TbUserRole();
				userRole.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				userRole.setZhId(id);
				userRole.setUserId(userId);
				userRole.setRoleId(tbTenantTypeRole.getId());
				userRole.setRoleSource(Constants.ROLE_SOURCE_1);
				tbUserRoleDao.add(userRole);
				
				//账户组织表tb_user_org
				TbUserOrg userOrg = new TbUserOrg();
				userOrg.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				userOrg.setZhId(id);
				userOrg.setUserId(userId);
				userOrg.setOrgId(ordId);
				tbUserOrgDao.add(userOrg);
			} catch (Exception e) {
				logger.error("新增租户信息失败！" + e.getMessage(), e);
				return false;
			}
			return true;
		} else {
			// 传参为空则返回空值错误信息
			return false;
		}
	}

	@Override
	public List<TbTenantUser> findByadId(String adId,String zhShortName,String zhCode,String zhName) {
		return tbTenantUserDao.find(adId,zhCode,zhName,zhShortName);
	}

	@Override
	public TbTenantUser getByadId(String adId) {
		return tbTenantUserDao.getByadId(adId);
	}

	/**
	 * //根据租户ID获取租户、账号信息
	 */
	@Override
	public List<TbTenantUser> getzhIdByTenantAndUser(String zhId) {
//		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String, Object> map = tbTenantUserDao.getzhIdByTenantAndUser(zhId);
//		list.add(map);
		return tbTenantUserDao.getzhIdByTenantAndUser(zhId);
	}

	@Override
	public boolean edit(TbUser user, TbTenantUser entity, String userName, String passWord, String phone) {
		if (null != user.getUserId()) {
			if (null != entity.getZhId()) {
				TbTenantUser tenantUser = tbTenantUserDao.getById(entity.getZhId());
				if (null != tenantUser) {
					TbTenantUser tbTenantUser = new TbTenantUser();
					tbTenantUser.setZhId(entity.getZhId());
					tbTenantUser.setZhName(entity.getZhName());
					tbTenantUser.setZhShortName(entity.getZhShortName());
					tbTenantUser.setZhTypeId(entity.getZhTypeId());
					tbTenantUserDao.updateNotNull(tbTenantUser);
					
					TbUser tbUser = tbUserDao.getByzhIdAndState(entity.getZhId(),Constants.USERSTATE);
					if (null != tbUser.getUserId()) {
						TbUser userEntity = new TbUser();
						userEntity.setUserId(tbUser.getUserId());
						userEntity.setUsername(userName);
						//userEntity.setPassword(passWord);
						userEntity.setPassword(PasswordUtil.encrypt(userName, oConvertUtils.getString(passWord), PasswordUtil.getStaticSalt()));
						userEntity.setPhone(phone);
						userEntity.setUpdateBy(user.getUserId());
						userEntity.setUpdateDate(new Date());
						userEntity.setUpdateName(user.getUsername());
						tbUserDao.updateNotNull(userEntity);
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}