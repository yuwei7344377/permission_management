package com.dhcc.jn.tenant.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.ResponseMessage;
import com.dhcc.jn.tenant.common.ValidateUtils;
import com.dhcc.jn.tenant.common.base.BaseController;
import com.dhcc.jn.tenant.common.persistence.Page;
import com.dhcc.jn.tenant.entity.TbTenantTypeData;
import com.dhcc.jn.tenant.service.TbTenantTypeDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 租户类型数据资源清单controller
 *
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 *
 * @author <p/> $Id$
 */
@RestController
@RequestMapping("/tbTenantTypeData")
public class TbTenantTypeDataController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbTenantTypeDataService tbTenantTypeDataService;

    /**
     * 获取用户类型下数据目录展示树
     */
    @RequestMapping("/getUserTypeDataList")
    public JSONObject getUserTypeDataList(@RequestParam("zhTypeId") String zhTypeId) {
        try {

            List<TbTenantTypeData> dataList = tbTenantTypeDataService.findParentId(zhTypeId);

            if (dataList != null && !dataList.isEmpty()) {
                for (int i = 0; i < dataList.size(); i++) {
                    TbTenantTypeData tbTenantTypeData = dataList.get(i);
                    List<TbTenantTypeData> list = getUserTypeInfoByParentId(zhTypeId, tbTenantTypeData.getDataId());
                    if (null != list && !list.isEmpty()) {

                        dataList.get(i).setTbTenantTypeDataList(list);
                    }/*else {
                        dataList.get(i).setTbTenantTypeDataList(null);
                    }*/
                }
                return ResponseMessage.returnInfo(true, dataList, null, null);
            }

            return ResponseMessage.returnInfo(true, null, null, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseMessage.returnInfo(false, null, null, "error");
        }
    }

    public List<TbTenantTypeData> getUserTypeInfoByParentId(String zhTypeId, String dataId) {

        TbTenantTypeData tb = new TbTenantTypeData();
        tb.setParentId(dataId);

        List<TbTenantTypeData> typeList = tbTenantTypeDataService.getUserTypeData(zhTypeId, dataId);

        if (typeList != null && !typeList.isEmpty()) {
            for (int i = 0; i < typeList.size(); i++) {

                TbTenantTypeData tbTenantTypeData = typeList.get(i);
                List<TbTenantTypeData> list1 = getUserTypeInfoByParentId(zhTypeId, tbTenantTypeData.getDataId());
                if (null != list1 && list1.size() > 0) {

                    tbTenantTypeData.setTbTenantTypeDataList(list1);
                }
            }

            return typeList;
        }
        return null;
    }


    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	分页查询
     * </pre>
     *
     * @param tbTenantTypeData
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(TbTenantTypeData tbTenantTypeData, Page<TbTenantTypeData> page, HttpServletRequest request) {

        try {

            request.setAttribute("page", tbTenantTypeDataService.findByPage(tbTenantTypeData, page));
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "test/tbTenantTypeDataList";
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
    @RequestMapping("/tbTenantTypeData")
    public String tbTenantTypeData(String id, HttpServletRequest request) {

        try {

            if (ValidateUtils.isNotEmpty(id)) {

                TbTenantTypeData tbTenantTypeData = tbTenantTypeDataService.getById(id);
                request.setAttribute("tbTenantTypeData", tbTenantTypeData);
            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "test/tbTenantTypeData";
    }

    /**
     * <pre>
     * 	2020-07-22 jlf
     * 	保存
     * </pre>
     *
     * @param tbTenantTypeData
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(TbTenantTypeData tbTenantTypeData) {

        JSONObject json = new JSONObject();

        try {

            // 修改
            if (ValidateUtils.isNotEmpty(tbTenantTypeData.getId())) {

                tbTenantTypeDataService.update(tbTenantTypeData);
            }
            // 新增
            else {

                tbTenantTypeDataService.add(tbTenantTypeData);
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
     * 	2020-07-22 jlf
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

            tbTenantTypeDataService.delete(id);
            json.put("result", "delete_success");
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }

        return json.toString();
    }
}
