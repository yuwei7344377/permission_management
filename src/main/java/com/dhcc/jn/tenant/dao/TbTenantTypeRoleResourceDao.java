package com.dhcc.jn.tenant.dao;
import java.util.List;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleResource;

/**
 * 
 * 用户类型角色资源清单表dao接口.
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
public interface TbTenantTypeRoleResourceDao extends BaseDao<TbTenantTypeRoleResource, String> {

	/**
	 * 根据角色ID查询
	 * @param roleId
	 * @return
	 */
	List<TbTenantTypeRoleResource> getByRoleId(String roleId);

}