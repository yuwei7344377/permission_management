package com.dhcc.jn.tenant.common;

import com.dhcc.jn.tenant.entity.TbUser;

public class Constants {

    /**
     * 返回成功
     */
    public static final int ZERO = 0;

    /**
     * 返回失败
     */
    public static final int ONE = 1;

    /**
     * 给角色分配资源后资源默认状态为审核通过
     */
    public static final String STATE = "1";
    
    /**
     * 新增租户给组织表新增一条数据组织级别为顶级组织
     */
    public static final String ORGTYPE = "1";
    
    /**
     * 组织type默认为2
     */
    public static final String ORGTYPE_2 = "2";
    
    /**
     * 新增租户给组织表新增一条数据组织排序为1
     */
    public static final String ORGORDER = "1";
    /**
     * 级别-省
     */
    public static final String ORGLEVEL_1 = "1";
    /**
     * 级别-市
     */
    public static final String ORGLEVEL_2 = "2";
    /**
     * 级别-县
     */
    public static final String ORGLEVEL_3 = "3";
    /**
     * 新增租户给企业表新增一条数据企业级别默认为4企业
     */
    public static final String ORGLEVEL_4 = "4";
    
    /**
     * 新增租户给企业表新增一条数据是否为采集点默认为1 是
     */
    public static final String ISCOLLECT_1= "1";
    /**
     * 是否为采集点 0 否
     */
    public static final String ISCOLLECT_0= "0";
    
    /**
     * 新增租户给企业表新增一条数据机构类型编码默认为2企业
     */
    public static final String ORGTYPECODE = "2";
    
    /**
     * 新增租户给企业表新增一条数据机构类型名称默认为企业
     */
    public static final String ORGTYPENAME = "企业";
    
    /**
     * 新增租户给企业表新增一条数据审核状态默认为2
     */
    public static final String CHECKSTATUS = "2";
    /**
     * 新增租户给账户表新增一条数据账户状态为1系统用户
     */
    public static final String USERSTATE = "1";
    
    /**
     * 新增租户给账户表新增一条数据删除状态为0未删除
     */
    public static final String DELETEFLAG = "0";
    
    /**
     * 新增租户给账户表新增一条数据是否为司机默认为0
     */
    public static final String DRIVER = "0";
    /**
     * 新增账户时账户状态默认为2普通用户
     */
    public static final String userSTATE = "2";
    
    /**
     * 新增账户时开发权限标志默认为0
     */
    public static final String DEVFLAG = "0";
    /**
     * 根据key值获取到的用户信息
     */
    public static  TbUser tbUser;
    
    /**
     * tb_user_role表中role_source来源:1用户类型角色表 2角色表
     */
    public static  final String ROLE_SOURCE_1 ="1";
    
    /**
     * tb_user_role表中role_source来源:1用户类型角色表 2角色表
     */
    public static  final String ROLE_SOURCE_2 ="2";
    /**
     * 数据来源 0 目录资源表，1 产品资源表
     */
    public static  final String DATA_FROM_0 ="0";
    
    /**
     * 数据来源 0 目录资源表，1 产品资源表
     */
    public static  final String DATA_FROM_1 ="1";
    
    /**
     * 山西省晋能集团运营租户ID
     */
    public static final String TENANT_USER_ZHID_3 = "3";
    
    /**
     * 默认上级组织ID
     */
    public static final String TBOGR_PARENTORGID_0 = "0";
}
