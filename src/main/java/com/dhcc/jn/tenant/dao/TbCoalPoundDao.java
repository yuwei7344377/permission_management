package com.dhcc.jn.tenant.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhcc.jn.tenant.common.base.BaseDao;
import com.dhcc.jn.tenant.entity.TbCoalPound;

/**
 * 
 * 企业进出磅道设置dao接口.
 * 
 * <pre>
 * 	历史记录：
 * 	2020-08-27 jlf
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
public interface TbCoalPoundDao extends BaseDao<TbCoalPound, String> {
	
	/**
	 * 查询绑定的磅房
	 * @param qyCode
	 * @param bfCode
	 * @return
	 */
	List<TbCoalPound> findByqiIdAndbfCode(@Param("qyCode")String qyCode, @Param("bfCode")String bfCode);


}