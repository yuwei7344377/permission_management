package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.VRoletype;

/**
 * 
 * 角色类型字典表service接口
 * 
 * <pre>
 * 	历史记录：
 * 	2020-08-26 jlf
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
public interface VRoletypeService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vRoletype
	 * @param page
	 * @return
	 */
	public Page<VRoletype> findByPage(VRoletype vRoletype,Page<VRoletype> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param vRoletype
	 * @return
	 */
	public List<VRoletype> findBySearch(VRoletype vRoletype);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param VRoletype
	 * @return
	 */
	public VRoletype getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param vRoletype
	 */
	public void add(VRoletype vRoletype);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param vRoletype
	 */
	public void update(VRoletype vRoletype);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-26 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
