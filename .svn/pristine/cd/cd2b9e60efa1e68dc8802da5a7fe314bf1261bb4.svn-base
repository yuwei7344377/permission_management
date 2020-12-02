package com.dhcc.jn.tenant.dao;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantType;

import java.util.Map;

/**
 * 租户类型dao接口.
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
public interface TbTenantTypeDao extends BaseDao<TbTenantType, String> {

    /**
     * 获取当前用户类型下的应用系统名称
     *
     * @param zhTypeCode
     * @return
     */
    Map<String, Object> getUserSystem(String zhTypeCode);
}