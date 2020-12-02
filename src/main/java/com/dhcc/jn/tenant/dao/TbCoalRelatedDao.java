package com.dhcc.jn.tenant.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbCoalRelated;

/**
 * 
 * 企业表dao接口.
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
public interface TbCoalRelatedDao extends BaseDao<TbCoalRelated, String> {

	/**
	 * 查询某行政区划下最大的ID
	 * @param parentCode
	 * @return
	 */
	String getByMaxID(String parentCode);

	/**
	 * 获取企业信息
	 * @param parentId
	 * @return
	 */
	List<TbCoalRelated> getByParentId(String parentId);


	/**
	 * 获取企业信息
	 * @param parentId
	 * @return
	 */
	List<TbCoalRelated> findByOrgCode(String parentId);

	/**
	 * 获取企业下的磅房
	 * @param orgCode
	 * @return
	 */
	List<Map<String, Object>> findrelatedBF(String orgCode);

	/**
	 * 获取企业下的磅道
	 * @param qyCode
	 * @param bfCode 
	 * @return
	 */
	List<Map<String, Object>> findRelatedBD(@Param("qyCode")String qyCode,@Param("bfCode")String bfCode);
	
	/**
	 * 获取企业下的磅房
	 * @param qyCode
	 * @return
	 */
	List<Map<String, Object>> findRelatedBF(String qyCode);
}