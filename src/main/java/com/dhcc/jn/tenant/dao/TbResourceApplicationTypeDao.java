package com.dhcc.jn.tenant.dao;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbResourceApplicationType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 应用系统管理dao接口.
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
public interface TbResourceApplicationTypeDao extends BaseDao<TbResourceApplicationType, String> {


    /**
     * 验证应用管理系统下面是否存在功能资源清单
     */
    int findResourcesByTypeId(@Param("appTypeId") String appTypeId);

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
    List<Map<String, Object>> getFunctionList(@Param("zhTypeId") String zhTypeId, @Param("appTypeCode") String appTypeCode);

}