package com.dhcc.jn.tenant.dao;
import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 租户类型功能清单dao接口.
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
public interface TbTenantTypeResourceDao extends BaseDao<TbTenantTypeResource, String> {

    /**
     * 根据用户类型id和资源code删除功能资源
     * @param zhTypeId
     * @param appTypeCode
     * @return
     */
    void deleteFunctionList(@Param("zhTypeId")String zhTypeId, @Param("appTypeCode")String appTypeCode);

    /**
     *保存用户类型对应功能清单
     * @param tbList
     * @return
     */
    void saveFunctionList(List<TbTenantTypeResource> tbList);
}