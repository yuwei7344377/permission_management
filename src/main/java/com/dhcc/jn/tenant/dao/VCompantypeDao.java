package com.dhcc.jn.tenant.dao;
import java.util.List;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.VCompantype;

/**
 * 
 * 企业类型dao接口.
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
public interface VCompantypeDao extends BaseDao<VCompantype, String> {

	/**
	 *  获取企业类型list
	 * @return
	 */
	List<VCompantype> findAll();


}