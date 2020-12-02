package com.dhcc.jn.tenant.dao;
import java.util.List;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.VDataProduct;

/**
 * 
 * 数据产品信息dao接口.
 * 
 * <pre>
 * 	历史记录：
 * 	2020-07-23 jlf
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
public interface VDataProductDao extends BaseDao<VDataProduct, String> {

    /**
     * 获取所有的数据产品资源(标注该用户类型是否选中)
     * @param zhTypeId
     * @param catalogId
     * @return
     */
    List<VDataProduct> getDataProductResources(VDataProduct vDataProduct,Page<VDataProduct> page);
}