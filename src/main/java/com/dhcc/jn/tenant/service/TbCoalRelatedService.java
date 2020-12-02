package com.dhcc.jn.tenant.service;
import java.util.List;
import java.util.Map;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbCoalRelated;

/**
 * 
 * 企业表service接口
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
public interface TbCoalRelatedService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbCoalRelated
	 * @param page
	 * @return
	 */
	public Page<TbCoalRelated> findByPage(TbCoalRelated tbCoalRelated,Page<TbCoalRelated> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbCoalRelated
	 * @return
	 */
	public List<TbCoalRelated> findBySearch(TbCoalRelated tbCoalRelated);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbCoalRelated
	 * @return
	 */
	public TbCoalRelated getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbCoalRelated
	 */
	public void add(TbCoalRelated tbCoalRelated);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbCoalRelated
	 */
	public void update(TbCoalRelated tbCoalRelated);
	
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
	 * 获取企业信息
	 * @param parentId
	 * @return
	 */
	public List<TbCoalRelated> getByParentId(String parentId);

	/**
	 * 获取企业信息
	 * @param parentId
	 * @param roleId 
	 * @return
	 */
	public List<TbCoalRelated> findByOrgCode(String parentId, String roleId);

	/**
	 * 获取企业下的磅房
	 * @param orgCode
	 * @param roleId 
	 * @return
	 */
	public List<Map<String, Object>> findrelatedBF(String orgCode, String roleId);

	/**
	 * 订阅功能接口
	 * @param qyCode
	 * @return
	 */
	public List<Map<String, Object>> subscribe(String qyCode);
}
