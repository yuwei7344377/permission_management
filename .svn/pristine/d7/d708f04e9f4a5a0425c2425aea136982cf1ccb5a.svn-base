package com.dhcc.jn.tenant.utils;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.util.Base64;

/**
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。
 *
 * @author zhanglei
 */
public class DESUtil {

    private static Key key;
    // 设置密钥key
    private static String KEY_STR = "dcs_secret";
    private static String CHARSET = "UTF-8";
    private static String ALGORITHM = "DES";

    static {
        try {
            // 生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            // 运用SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            // 设置上密钥种子
            secureRandom.setSeed(KEY_STR.getBytes());
            // 初始化基于SHA1的算法对象
            generator.init(secureRandom);
            // 生成密钥对象
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取加密后的信息
     *
     * @param str 要加密的明文
     * @return 加密后的密文
     */
    public static String getEncryptString(String str) {
        // 基于BASE64编码，接收byte[]并转换成String
        try {
            // 按UTF8编码
            byte[] bytes = str.getBytes(CHARSET);
            // 获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密
            byte[] doFinal = cipher.doFinal(bytes);
            // byte[]to encode好的String并返回
            return Base64.getEncoder().encodeToString(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取解密之后的信息
     *
     * @param str 要解密的密文
     * @return 解密后的明文
     */
    public static String getDecryptString(String str) {
        // 基于BASE64编码，接收byte[]并转换成String
        try {
            // 将字符串decode成byte[]
            byte[] bytes = Base64.getDecoder().decode(str);
            // 获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化解密信息
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 解密
            byte[] doFinal = cipher.doFinal(bytes);
            // 返回解密之后的信息
            return new String(doFinal, CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getEncryptString("root"));
        System.out.println(getEncryptString("yanyuqi"));
        //System.out.println(getEncryptString("!@34qwer"));
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //System.out.println(encoder.encode("123"));
        //System.out.println(encoder.encode("front_wks_end_zl"));
        //System.out.println(getDecryptString("SgHOVZW6ipk="));
       // System.out.println(getDecryptString("a+Ho9Pzue6fZaltFdHuSMQ=="));
    }

}
