package com.dhcc.jn.tenant.service;
import java.util.List;
import java.util.Map;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.VDataProduct;
import com.dhcc.jn.tenant.entity.VRoletype;

/**
 * 
 * 数据产品信息service接口
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
public interface VDataProductService{
	
 	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	分页查询
	 * </pre>
	 * 
	 * @param vDataProduct
	 * @param page
	 * @return
	 */
	public Page<VDataProduct> findByPage(VDataProduct vDataProduct,Page<VDataProduct> page);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	查询
	 * </pre>
	 * 
	 * @param vDataProduct
	 * @return
	 */
	public List<VDataProduct> findBySearch(VDataProduct vDataProduct);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param VDataProduct
	 * @return
	 */
	public VDataProduct getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	新增
	 * </pre>
	 * 
	 * @param vDataProduct
	 */
	public void add(VDataProduct vDataProduct);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	修改
	 * </pre>
	 * 
	 * @param vDataProduct
	 */
	public void update(VDataProduct vDataProduct);
	
	/**
	 * 
	 * <pre>
	 * 	2020-07-23 jlf
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 获取所有的数据产品资源(标注该用户类型是否选中)
	 * @param zhTypeId
	 * @param parentId
	 * @param catalogId
	 * @return
	 */
	Page<VDataProduct> getDataProductResources(VDataProduct vDataProduct,Page<VDataProduct> page);
}
