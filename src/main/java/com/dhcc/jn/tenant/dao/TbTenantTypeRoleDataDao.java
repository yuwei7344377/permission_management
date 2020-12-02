package com.dhcc.jn.tenant.dao;
import java.util.List;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleData;

/**
 * 
 * 用户类型默认角色数据资源关系表dao接口.
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
public interface TbTenantTypeRoleDataDao extends BaseDao<TbTenantTypeRoleData, String> {

	/**
	 * 根据角色ID查询
	 * @param roleId
	 * @return
	 */
	List<TbTenantTypeRoleData> getByRoleId(String roleId);


}