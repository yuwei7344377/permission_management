package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbCoalPoundDao;
import com.dhcc.jn.tenant.entity.TbCoalPound;
import com.dhcc.jn.tenant.service.TbCoalPoundService;

/**
 * 
 * 企业进出磅道设置service实现类
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
@Service("tbCoalPoundService")
public class TbCoalPoundServiceImpl implements TbCoalPoundService {

	@Resource
	private TbCoalPoundDao tbCoalPoundDao;
	
	@Override
	public Page<TbCoalPound> findByPage(TbCoalPound tbCoalPound, Page<TbCoalPound> page) {

		page.setResult(tbCoalPoundDao.find(tbCoalPound, page));
		
		return page;
	}
	
	@Override
	public List<TbCoalPound> findBySearch(TbCoalPound tbCoalPound) {

		return tbCoalPoundDao.find(tbCoalPound);
	}
	
	@Override
	public TbCoalPound getById(String id) {

		return tbCoalPoundDao.getById(id);
	}

	@Override
	public void add(TbCoalPound tbCoalPound) {

		tbCoalPound.setId(ResourceUtils.getUUID());
		tbCoalPoundDao.add(tbCoalPound);
	}
	
	@Override
	public void update(TbCoalPound tbCoalPound) {

		tbCoalPoundDao.update(tbCoalPound);
	}

	@Override
	public void delete(String id) {

		tbCoalPoundDao.delete(id);
	}
 	
}