package com.dhcc.jn.tenant.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbRoleResource;

/**
 * 
 * 角色资源清单dao接口.
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
public interface TbRoleResourceDao extends BaseDao<TbRoleResource, String> {


	/**
	 * 根据租户ID和角色ID查询
	 * @param zhId
	 * @param roleId
	 * @return
	 */
	List<TbRoleResource> getzhIdAndroleIdByRoleResource(@Param("zhId")String zhId, @Param("roleId")String roleId);

	/**
	 * 根据角色ID删除
	 * @param roleId
	 */
	void deleteByRoleId(@Param("roleId")String roleId,@Param("appTypeCode")String appTypeCode);

	
	/**
	 * 根据该角色id列出所有应用系统+功能资源list
	 * @param roleId
	 * @return
	 */
	List<TbResource> findResource(@Param("zhTypeId")String zhTypeId,@Param("roleId")String roleId,@Param("appTypeCode")String appTypeCode);
	
	 /**
     * 列出菜单树子节点
     * @param map
     * @return
     */
    public List<TbResource> findRoleResourcesParentResourceId(Map map);
	
	/**
	 * 获取功能资源右侧树
	 * @param roleId
	 * @param zhTypeId
	 * @return
	 */
	List<Map<String, Object>> getByzhTypeId(@Param("roleId")String roleId,@Param("zhTypeId")String zhTypeId);


}