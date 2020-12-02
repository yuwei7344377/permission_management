package com.dhcc.jn.tenant.service.impl;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbTenantTypeDataDao;
import com.dhcc.jn.tenant.entity.TbTenantTypeData;
import com.dhcc.jn.tenant.service.TbTenantTypeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 租户类型数据资源清单service实现类
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
@Service("tbTenantTypeDataService")
public class TbTenantTypeDataServiceImpl implements TbTenantTypeDataService {

    @Autowired
    private TbTenantTypeDataDao tbTenantTypeDataDao;

    @Override
    @Transactional
    public Page<TbTenantTypeData> findByPage(TbTenantTypeData tbTenantTypeData, Page<TbTenantTypeData> page) {

        page.setResult(tbTenantTypeDataDao.find(tbTenantTypeData, page));

        return page;
    }

    @Override
    @Transactional
    public List<TbTenantTypeData> findBySearch(TbTenantTypeData tbTenantTypeData) {

        return tbTenantTypeDataDao.find(tbTenantTypeData);
    }

    @Override
    @Transactional
    public TbTenantTypeData getById(String id) {

        return tbTenantTypeDataDao.getById(id);
    }

    @Override
    @Transactional
    public void add(TbTenantTypeData tbTenantTypeData) {

        tbTenantTypeData.setId(ResourceUtils.getUUID());
        tbTenantTypeDataDao.add(tbTenantTypeData);
    }

    @Override
    @Transactional
    public void update(TbTenantTypeData tbTenantTypeData) {

        tbTenantTypeDataDao.update(tbTenantTypeData);
    }

    @Override
    @Transactional
    public void delete(String id) {

        tbTenantTypeDataDao.delete(id);
    }

    @Override
    @Transactional
    public List<TbTenantTypeData> findParentId(String zhTypeId) {

        return tbTenantTypeDataDao.findParentId(zhTypeId);
    }

    @Override
    @Transactional
    public List<TbTenantTypeData> getUserTypeData(String zhTypeId, String dataId) {

        return tbTenantTypeDataDao.getUserTypeData(zhTypeId, dataId);
    }

}