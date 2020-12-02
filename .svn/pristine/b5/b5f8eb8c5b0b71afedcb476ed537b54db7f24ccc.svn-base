package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbAdministrativeDivisionDao;
import com.dhcc.jn.tenant.entity.TbAdministrativeDivision;
import com.dhcc.jn.tenant.service.TbAdministrativeDivisionService;

/**
 * 
 * 行政区划service实现类
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
@Service("tbAdministrativeDivisionService")
public class TbAdministrativeDivisionServiceImpl implements TbAdministrativeDivisionService {

	@Autowired
	private TbAdministrativeDivisionDao tbAdministrativeDivisionDao;
	
	@Override
	public Page<TbAdministrativeDivision> findByPage(TbAdministrativeDivision tbAdministrativeDivision, Page<TbAdministrativeDivision> page) {

		page.setResult(tbAdministrativeDivisionDao.find(tbAdministrativeDivision, page));
		
		return page;
	}
	
	@Override
	public List<TbAdministrativeDivision> findBySearch(TbAdministrativeDivision tbAdministrativeDivision) {

		return tbAdministrativeDivisionDao.find(tbAdministrativeDivision);
	}
	
	@Override
	public TbAdministrativeDivision getById(String adId) {

		return tbAdministrativeDivisionDao.getById(adId);
	}

	@Override
	public void add(TbAdministrativeDivision tbAdministrativeDivision) {

		tbAdministrativeDivision.setAdId(ResourceUtils.getUUID());
		tbAdministrativeDivisionDao.add(tbAdministrativeDivision);
	}
	
	@Override
	public void update(TbAdministrativeDivision tbAdministrativeDivision) {

		tbAdministrativeDivisionDao.update(tbAdministrativeDivision);
	}

	@Override
	public void delete(String adId) {

		tbAdministrativeDivisionDao.delete(adId);
	}
 	

	@Override
	public List<TbAdministrativeDivision> findByParentId() {
		return tbAdministrativeDivisionDao.findByParentId();
	}
}