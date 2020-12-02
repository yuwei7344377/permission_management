package com.dhcc.jn.tenant.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbTenantType;
import com.dhcc.jn.tenant.service.TbTenantTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 租户类型controller
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
@RestController
@RequestMapping("/tbTenantType")
public class TbTenantTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbTenantTypeService tbTenantTypeService;

    /**
     * 用户类型分页查询
     */
    @RequestMapping("/list")
    public JSONObject list(TbTenantType tbTenantType, Page<TbTenantType> page) {

        try {
            //展示用户类型信息,带分页
            return ResponseMessage.returnInfo(true,tbTenantTypeService.findByPage(tbTenantType, page),null,null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(true,null,e.getMessage(),"error");
        }
    }
}
