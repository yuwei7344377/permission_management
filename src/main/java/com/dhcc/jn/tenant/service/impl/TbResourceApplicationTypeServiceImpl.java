package com.dhcc.jn.tenant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbResourceApplicationTypeDao;
import com.dhcc.jn.tenant.entity.TbResourceApplicationType;
import com.dhcc.jn.tenant.service.TbResourceApplicationTypeService;


/**
 * 应用系统管理service实现类
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 *
 * @author <pre>
 * SD
 * 	jlf
 * PG
 * 	jlf
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 * <p>
 * <p/> $Id$
 */
@Service("tbResourceApplicationTypeService")
public class TbResourceApplicationTypeServiceImpl implements TbResourceApplicationTypeService {

	@Autowired
    private TbResourceApplicationTypeDao tbResourceApplicationTypeDao;

    @Override
    @Transactional
    public Page<TbResourceApplicationType> findByPage(TbResourceApplicationType tbResourceApplicationType, Page<TbResourceApplicationType> page) {

        page.setResult(tbResourceApplicationTypeDao.find(tbResourceApplicationType, page));

        return page;
    }

    @Override
    @Transactional
    public List<TbResourceApplicationType> findBySearch(TbResourceApplicationType tbResourceApplicationType) {

        return tbResourceApplicationTypeDao.find(tbResourceApplicationType);
    }

    @Override
    @Transactional
    public TbResourceApplicationType getById(String appTypeId) {

        return tbResourceApplicationTypeDao.getById(appTypeId);
    }

    @Override
    @Transactional
    public void add(TbResourceApplicationType tbResourceApplicationType) {

        tbResourceApplicationTypeDao.add(tbResourceApplicationType);
    }

    @Override
    @Transactional
    public void updateNotNull(TbResourceApplicationType tbResourceApplicationType) {

        tbResourceApplicationTypeDao.updateNotNull(tbResourceApplicationType);
    }


    @Override
    @Transactional
    public void delete(String appTypeId) {

        tbResourceApplicationTypeDao.delete(appTypeId);
    }

    @Override
    @Transactional
    public int findResourcesExist(String appTypeId) {

        return tbResourceApplicationTypeDao.findResourcesByTypeId(appTypeId);
    }

    @Override
    @Transactional
    public int findEffective(TbResourceApplicationType tb) {

        return tbResourceApplicationTypeDao.findEffective(tb);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> getFunctionList(String zhTypeId, String appTypeCode) {

        return tbResourceApplicationTypeDao.getFunctionList(zhTypeId, appTypeCode);
    }

}