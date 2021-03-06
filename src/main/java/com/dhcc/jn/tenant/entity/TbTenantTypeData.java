package com.dhcc.jn.tenant.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 租户类型数据资源清单实体类.
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
public class TbTenantTypeData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * 租户类型id
     */
    private String zhTypeId;
    /**
     * 数据资源id
     */
    private String dataId;
    /**
     * 目录数据资源ID上级或者产品数据资源ID上级
     */
    private String parentId;
    /**
     * 数据来源 0 目录资源表，1 产品资源表
     **/
    private String dataFrom;
    /**
     * 目录名称
     **/
    private String catalogName;

    public String getCatalogName() {
        return this.catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }


    private List<TbTenantTypeData> tbTenantTypeDataList = null;

    public List<TbTenantTypeData> getTbTenantTypeDataList() {
        return tbTenantTypeDataList;
    }

    public void setTbTenantTypeDataList(List<TbTenantTypeData> tbTenantTypeDataList) {
        this.tbTenantTypeDataList = tbTenantTypeDataList;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  租户类型id
     */
    public String getZhTypeId() {
        return this.zhTypeId;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  租户类型id
     */
    public void setZhTypeId(String zhTypeId) {
        this.zhTypeId = zhTypeId;
    }

    /**
     * 方法: 取得String
     *
     * @return: String  数据资源id
     */
    public String getDataId() {
        return this.dataId;
    }

    /**
     * 方法: 设置String
     *
     * @param: String  数据资源id
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }


}
