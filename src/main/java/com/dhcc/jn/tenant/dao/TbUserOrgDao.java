package com.dhcc.jn.tenant.dao;
import java.util.List;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbUserOrg;

/**
 * 
 * 账户组织关系dao接口.
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
public interface TbUserOrgDao extends BaseDao<TbUserOrg, String> {

	/**
	 * 验证组织下是否有账户信息
	 * @param orgId
	 * @return
	 */
	List<TbUserOrg> findByOrgId(String orgId);

}