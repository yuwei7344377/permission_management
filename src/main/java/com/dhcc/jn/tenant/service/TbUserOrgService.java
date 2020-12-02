package com.dhcc.jn.tenant.service;
import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbUserOrg;

/**
 * 
 * 账户组织关系service接口
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
public interface TbUserOrgService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbUserOrg
	 * @param page
	 * @return
	 */
	public Page<TbUserOrg> findByPage(TbUserOrg tbUserOrg,Page<TbUserOrg> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbUserOrg
	 * @return
	 */
	public List<TbUserOrg> findBySearch(TbUserOrg tbUserOrg);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbUserOrg
	 * @return
	 */
	public TbUserOrg getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbUserOrg
	 */
	public void add(TbUserOrg tbUserOrg);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbUserOrg
	 */
	public void update(TbUserOrg tbUserOrg);
	
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

	/**
	 * 验证组织下是否有账户信息
	 * @param orgId
	 * @return
	 */
	public List<TbUserOrg> findByOrgId(String orgId);
}
