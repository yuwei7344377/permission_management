package com.dhcc.jn.tenant.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.VDataProductDao;
import com.dhcc.jn.tenant.entity.VDataProduct;
import com.dhcc.jn.tenant.service.VDataProductService;

/**
 * 
 * 数据产品信息service实现类
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
@Service("vDataProductService")
public class VDataProductServiceImpl implements VDataProductService {

	@Autowired
	private VDataProductDao vDataProductDao;
	
	@Override
	@Transactional
	public Page<VDataProduct> findByPage(VDataProduct vDataProduct, Page<VDataProduct> page) {

		page.setResult(vDataProductDao.find(vDataProduct, page));
		
		return page;
	}
	
	@Override
	@Transactional
	public List<VDataProduct> findBySearch(VDataProduct vDataProduct) {

		return vDataProductDao.find(vDataProduct);
	}
	
	@Override
	@Transactional
	public VDataProduct getById(String id) {

		return vDataProductDao.getById(id);
	}

	@Override
	@Transactional
	public void add(VDataProduct vDataProduct) {

		vDataProduct.setId(ResourceUtils.getUUID());
		vDataProductDao.add(vDataProduct);
	}
	
	@Override
	@Transactional
	public void update(VDataProduct vDataProduct) {

		vDataProductDao.update(vDataProduct);
	}

	@Override
	@Transactional
	public void delete(String id) {

		vDataProductDao.delete(id);
	}
	
	public Page<VDataProduct> getDataProductResources(VDataProduct vDataProduct,Page<VDataProduct> page) {
		
		page.setResult(vDataProductDao.getDataProductResources(vDataProduct,page));
		return page;
	}

}