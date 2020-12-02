package com.dhcc.jn.tenant.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.dao.TbCoalPoundDao;
import com.dhcc.jn.tenant.dao.TbCoalRelatedDao;
import com.dhcc.jn.tenant.dao.TbRoleOrgYyDao;
import com.dhcc.jn.tenant.entity.TbCoalPound;
import com.dhcc.jn.tenant.entity.TbCoalRelated;
import com.dhcc.jn.tenant.entity.TbRoleOrgYy;
import com.dhcc.jn.tenant.service.TbCoalRelatedService;

/**
 * 
 * 企业表service实现类
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
@Service("tbCoalRelatedService")
public class TbCoalRelatedServiceImpl implements TbCoalRelatedService {

	@Autowired
	private TbCoalRelatedDao tbCoalRelatedDao;
	
	@Autowired
	private TbCoalPoundDao tbCoalPoundDao;
	
	@Autowired
	private TbRoleOrgYyDao tbRoleOrgYyDao;
	
	@Override
	public Page<TbCoalRelated> findByPage(TbCoalRelated tbCoalRelated, Page<TbCoalRelated> page) {

		page.setResult(tbCoalRelatedDao.find(tbCoalRelated, page));
		
		return page;
	}
	
	@Override
	public List<TbCoalRelated> findBySearch(TbCoalRelated tbCoalRelated) {

		return tbCoalRelatedDao.find(tbCoalRelated);
	}
	
	@Override
	public TbCoalRelated getById(String id) {

		return tbCoalRelatedDao.getById(id);
	}

	@Override
	public void add(TbCoalRelated tbCoalRelated) {

		tbCoalRelated.setId(ResourceUtils.getUUID());
		tbCoalRelatedDao.add(tbCoalRelated);
	}
	
	@Override
	public void update(TbCoalRelated tbCoalRelated) {

		tbCoalRelatedDao.update(tbCoalRelated);
	}

	@Override
	public void delete(String id) {

		tbCoalRelatedDao.delete(id);
	}

	/**
	 * 获取企业信息
	 */
	@Override
	public List<TbCoalRelated> getByParentId(String parentId) {
		return tbCoalRelatedDao.getByParentId(parentId);
	}

	/**
	 * 获取企业信息
	 */
	@Override
	public List<TbCoalRelated> findByOrgCode(String parentId,String roleId) {
		//获取所有企业信息
		List<TbCoalRelated> list = tbCoalRelatedDao.findByOrgCode(parentId);
		if(StringUtils.isEmpty(roleId)) {
			return list;
		}
		//获取选中企业信息
		List<TbRoleOrgYy> tbRoleOrgYyList = tbRoleOrgYyDao.findByRoleId(roleId);
		for(TbCoalRelated Relatedentity : list) {
			String qyCode = Relatedentity.getCode();
			for(TbRoleOrgYy RoleOrgYyentity:tbRoleOrgYyList) {
				if (qyCode.equals(RoleOrgYyentity.getQyCode())) {
					Relatedentity.setChecked("true");
				}else {
					Relatedentity.setChecked("false");
				}
			}
		}
		return list;
	}

	/**
	 * 获取企业下的磅房
	 */
	@Override
	public List<Map<String, Object>> findrelatedBF(String orgCode,String roleId) {
		//获取企业下的所有磅房
		List<Map<String, Object>> list = tbCoalRelatedDao.findrelatedBF(orgCode);
		if (StringUtils.isEmpty(roleId)) {
			return list;
		}
		list =  tbRoleOrgYyDao.findDepartequipmeninfoAndroleorgyy(orgCode,roleId);
		return list;
	}

	@Override
	public List<Map<String, Object>> subscribe(String qyCode) {
		//第一层磅房
		List<Map<String, Object>> bfList = tbCoalRelatedDao.findrelatedBF(qyCode);
		//第二层进车出车
		
		//第三层磅道
		for(Map<String, Object> bfMap : bfList) {
			List<Map<String, Object>> getAndoutBD = new ArrayList<Map<String, Object>>();
			String bfCode = (String) bfMap.get("bfCode");
			
			// 根据qyid,bfcode找磅道
			List<Map<String, Object>> bdList = tbCoalRelatedDao.findRelatedBD(qyCode,bfCode);//找磅房下所有磅道
						
			// 根据qyid,bfcode，inbdcode,outbodecode
			List<TbCoalPound> list = tbCoalPoundDao.findByqiIdAndbfCode(qyCode,bfCode);//绑定的磅道
			
			Map<String, Object> getBD = new HashMap<String, Object>();
			getBD.put("inName", "进车磅道");
			//inbdcode
			for(Map<String, Object> bdIn : bdList) {
				String code = (String) bdIn.get("bdCode");
				if(null != list && list.size()>0) {
					
					for(TbCoalPound pound : list) {
						
						if ((","+pound.getInBdCode()+",").contains(","+code+",")) {
							bdIn.put("checked", "true");
						}else {
							bdIn.put("checked", "false");
						}
					}
				}
				else {
					bdIn.put("checked", "false");
				}
			}
			getBD.put("chiled", bdList);
			getAndoutBD.add(getBD);
			
			List<Map<String, Object>> bdOut = tbCoalRelatedDao.findRelatedBD(qyCode,bfCode);//找磅房下所有磅道
			Map<String, Object> outBD = new HashMap<String, Object>();
			outBD.put("outName", "出车磅道");
			//outbdcode
			for(Map<String, Object> bdout : bdOut) {
				String code = (String) bdout.get("bdCode");
				if(null != list && list.size()>0) {
					for(TbCoalPound pound : list) {
						if ((","+pound.getOutBdCode()+",").contains(","+code+",")) {	
							bdout.put("checked", "true");
						}else {
							bdout.put("checked", "false");
						}
					}
				}
				else {
					bdout.put("checked", "false");
				}
			}
			
			outBD.put("chiled", bdOut);
			getAndoutBD.add(outBD);
			
			bfMap.put("result", getAndoutBD);
		}
		
		
		return bfList;
	}
}