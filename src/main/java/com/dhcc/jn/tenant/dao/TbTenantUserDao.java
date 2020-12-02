package com.dhcc.jn.tenant.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantUser;

/**
 * 
 * 租户dao接口.
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
public interface TbTenantUserDao extends BaseDao<TbTenantUser, String> {

	/**
	 * 根据租户名称查询
	 * @param zhName
	 * @return
	 */
	TbTenantUser getByZhName(@Param("adId")String adId,@Param("zhName")String zhName);

	/**
	 * 根据行政区划ID查询
	 * 模糊查询企业编号、企业名称、企业简称
	 * @param adId
	 * @param zhShortName
	 * @param zhCode
	 * @param zhName
	 * @return
	 */
	List<TbTenantUser> find(String adId,String zhShortName,String zhCode,String zhName);

	/**
	 * 根据行政区划ID查询
	 * @param adId
	 * @return
	 */
	TbTenantUser getByadId(String adId);

	/**
	 * 根据租户ID查询租户，账号信息
	 * @param zhId
	 * @return
	 */
	List<TbTenantUser> getzhIdByTenantAndUser(String zhId);

}