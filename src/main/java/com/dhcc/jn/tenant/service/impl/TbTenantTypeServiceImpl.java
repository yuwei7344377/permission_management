package com.dhcc.jn.tenant.service.impl;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbTenantTypeDao;
import com.dhcc.jn.tenant.entity.TbTenantType;
import com.dhcc.jn.tenant.service.TbTenantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 租户类型service实现类
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
@Service("tbTenantTypeService")
public class TbTenantTypeServiceImpl implements TbTenantTypeService {

    @Autowired
    private TbTenantTypeDao tbTenantTypeDao;

    @Override
    @Transactional
    public Page<TbTenantType> findByPage(TbTenantType tbTenantType, Page<TbTenantType> page) {

        page.setResult(tbTenantTypeDao.find(tbTenantType, page));
        return page;
    }

    @Override
    @Transactional
    public List<TbTenantType> findBySearch(TbTenantType tbTenantType) {

        return tbTenantTypeDao.find(tbTenantType);
    }

    @Override
    @Transactional
    public TbTenantType getById(String zhTypeId) {

        return tbTenantTypeDao.getById(zhTypeId);
    }

    @Override
    @Transactional
    public void add(TbTenantType tbTenantType) {

        tbTenantType.setZhTypeId(ResourceUtils.getUUID());
        tbTenantTypeDao.add(tbTenantType);
    }

    @Override
    @Transactional
    public void update(TbTenantType tbTenantType) {

        tbTenantTypeDao.update(tbTenantType);
    }

    @Override
    @Transactional
    public void delete(String zhTypeId) {

        tbTenantTypeDao.delete(zhTypeId);
    }

}