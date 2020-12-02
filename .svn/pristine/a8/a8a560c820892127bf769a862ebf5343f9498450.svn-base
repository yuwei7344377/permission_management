package com.dhcc.jn.tenant.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbRole;

/**
 * 角色表dao接口.
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 * SD
 * 	jlf
 * PG
 * 	jlf
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 * <p>
 * <p/> $Id$
 */
public interface TbRoleDao extends BaseDao<TbRole, String> {

    /**
     * 查询所有角色
     *
     * @return
     */
    List<TbRole> findAll();

    /**
     * 根据租户ID和角色编码查询
     *
     * @param zhId
     * @param roleCode
     * @return
     */
    TbRole getByzhIdAndRoleCode(@Param("zhId") String zhId, @Param("roleCode") String roleCode);

    /**
     * 根据租户ID和角色名称查询
     *
     * @param zhId
     * @param roleName
     * @return
     */
    TbRole getByzhIdAndRoleName(@Param("zhId") String zhId, @Param("roleName") String roleName);

    /**
     * 根据租户ID查询
     *
     * @param zhId
     * @return
     */
    List<TbRole> getByzhId(String zhId);

    /**
     * 增加时获取角色下拉框
     * @param zhId
     * @param zhTypeId
     * @return
     */
	List<Map<String, Object>> findZhTypeIdByTenantTypeRoleAndZhIdByRole(@Param("zhId")String zhId, @Param("zhTypeId")String zhTypeId);

	/**
	 * 获取角色类型
	 * @return
	 */
	List<Map<String, Object>> findroleType();

	List<TbRole> getRoleByOrgCode(@Param("orgCode")String orgCode);
	
	

}