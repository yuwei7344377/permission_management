package com.dhcc.jn.tenant.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.entity.VDataCatalog;
import com.dhcc.jn.tenant.service.VDataCatalogService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 数据目录controller
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-23 jlf
 * 	新建文件
 */
@RestController
@RequestMapping("/vDataCatalog")
public class VDataCatalogController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VDataCatalogService vDataCatalogService;


    /**
     * <pre>
     * 	2020-07-23 jlf
     * 	获取数据列表树
     * </pre>
     *
     * @param
     * @return
     */
    @RequestMapping("/list")
    public JSONObject list() {

        try {
            //查找父节点
            List<VDataCatalog> dataList = vDataCatalogService.findParentId();

            if (null != dataList && !dataList.isEmpty()) {
                for (int i = 0; i < dataList.size(); i++) {

                    VDataCatalog dataCatalog = dataList.get(i);
                    List<VDataCatalog> vDataCatalogList = getVDataCatalogChildNode(dataCatalog.getId());
                    dataCatalog.setChildren(vDataCatalogList);

                }
                return ResponseMessage.returnInfo(true, dataList, null, null);
            }
            return ResponseMessage.returnInfo(true, null, null, null);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }
    }

    /**
     * 获取 parentId下所有子节点
     */
    public List<VDataCatalog> getVDataCatalogChildNode(String parentId) {

        VDataCatalog vDataCatalog = new VDataCatalog();
        vDataCatalog.setPid(parentId);
        List<VDataCatalog> bySearch = vDataCatalogService.findBySearch(vDataCatalog);

        if (null != bySearch && !bySearch.isEmpty()) {
            for (int i = 0; i < bySearch.size(); i++) {
                VDataCatalog vDataCatalog1 = bySearch.get(i);
                List<VDataCatalog> vDataCatalogChildNode = getVDataCatalogChildNode(vDataCatalog1.getId());
                if (null != vDataCatalogChildNode && !vDataCatalogChildNode.isEmpty()) {
                    bySearch.get(i).setChildren(vDataCatalogChildNode);
                }
            }
            return bySearch;
        }
        return null;
    }

    @RequestMapping("/saveUserData")
    public JSONObject saveUserData(@RequestParam("zhTypeId") String zhTypeId, @RequestParam("parentIds") String parentIds,
                                   String treeData) {

        if (StringUtils.isEmpty(zhTypeId) || StringUtils.isEmpty(parentIds)) {
            return ResponseMessage.returnInfoSpecial(false, null, null, "参数不存在!");
        }

        try {

            vDataCatalogService.saveUserData(zhTypeId, parentIds, treeData);

            return ResponseMessage.returnInfo(true, null, null, "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");
        }

    }

    /**
     * 获取角色中的数据产品资源是否选中
     */
    @RequestMapping("/getRoleDataProductResources")
    public JSONObject getRoleDataProductResources(@RequestParam("roleId") String roleId, @RequestParam("zhTypeId") String zhTypeId,
                                                  @RequestParam("dataId") String dataId) {

        try {
            List<Map<String, Object>> list = vDataCatalogService.getRoleDataProductResources(roleId, zhTypeId, dataId);
            return ResponseMessage.returnInfo(true, list, null, null);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");

        }
    }

    /**
     * 分配数据资源
     *
     * @param roleId
     * @param treeData
     * @return
     */
    @PostMapping("/saveDataResources")
    public JSONObject saveDataResources(@RequestParam("roleId") String roleId, @RequestParam("parentIds") String parentIds,
                                        String treeData) {

        if (StringUtils.isEmpty(roleId) || StringUtils.isEmpty(parentIds)) {
            return ResponseMessage.returnInfoSpecial(false, null, null, "参数不存在!");
        }

        try {
            vDataCatalogService.saveDataResources(roleId, parentIds, treeData);
            return ResponseMessage.returnInfo(true, null, null, "save_success");

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, e.getMessage(), "error");

        }
    }


    /**
     * 2020-07-23 jlf
     * 新增修改页面初始化
     * </pre>
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/vDataCatalog")
    public String vDataCatalog(String id, HttpServletRequest request) {

        try {

            if (ValidateUtils.isNotEmpty(id)) {

                VDataCatalog vDataCatalog = vDataCatalogService.getById(id);
                request.setAttribute("vDataCatalog", vDataCatalog);
            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "test/vDataCatalog";
    }

    /**
     * <pre>
     * 	2020-07-23 jlf
     * 	保存
     * </pre>
     *
     * @param vDataCatalog
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(VDataCatalog vDataCatalog) {

        JSONObject json = new JSONObject();

        try {

            // 修改
            if (ValidateUtils.isNotEmpty(vDataCatalog.getId())) {

                vDataCatalogService.update(vDataCatalog);
            }
            // 新增
            else {

                vDataCatalogService.add(vDataCatalog);
            }
            json.put("result", "save_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "save_fail");
        }

        return json.toString();
    }

    /**
     * <pre>
     * 	2020-07-23 jlf
     * 	删除
     * </pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id) {

        JSONObject json = new JSONObject();

        try {

            vDataCatalogService.delete(id);
            json.put("result", "delete_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }

        return json.toString();
    }
}
