package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbCoalPound;

/**
 * 
 * 企业进出磅道设置service接口
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
public interface TbCoalPoundService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbCoalPound
	 * @param page
	 * @return
	 */
	public Page<TbCoalPound> findByPage(TbCoalPound tbCoalPound,Page<TbCoalPound> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbCoalPound
	 * @return
	 */
	public List<TbCoalPound> findBySearch(TbCoalPound tbCoalPound);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbCoalPound
	 * @return
	 */
	public TbCoalPound getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbCoalPound
	 */
	public void add(TbCoalPound tbCoalPound);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbCoalPound
	 */
	public void update(TbCoalPound tbCoalPound);
	
	/**
	 * 
	 * <pre>
	 * 	2020-08-27 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
