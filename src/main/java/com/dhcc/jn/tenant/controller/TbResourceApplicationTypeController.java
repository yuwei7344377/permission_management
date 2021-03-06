package com.dhcc.jn.tenant.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResourceUtils;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbResourceApplicationType;
import com.dhcc.jn.tenant.service.TbResourceApplicationTypeService;
import com.dhcc.jn.tenant.service.TbTenantTypeResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 应用系统管理controller
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 */
@RestController
@RequestMapping("/tbResourceApplicationType")
public class TbResourceApplicationTypeController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbResourceApplicationTypeService tbResourceApplicationTypeService;

    @Autowired
    private TbTenantTypeResourceService tbTenantTypeResourceService;


    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbResourceApplicationType
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public JSONObject list(TbResourceApplicationType tbResourceApplicationType, Page<TbResourceApplicationType> page, HttpServletRequest request) {

        try {
            //返回查詢結果,帶分頁
            return ResponseMessage.returnInfo(true, tbResourceApplicationTypeService.findByPage(tbResourceApplicationType, page), null, null);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * 更新应用系统信息
     */
    @PostMapping("/update")
    public JSONObject update(@RequestParam(value = "appTypeId", required = true) String appTypeId,
                             TbResourceApplicationType tbResourceApplicationType) {
        try {
            // 修改
            if (ValidateUtils.isNotEmpty(appTypeId)) {
                tbResourceApplicationTypeService.updateNotNull(tbResourceApplicationType);
                return ResponseMessage.returnInfo(true, null, null, "save_success");
            } else {
                return ResponseMessage.returnInfoSpecial(false, null, null, "应用系统Id不能为空！");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增硬功系统信息
     * </pre>
     *
     * @param tbResourceApplicationType
     * @return
     */
    @PostMapping("/add")
    public JSONObject add(TbResourceApplicationType tbResourceApplicationType) {

        try {
            tbResourceApplicationType.setAppTypeId(ResourceUtils.getUUID());
            tbResourceApplicationTypeService.add(tbResourceApplicationType);
            return ResponseMessage.returnInfo(true, null, null, "save_success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }

    /**
     * 2020-07-22 jlf
     * 删除应用系统列表
     *
     * @param appTypeId
     * @return
     */
    @PostMapping("/delete")
    public JSONObject delete(@RequestParam(value = "appTypeId", required = true) String appTypeId) {

        try {
            int count = tbResourceApplicationTypeService.findResourcesExist(appTypeId);
            
            System.out.println("&&&&&&&&&&&&&&&&&&&&:"+count);
            
            //查到系统下有资源信息不能做删除动作
            if (count != 0) {
                return ResponseMessage.returnInfoSpecial(false, null, null, "该应用系统已分配应用资源，不能删除！");
            } else {
                tbResourceApplicationTypeService.delete(appTypeId);
                return ResponseMessage.returnInfo(true, null, null, "delete_success");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }

    /**
     * 判断系统编码,名称,简称是否唯一方法
     */
    @RequestMapping("/findEffective")
    public JSONObject findEffective(TbResourceApplicationType tb) {

        String flag = "";

        if (tb.getAppTypeCode() != null && !tb.getAppTypeCode().equals("")) {
            flag = "应用系统编码";
        } else if (tb.getAppTypeName() != null && !tb.getAppTypeName().equals("")) {
            flag = "应用系统名称";
        } else if(tb.getAppTypeShortName() != null && !tb.getAppTypeShortName().equals("")){
            flag = "应用系统简称";
        }

        try {
            int count = tbResourceApplicationTypeService.findEffective(tb);
            if (count > 0) {
                return ResponseMessage.returnInfo(false, null, null, flag + "already_exists");
            } else {
                return ResponseMessage.returnInfo(true, null, null, null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }

    /**
     * 获取当前用户下应用系统列表下关联的功能清单
     */
    @RequestMapping("/getFunctionList")
    public JSONObject getFunctionList(@RequestParam("zhTypeId") String zhTypeId,
                                      @RequestParam("appTypeCode") String appTypeCode) {

        try {
            List<Map<String, Object>> list = tbResourceApplicationTypeService.getFunctionList(zhTypeId, appTypeCode);
            return ResponseMessage.returnInfo(true, list, null, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * 保存用户类型对应功能清单
     *
     * @param zhTypeId
     * @param appTypeCode
     * @return
     */
    @RequestMapping("/saveFunctionList")
    public JSONObject saveFunctionList(@RequestParam("zhTypeId") String zhTypeId, @RequestParam("appTypeCode") String appTypeCode,
                                       String treeData) {

        if (StringUtils.isEmpty(zhTypeId) || StringUtils.isEmpty(appTypeCode)) {
            return ResponseMessage.returnInfoSpecial(false,null,null,"参数不存在!");
        }

        try {

            tbTenantTypeResourceService.saveFunctionList(zhTypeId, appTypeCode, treeData);

            return ResponseMessage.returnInfo(true, null, null, "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }

    }
}
