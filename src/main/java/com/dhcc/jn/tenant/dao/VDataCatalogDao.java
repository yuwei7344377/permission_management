package com.dhcc.jn.tenant.dao;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeData;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleData;
import com.dhcc.jn.tenant.entity.VDataCatalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 数据目录dao接口.
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-23 jlf
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
public interface VDataCatalogDao extends BaseDao<VDataCatalog, String> {

    //删除用户的上级目录
    void delParentList(@Param("zhTypeId") String zhTypeId, @Param("parentIds") String parentIds);

    //删除用户的数据清单
    void delParentOrData(@Param("zhTypeId") String zhTypeId, @Param("parentIds") String parentIds);

    //添加用户数据清单
    void insertUserData(List<TbTenantTypeData> tbList);

    //获取角色中的数据产品资源是否选中
    List<Map<String, Object>> getRoleDataProductResources(@Param("roleId") String roleId, @Param("zhTypeId") String zhTypeId, @Param("dataId") String dataId);

    //删除角色数据产品资源父级目录
    void delProductParentList(@Param("roleId") String roleId, @Param("parentIds") String parentIds);

    //删除角色数据产品资源
    void delDataOrProduct(@Param("roleId") String roleId, @Param("parentIds") String parentIds);

    //添加角色数据产品资源
    void inserProductData(List<TbTenantTypeRoleData> tbList);

    /**
     * 获取pid为空的
     *
     * @param zhTypeId
     * @param dataFrom
     * @return
     */
    List<VDataCatalog> getRoleDataTree(@Param("zhTypeId") String zhTypeId);

    /**
     * 获取pid下所有子节点
     *
     * @param zhTypeId
     * @param dataFrom
     * @param pid
     * @return
     */
    List<VDataCatalog> findBySearch(@Param("zhTypeId")  String zhTypeId,@Param("pid") String pid);

    //查找数据展示列父节点
    List<VDataCatalog> findParentId();
}