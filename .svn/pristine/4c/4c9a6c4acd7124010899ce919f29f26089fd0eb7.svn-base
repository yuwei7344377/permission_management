package com.dhcc.jn.tenant.service;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbResourceApplicationType;

import java.util.List;
import java.util.Map;

/**
 * 应用系统管理service接口
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
public interface TbResourceApplicationTypeService {

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbResourceApplicationType
     * @param page
     * @return
     */
    public Page<TbResourceApplicationType> findByPage(TbResourceApplicationType tbResourceApplicationType, Page<TbResourceApplicationType> page);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	查询
     * </pre>
     *
     * @param tbResourceApplicationType
     * @return
     */
    public List<TbResourceApplicationType> findBySearch(TbResourceApplicationType tbResourceApplicationType);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	通过ID查询
     * </pre>
     *
     * @param appTypeId
     * @return
     */
    public TbResourceApplicationType getById(String appTypeId);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增
     * </pre>
     *
     * @param tbResourceApplicationType
     */
    public void add(TbResourceApplicationType tbResourceApplicationType);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	修改
     * </pre>
     *
     * @param tbResourceApplicationType
     */
    public void updateNotNull(TbResourceApplicationType tbResourceApplicationType);

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	删除
     * </pre>
     *
     * @param appTypeId
     */
    public void delete(String appTypeId);

    /**
     * 验证应用管理系统下面是否存在功能资源清单
     */
    int findResourcesExist(String appTypeId);

    /**
     * 验证系统编码,名称,简称是否唯一方法
     */
    int findEffective(TbResourceApplicationType tb);

    /**
     * 获取该应用系统列表下关联的功能清单
     *
     * @param appTypeCode
     * @return
     */
    List<Map<String, Object>> getFunctionList(String zhTypeId, String appTypeCode);
}
