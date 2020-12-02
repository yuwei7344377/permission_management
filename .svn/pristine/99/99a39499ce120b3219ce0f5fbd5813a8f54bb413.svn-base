package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbUser;

/**
 * 
 * 账户service接口
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
public interface TbUserService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbUser
	 * @param page
	 * @return
	 */
	public Page<TbUser> findByPage(TbUser tbUser,Page<TbUser> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbUser
	 * @return
	 */
	public List<TbUser> findBySearch(TbUser tbUser);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbUser
	 * @return
	 */
	public TbUser getById(String userId);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbUser
	 */
	public void add(TbUser tbUser);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbUser
	 */
	public void update(TbUser tbUser);
	
	public void updateNotNull(TbUser tbUser);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param userId
	 */
	public void delete(String userId);
	
	/**
	 * 查询租户下的账户
	 * @param zhId
	 * @return
	 */
	public List<TbUser> getByzhId(String zhId);

	/**
	 * 新增账号
	 * @param entity
	 * @return
	 */
	public boolean save(TbUser user,String roleIds,String orgId,TbUser entity);

	/**
	 * 根据userName查询
	 * @param userName
	 * @return
	 */
	public TbUser getByUserName(String userName);

	/**
	 * 根据手机号查询
	 * @param phone
	 * @return
	 */
	public TbUser getByPhone(String phone);

	/**
	 * 修改账户
	 * @param entity
	 * @return
	 */
	public boolean updateUser(TbUser user,TbUser entity);

	/**
	 * 根据组织ID查询用户
	 * @param orgId
	 * @return
	 */
	public Page<TbUser> getByOrgId(TbUser tbUser, Page<TbUser> page);

	/**
	 * 重置密码
	 * @param user
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean updatePwd(TbUser user, String userId, String password);

	/**
	 * 激活用户
	 * @param user
	 * @param userId
	 * @return
	 */
	public boolean operateActivate(TbUser user, String userId);

	/**
	 * 锁定用户
	 * @param user
	 * @param userId
	 * @return
	 */
	public boolean operateLockUser(TbUser user, String userId);

	/**
	 * 删除用户
	 * @param user
	 * @param userId
	 * @return
	 */
	public boolean deleteUser(TbUser user, String userId);
	
	/**
	 * 根据用户ID查询（带角色ID和组织ID）
	 * @param userId
	 * @return
	 */
	public List<TbUser> getRoleIdAndOrgByUserId(String userId);
	
	/**
	 * 删除角色前，先判断角色下是否分配了账号
	 * @param roleId
	 * @return
	 */
	public String getUserCountByRoleId(String roleId);


}
