package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.VCompantype;

/**
 * 
 * 企业类型service接口
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
public interface VCompantypeService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vCompantype
	 * @param page
	 * @return
	 */
	public Page<VCompantype> findByPage(VCompantype vCompantype,Page<VCompantype> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param vCompantype
	 * @return
	 */
	public List<VCompantype> findBySearch(VCompantype vCompantype);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param VCompantype
	 * @return
	 */
	public VCompantype getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param vCompantype
	 */
	public void add(VCompantype vCompantype);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param vCompantype
	 */
	public void update(VCompantype vCompantype);
	
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

	/**
	 *  获取企业类型list
	 * @return
	 */
	public List<VCompantype> findAll();
}
