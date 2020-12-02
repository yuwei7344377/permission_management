package com.dhcc.jn.tenant.service;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbTenantType;

import java.util.List;

/**
 * 租户类型service接口
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
public interface TbTenantTypeService {

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbTenantType
     * @param page
     * @return
     */
    public Page<TbTenantType> findByPage(TbTenantType tbTenantType, Page<TbTenantType> page);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	查询
     * </pre>
     *
     * @param tbTenantType
     * @return
     */
    public List<TbTenantType> findBySearch(TbTenantType tbTenantType);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	通过ID查询
     * </pre>
     *
     * @param zhTypeId
     * @return
     */
    public TbTenantType getById(String zhTypeId);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增
     * </pre>
     *
     * @param tbTenantType
     */
    public void add(TbTenantType tbTenantType);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	修改
     * </pre>
     *
     * @param tbTenantType
     */
    public void update(TbTenantType tbTenantType);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	删除
     * </pre>
     *
     * @param zhTypeId
     */
    public void delete(String zhTypeId);

}
