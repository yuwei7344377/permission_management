package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleData;

/**
 * 
 * 用户类型默认角色数据资源关系表service接口
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
public interface TbTenantTypeRoleDataService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleData
	 * @param page
	 * @return
	 */
	public Page<TbTenantTypeRoleData> findByPage(TbTenantTypeRoleData tbTenantTypeRoleData,Page<TbTenantTypeRoleData> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleData
	 * @return
	 */
	public List<TbTenantTypeRoleData> findBySearch(TbTenantTypeRoleData tbTenantTypeRoleData);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbTenantTypeRoleData
	 * @return
	 */
	public TbTenantTypeRoleData getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleData
	 */
	public void add(TbTenantTypeRoleData tbTenantTypeRoleData);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbTenantTypeRoleData
	 */
	public void update(TbTenantTypeRoleData tbTenantTypeRoleData);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
