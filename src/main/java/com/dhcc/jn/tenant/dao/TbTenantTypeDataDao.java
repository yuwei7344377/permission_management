package com.dhcc.jn.tenant.dao;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 租户类型数据资源清单dao接口.
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
public interface TbTenantTypeDataDao extends BaseDao<TbTenantTypeData, String> {

    /**
     * 查找数据目录的父节点
     *
     * @return
     */
    List<TbTenantTypeData> findParentId(@Param("zhTypeId")String zhTypeId);

    /**
     * 获取用户类型下的数据目录
     *
     * @param zhTypeId
     * @return
     */
    List<TbTenantTypeData> getUserTypeData(@Param("zhTypeId") String zhTypeId,@Param("dataId") String dataId);
}