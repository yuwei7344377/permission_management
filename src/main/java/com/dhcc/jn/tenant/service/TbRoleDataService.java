package com.dhcc.jn.tenant.service;
import java.util.List;
import java.util.Map;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbRoleData;
import com.dhcc.jn.tenant.entity.TbUser;

/**
 * 
 * 角色数据资源清单表service接口
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
public interface TbRoleDataService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tbRoleData
	 * @param page
	 * @return
	 */
	public Page<TbRoleData> findByPage(TbRoleData tbRoleData,Page<TbRoleData> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param tbRoleData
	 * @return
	 */
	public List<TbRoleData> findBySearch(TbRoleData tbRoleData);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TbRoleData
	 * @return
	 */
	public TbRoleData getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param tbRoleData
	 */
	public void add(TbRoleData tbRoleData);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-22 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param tbRoleData
	 */
	public void update(TbRoleData tbRoleData);
	
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
	 * 验证角色是否分配数据资源
	 * @param zhId
	 * @param roleId
	 * @return
	 */
	public List<TbRoleData> getzhIdAndroleIdByRoleData(String zhId, String roleId);
	

	/**
	 * 根据该角色id列出所有数据目录+产品资源list
	 * @param zhTypeId
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> findData(String zhTypeId, String roleId,String catalogId);

	/**
	 * 获取数据资源树
	 * @param zhTypeId
	 * @return
	 */
	public List<Map<String, Object>> findDataTree(String roleId,String zhTypeId);

	/**
	 * 给角色分配数据资源
	 * 先删除原有资源
	 * @param user
	 * @param entity
	 * @return
	 */
	public boolean operateRoleData(TbUser user, String zhId,String roleId,String dataIds,String parentId);
}
