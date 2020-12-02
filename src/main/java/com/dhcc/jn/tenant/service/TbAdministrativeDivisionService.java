package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbAdministrativeDivision;

/**
 * 
 * 行政区划service接口
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
public interface TbAdministrativeDivisionService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbAdministrativeDivision
	 * @param page
	 * @return
	 */
	public Page<TbAdministrativeDivision> findByPage(TbAdministrativeDivision tbAdministrativeDivision,Page<TbAdministrativeDivision> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbAdministrativeDivision
	 * @return
	 */
	public List<TbAdministrativeDivision> findBySearch(TbAdministrativeDivision tbAdministrativeDivision);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbAdministrativeDivision
	 * @return
	 */
	public TbAdministrativeDivision getById(String adId);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbAdministrativeDivision
	 */
	public void add(TbAdministrativeDivision tbAdministrativeDivision);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbAdministrativeDivision
	 */
	public void update(TbAdministrativeDivision tbAdministrativeDivision);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param adId
	 */
	public void delete(String adId);
	
	/**
	 * 查询山西省
	 * @return
	 */
	public List<TbAdministrativeDivision> findByParentId();
}
