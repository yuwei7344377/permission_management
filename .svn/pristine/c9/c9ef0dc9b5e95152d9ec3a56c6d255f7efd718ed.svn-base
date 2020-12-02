package com.dhcc.jn.tenant.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 项目参数工具类
 *
 * @author King
 */
public class ResourceUtils {

    /**
     * 获取32位UUID
     *
     * @return UUID string
     */
    public static String getUUID() {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成四位数验证码
     *
     * @return 授权码
     */
    public static String makeAuthCode() {
        int authCodeNew = 0;
        authCodeNew = (int) Math.round(Math.random() * (9999 - 1000) + 1000);
        return authCodeNew + "";
    }


    public static Date stringToDate(String dateString) throws ParseException {
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       return simpleDateFormat.parse(dateString);
    }
}
