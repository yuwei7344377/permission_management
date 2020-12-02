package com.dhcc.jn.tenant.service;

import java.util.List;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbTenantTypeResource;

/**
 * 租户类型功能清单service接口
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
public interface TbTenantTypeResourceService {

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbTenantTypeResource
     * @param page
     * @return
     */
    public Page<TbTenantTypeResource> findByPage(TbTenantTypeResource tbTenantTypeResource, Page<TbTenantTypeResource> page);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	查询
     * </pre>
     *
     * @param tbTenantTypeResource
     * @return
     */
    public List<TbTenantTypeResource> findBySearch(TbTenantTypeResource tbTenantTypeResource);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	通过ID查询
     * </pre>
     *
     * @param id
     * @return
     */
    public TbTenantTypeResource getById(String id);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增
     * </pre>
     *
     * @param tbTenantTypeResource
     */
    public int add(TbTenantTypeResource tbTenantTypeResource, TbResource tbResource);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	修改
     * </pre>
     *
     * @param tbTenantTypeResource
     */
    public void update(TbTenantTypeResource tbTenantTypeResource);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	删除
     * </pre>
     *
     * @param id
     */
    public void delete(String id);


    /**
     * 保存用户类型对应功能清单
     * @param zhTypeId
     * @param appTypeCode
     * @param treeData
     */
    void saveFunctionList(String zhTypeId, String appTypeCode, String treeData);
}
