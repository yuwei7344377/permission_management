package com.dhcc.jn.tenant.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbUser;

/**
 * 
 * 账户dao接口.
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
public interface TbUserDao extends BaseDao<TbUser, String> {

	/**
	 * 根据租户ID查询
	 * @param zhId
	 * @return
	 */
	List<TbUser> getByzhId(String zhId);

	/**
	 * 根据用户名称查询
	 * @param userName
	 * @return
	 */
	TbUser getByUserName(String userName);

	/**
	 * 根据用户手机号查询
	 * @param phone
	 * @return
	 */
	TbUser getByPhone(String phone);

	/**
	 * 根据组织ID查询用户
	 * @param orgId
	 * @return
	 */
	List<TbUser> getByOrgId(TbUser tbUser, Page<TbUser> page);

	/**
	 * 查询租户下为系统用户的账户
	 * @param zhId
	 * @param userstate
	 * @return
	 */
	TbUser getByzhIdAndState(@Param("zhId")String zhId, @Param("userState")String userState);
	
	List<TbUser> getRoleIdAndOrgByUserId(String userId);
	
	
	/**
	 * 删除角色前，先判断角色下是否分配了账号
	 * @param roleId
	 * @return
	 */
	public String getUserCountByRoleId(String roleId);



}