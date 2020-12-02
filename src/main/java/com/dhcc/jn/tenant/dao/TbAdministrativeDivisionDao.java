package com.dhcc.jn.tenant.dao;
import java.util.List;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbAdministrativeDivision;

/**
 * 
 * 行政区划dao接口.
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
public interface TbAdministrativeDivisionDao extends BaseDao<TbAdministrativeDivision, String> {
	/**
	 * 查询山西下的所有行政区划
	 * @return
	 */
	List<TbAdministrativeDivision> findByParentId();
}