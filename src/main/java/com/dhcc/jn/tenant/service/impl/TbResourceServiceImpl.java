package com.dhcc.jn.tenant.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbResourceDao;
import com.dhcc.jn.tenant.dao.TbTenantTypeResourceDao;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbTenantTypeResource;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.service.TbResourceService;
import org.springframework.util.StringUtils;

/**
 * 功能资源service实现类
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
@Service("tbResourceService")
public class TbResourceServiceImpl implements TbResourceService {

    @Autowired
    private TbResourceDao tbResourceDao;

    @Autowired
    private TbTenantTypeResourceDao tbTenantTypeResourceDao;

    @Override
    @Transactional
    public Page<TbResource> findByPage(TbResource tbResource, Page<TbResource> page) {

        page.setResult(tbResourceDao.find(tbResource, page));

        return page;
    }

    @Override
    @Transactional
    public List<TbResource> findBySearch(TbResource tbResource) {

        return tbResourceDao.find(tbResource);
    }

    @Override
    @Transactional
    public TbResource getById(String resourceId) {

        return tbResourceDao.getById(resourceId);
    }

    @Override
    @Transactional
    public void add(TbResource tbResource, TbTenantTypeResource tbTenantTypeResource, TbUser user,String zhTypeIds) {

        if (tbResource != null) {

            //添加功能资源表信息
            tbResource.setResourceId(ResourceUtils.getUUID().replace("-", ""));
            tbResource.setCreateId(user.getUserId());
            tbResource.setCreateName(user.getUsername());
            tbResource.setCreateDate(new Date());
            //执行添加操作
            tbResourceDao.add(tbResource);

            //添加用户类型关系
            if (!StringUtils.isEmpty(zhTypeIds)){
                String[] data = zhTypeIds.split(",");
                for (String zhTypeId : data) {
                    tbTenantTypeResource.setId(ResourceUtils.getUUID().replace("-", ""));
                    tbTenantTypeResource.setZhTypeId(zhTypeId);
                    tbTenantTypeResource.setResourceId(tbResource.getResourceId());
                    tbTenantTypeResource.setAppTypeCode(tbResource.getAppTypeCode());
                    tbTenantTypeResourceDao.add(tbTenantTypeResource);
                }
            }
        }
    }

    @Override
    @Transactional
    public void updateNotNull(TbResource tbResource, TbTenantTypeResource tbTenantTypeResource, TbUser user) {

        //更新Resource资源表
        tbResource.setUpdateId(user.getUserId());
        tbResource.setUpdateName(user.getUsername());
        tbResource.setUpdateDate(new Date());
        tbResourceDao.updateNotNull(tbResource);

        //更新租户类型功能清单
        if (null != tbTenantTypeResource) {

            //执行租户类型功能清单更新
            tbTenantTypeResourceDao.delete(tbResource.getResourceId());

            tbTenantTypeResource.setId(ResourceUtils.getUUID().replace("-", ""));
            tbTenantTypeResource.setResourceId(tbResource.getResourceId());

            tbTenantTypeResourceDao.add(tbTenantTypeResource);
        }
    }

    @Override
    @Transactional
    public void delete(String resourceId) {

        tbResourceDao.delete(resourceId);
    }

    @Override
    @Transactional
    public List<TbResource> getParentMenu(String appTypeCode) {

        return tbResourceDao.getParentMenu(appTypeCode);
    }

    @Override
    @Transactional
    public Boolean findEffectiveResourceLogo(String resourceFlag) {

        Boolean flag = true;

        int count = tbResourceDao.findEffectiveResourceLogo(resourceFlag);

        if (count > 0){
            flag = false;
        }
        return flag;
    }
    /**
     * 查找角色下的应用资源父节点
     *
     * @param
     * @param
     * @return
     */


    @Override
    @Transactional
    public List<TbResource> findRoleResourcesParent(String zhTypeId,String appTypeCode,String roleId) {

        return tbResourceDao.findRoleResourcesParent(zhTypeId,appTypeCode,roleId);
    }
    
    /**
      *  根据父id获取角色下的应用资源
     */
    public List<TbResource> findRoleResourcesParentResourceId(Map map){
    	
    	return tbResourceDao.findRoleResourcesParentResourceId(map);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> getUserRoleResources(String roleId) {

        return tbResourceDao.getUserRoleResources(roleId);
    }
}