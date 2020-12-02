package com.dhcc.jn.tenant.enums;

public class GlobalConsts {
    public static final String STATE_0 = "0"; // 状态码：1
    public static final String STATE_1 = "1"; // 状态码：1
    public static final String STATE_2 = "2"; // 状态码：2
    public static final String STATE_3 = "3"; // 状态码：3
    public static final String STATE_4 = "4"; // 状态码：4

    public static final String DEFAULT_SECRET = "dhcc1234"; // 默认密码

    public static final String SOLE_PROPRIETOR = "个体户";
    public static final String MUNICIPALITIES = "市辖区";

    /**
     * 运单执行状态
     */
    public static final String BILL_00 = "00"; // 未生效
    public static final String BILL_01 = "01"; // 未执行
    public static final String BILL_02 = "02"; // 执行中
    public static final String BILL_03 = "03"; // 已执行
    public static final String BILL_DRAFT = "00,01,02";

    // 司机-承运关系
    public static final String COMPANY_CARRIAGE = "10"; // 承运公司
    public static final String COMPANY_PERSONAL = "11"; // 个体户

    public static final String SEX_MALE = "男";
    public static final String SEX_FEMALE = "女";
}
