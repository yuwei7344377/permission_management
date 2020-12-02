package com.dhcc.jn.tenant.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbTenantTypeRole;
import com.dhcc.jn.tenant.service.TbTenantTypeRoleService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 租户类型默认角色controller
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 */
@RestController
@RequestMapping("/tbTenantTypeRole")
public class TbTenantTypeRoleController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbTenantTypeRoleService tbTenantTypeRoleService;


    /**
     * 获取某一个用户类型下所有角色列表
     *
     * @param zhTypeId
     * @param page
     * @return
     */
    @RequestMapping("/getUserTypeFunctionList")
    public JSONObject getUserTypeFunctionList(@RequestParam("zhTypeId") String zhTypeId, String roleName, Page<TbTenantTypeRole> page) {

        try {
            //用户类型已分配的功能清单,带分页
            return ResponseMessage.returnInfo(true, tbTenantTypeRoleService.getUserTypeFunctionList(zhTypeId, roleName, page), null, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }


    /**
     * 角色编码唯一验证
     */
    @RequestMapping("/getEffectiveCoding")
    public JSONObject getEffectiveCoding(@RequestParam("zhTypeId") String zhTypeId,
                                         @RequestParam("roleCode") String roleCode) {

        try {
            Boolean flag = tbTenantTypeRoleService.getEffectiveCoding(zhTypeId, roleCode);

            if (flag) {
                return ResponseMessage.returnInfo(true, null, null, null);
            } else {
                return ResponseMessage.returnInfo(false, null, null, "角色编码already_exists");
            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }


    /**
     * 新增角色内容(角色编码、角色名称)
     *
     * @return
     */
    @PostMapping("/addRoleContent")
    public JSONObject addRoleContent(TbTenantTypeRole tbTenantTypeRole) {

        try {
            tbTenantTypeRoleService.add(tbTenantTypeRole);

            return ResponseMessage.returnInfo(true, null, null, "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * 编辑更新角色内容(角色编码、角色名称)
     *
     * @return
     */
    @PostMapping("/updateRoleContent")
    public JSONObject updateRoleContent(TbTenantTypeRole tbTenantTypeRole) {

        try {

            tbTenantTypeRoleService.update(tbTenantTypeRole);
            return ResponseMessage.returnInfo(true, null, null, "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * 根据角色id回显角色信息
     *
     * @return
     */
    @RequestMapping("/getById")
    public JSONObject getById(@Param("id") String id) {

        try {

            return ResponseMessage.returnInfo(true, tbTenantTypeRoleService.getById(id), null, null);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }


    /**
     * 2020-07-22 jlf
     * 删除角色信息
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteRoleContent")
    public JSONObject RoleContent(@Param("id") String id) {

        try {

            Boolean flag = tbTenantTypeRoleService.delRoleContent(id);

            if (flag) {
                return ResponseMessage.returnInfo(true, null, null, "delete_success");
            } else {
                return ResponseMessage.returnInfoSpecial(true, null, null, "该角色已分配账号，不能删除！");
            }

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");

        }
    }

    /**
     * 获取用户类别下的应用系统
     *
     * @param zhTypeId
     * @return
     */
    @RequestMapping("/getUserFunctionalResources")
    public JSONObject getUserFunctionalResources(@RequestParam("zhTypeId") String zhTypeId) {

        try {
            return ResponseMessage.returnInfo(true, tbTenantTypeRoleService.getUserFunctionalResources(zhTypeId), null, null);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");

        }
    }


    /**
     * 分配角色应用资源
     *
     * @param roleId
     * @return
     */
    @PostMapping("/saveRoleResources")
    public JSONObject saveRoleResources(@RequestParam("roleId") String roleId, @RequestParam("appTypeCode") String appTypeCode,String treeData) {

        try {
            tbTenantTypeRoleService.saveRoleResources(roleId, appTypeCode,treeData);
            return ResponseMessage.returnInfo(true, null, null, "save_success");

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");

        }
    }


    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbTenantTypeRole
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(TbTenantTypeRole tbTenantTypeRole, Page<TbTenantTypeRole> page, HttpServletRequest request) {

        try {

            request.setAttribute("page", tbTenantTypeRoleService.findByPage(tbTenantTypeRole, page));
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "test/tbTenantTypeRoleList";
    }

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	新增修改页面初始化
     * </pre>
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/tbTenantTypeRole")
    public String tbTenantTypeRole(String id, HttpServletRequest request) {

        try {

            if (ValidateUtils.isNotEmpty(id)) {

                TbTenantTypeRole tbTenantTypeRole = tbTenantTypeRoleService.getById(id);
                request.setAttribute("tbTenantTypeRole", tbTenantTypeRole);
            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "test/tbTenantTypeRole";
    }

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	保存
     * </pre>
     *
     * @param tbTenantTypeRole
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(TbTenantTypeRole tbTenantTypeRole) {

        JSONObject json = new JSONObject();

        try {

            // 修改
            if (ValidateUtils.isNotEmpty(tbTenantTypeRole.getId())) {

                tbTenantTypeRoleService.update(tbTenantTypeRole);
            }
            // 新增
            else {

                tbTenantTypeRoleService.add(tbTenantTypeRole);
            }
            json.put("result", "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "save_fail");
        }

        return json.toString();
    }

}
