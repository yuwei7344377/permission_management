package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbUserPoundDao;
import com.dhcc.jn.tenant.entity.TbUserPound;
import com.dhcc.jn.tenant.service.TbUserPoundService;

/**
 * 
 * 账户磅房关系表service实现类
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
@Service("tbUserPoundService")
public class TbUserPoundServiceImpl implements TbUserPoundService {

	@Autowired
	private TbUserPoundDao tbUserPoundDao;
	
	@Override
	public Page<TbUserPound> findByPage(TbUserPound tbUserPound, Page<TbUserPound> page) {

		page.setResult(tbUserPoundDao.find(tbUserPound, page));
		
		return page;
	}
	
	@Override
	public List<TbUserPound> findBySearch(TbUserPound tbUserPound) {

		return tbUserPoundDao.find(tbUserPound);
	}
	
	@Override
	public TbUserPound getById(String id) {

		return tbUserPoundDao.getById(id);
	}

	@Override
	public void add(TbUserPound tbUserPound) {

		tbUserPound.setId(ResourceUtils.getUUID());
		tbUserPoundDao.add(tbUserPound);
	}
	
	@Override
	public void update(TbUserPound tbUserPound) {

		tbUserPoundDao.update(tbUserPound);
	}

	@Override
	public void delete(String id) {

		tbUserPoundDao.delete(id);
	}
 	
}