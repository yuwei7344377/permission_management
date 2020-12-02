package com.dhcc.jn.tenant.service;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbRole;
import com.dhcc.jn.tenant.entity.TbRoleOrgYy;
import com.dhcc.jn.tenant.entity.TbUser;

import java.util.List;
import java.util.Map;

/**
 * 角色表service接口
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
public interface TbRoleService {

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbRole
     * @param page
     * @return
     */
    public Page<TbRole> findByPage(TbRole tbRole, Page<TbRole> page);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	查询
     * </pre>
     *
     * @param tbRole
     * @return
     */
    public List<TbRole> findBySearch(TbRole tbRole);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	通过ID查询
     * </pre>
     *
     * @param TbRole
     * @return
     */
    public TbRole getById(String roleId);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增
     * </pre>
     *
     * @param tbRole
     */
    public void add(TbRole tbRole);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	修改
     * </pre>
     *
     * @param tbRole
     */
    public void update(TbRole tbRole);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	删除
     * </pre>
     *
     * @param roleId
     */
    public void delete(String roleId);

    /**
     * 查询所有角色
     *
     * @return
     */
    public List<Map<String, Object>> findAll(String zhTypeId,String zhId);

    /**
     * 根据租户ID和角色编码查询
     *
     * @param zhId
     * @param roleCode
     * @return
     */
    public TbRole getByzhIdAndRoleCode(String zhId, String roleCode);

    /**
     * 根据租户ID和角色名称查询
     *
     * @param zhId
     * @param roleName
     * @return
     */
    public TbRole getByzhIdAndRoleName(String zhId, String roleName);

    /**
     * //查询该租户下所有的角色（tb_role）
     *
     * @param zhId
     * @return
     */
    public List<TbRole> getByzhId(String zhId);

    /**
     * 新增租户下的角色
     *
     * @param user
     * @param role
     * @return
     */
    public boolean save(TbUser user, TbRole role,TbRoleOrgYy tbRoleOrgYy);

    /**
     * 修改租户下的角色
     *
     * @param user
     * @param entity
     * @param tbRoleOrgYy 
     * @return
     */
    public boolean edit(TbUser user, TbRole entity, TbRoleOrgYy tbRoleOrgYy);


    /**
     * 获取角色类型
     * @return
     */
	public List<Map<String, Object>> findroleType();

	/**
	 * 获取某行政区划下的运营角色
	 * @param orgCode
	 * @return
	 */
	public List<TbRole> getRoleByOrgCode(String orgCode);
}
