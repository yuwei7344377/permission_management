package com.dhcc.jn.tenant.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbRoleOrgYy;

/**
 * 
 * 运营角色组织关系表dao接口.
 * 
 * <pre>
 * 	历史记录：
 * 	2020-08-27 jlf
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
public interface TbRoleOrgYyDao extends BaseDao<TbRoleOrgYy, String> {
	
	/**
	 * 查企业
	 * @param roleId
	 * @return
	 */
	List<TbRoleOrgYy> findByRoleId(String roleId);

	/**
	 * 查磅房
	 * @param orgCode
	 * @param roleId
	 * @return
	 */
	List<TbRoleOrgYy> findRoleIdAndqyCode(@Param("orgCode")String orgCode, @Param("roleId")String roleId);

	/**
	 * 查磅房
	 * @param orgCode
	 * @param roleId
	 * @return
	 */
	List<Map<String, Object>> findDepartequipmeninfoAndroleorgyy(@Param("orgCode")String orgCode, @Param("roleId")String roleId);

	TbRoleOrgYy getRoleId(String roleId);


}