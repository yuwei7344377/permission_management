package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbUserRole;

/**
 * 
 * 账户角色关系service接口
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
public interface TbUserRoleService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbUserRole
	 * @param page
	 * @return
	 */
	public Page<TbUserRole> findByPage(TbUserRole tbUserRole,Page<TbUserRole> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbUserRole
	 * @return
	 */
	public List<TbUserRole> findBySearch(TbUserRole tbUserRole);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbUserRole
	 * @return
	 */
	public TbUserRole getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbUserRole
	 */
	public void add(TbUserRole tbUserRole);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbUserRole
	 */
	public void update(TbUserRole tbUserRole);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
