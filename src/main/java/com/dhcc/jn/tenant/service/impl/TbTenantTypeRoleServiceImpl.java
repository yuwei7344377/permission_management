package com.dhcc.jn.tenant.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbTenantTypeRoleDao;
import com.dhcc.jn.tenant.entity.TbResource;
import com.dhcc.jn.tenant.entity.TbResourceApplicationType;
import com.dhcc.jn.tenant.entity.TbTenantTypeRole;
import com.dhcc.jn.tenant.entity.TbTenantTypeRoleResource;
import com.dhcc.jn.tenant.service.TbTenantTypeRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 租户类型默认角色service实现类
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 */
@Service("tbTenantTypeRoleService")
public class TbTenantTypeRoleServiceImpl implements TbTenantTypeRoleService {

    @Autowired
    private TbTenantTypeRoleDao tbTenantTypeRoleDao;

    @Override
    @Transactional
    public Page<TbTenantTypeRole> findByPage(TbTenantTypeRole tbTenantTypeRole, Page<TbTenantTypeRole> page) {

        page.setResult(tbTenantTypeRoleDao.find(tbTenantTypeRole, page));

        return page;
    }

    @Override
    @Transactional
    public List<TbTenantTypeRole> findBySearch(TbTenantTypeRole tbTenantTypeRole) {

        return tbTenantTypeRoleDao.find(tbTenantTypeRole);
    }

    @Override
    @Transactional
    public TbTenantTypeRole getById(String id) {

        return tbTenantTypeRoleDao.getById(id);
    }

    @Override
    @Transactional
    public void add(TbTenantTypeRole tbTenantTypeRole) {

        tbTenantTypeRole.setId(ResourceUtils.getUUID().replace("-", ""));
        tbTenantTypeRoleDao.add(tbTenantTypeRole);
    }

    @Override
    @Transactional
    public void update(TbTenantTypeRole tbTenantTypeRole) {

        if (!StringUtils.isEmpty(tbTenantTypeRole.getId())) {
            tbTenantTypeRoleDao.updateNotNull(tbTenantTypeRole);
        }
    }

    @Override
    @Transactional
    public void delete(String id) {

        tbTenantTypeRoleDao.delete(id);
    }

    @Override
    @Transactional
    public TbTenantTypeRole getByRoleCode(String roleCode) {
        return tbTenantTypeRoleDao.getByRoleCode(roleCode);
    }

    @Override
    @Transactional
    public TbTenantTypeRole getByRoleName(String roleName) {
        return tbTenantTypeRoleDao.getByRoleName(roleName);
    }

    @Override
    @Transactional
    public Page<TbTenantTypeRole> getUserTypeFunctionList(String zhTypeId, String roleName, Page<TbTenantTypeRole> page) {

        page.setResult(tbTenantTypeRoleDao.getUserTypeFunctionList(zhTypeId, roleName, page));

        return page;
    }

    @Override
    @Transactional
    public Boolean getEffectiveCoding(String zhTypeId, String roleCode) {

        Boolean flag = true;

        List<Map<String, Object>> countList = tbTenantTypeRoleDao.getEffectiveCoding(zhTypeId, roleCode);

        for (Map<String, Object> map : countList) {
            if (Integer.valueOf(map.get("count").toString()) > 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    @Override
    @Transactional
    public Boolean delRoleContent(String id) {
        Boolean flag = true;
        int count = tbTenantTypeRoleDao.finRole(id);

        if (count > 0) {
            flag = false;
        } else {
            tbTenantTypeRoleDao.delete(id);
        }

        return flag;
    }

    @Override
    @Transactional
    public List<TbResourceApplicationType> getUserFunctionalResources(String zhTypeId) {

        return tbTenantTypeRoleDao.getUserFunctionalResources(zhTypeId);
    }


    @Override
    @Transactional
    public void saveRoleResources(@Param("roleId") String roleId,@Param("appTypeCode")  String appTypeCode,String treeData) {

        //原有的数据清空
        tbTenantTypeRoleDao.delRoleResources(roleId,appTypeCode);
        //接收多个复选框值
        if (!StringUtils.isEmpty(treeData)) {
            String[] datas = treeData.split(",");

            List<TbTenantTypeRoleResource> tbList = new ArrayList<>();

            for (String resourceId : datas) {
                TbTenantTypeRoleResource tb = new TbTenantTypeRoleResource();
                tb.setId(ResourceUtils.getUUID().replace("-", ""));
                tb.setRoleId(roleId);
                tb.setResourceId(resourceId);
                tb.setAppTypeCode(appTypeCode);
                tbList.add(tb);
            }
            tbTenantTypeRoleDao.insertRoleResources(tbList);
        }
    }


}