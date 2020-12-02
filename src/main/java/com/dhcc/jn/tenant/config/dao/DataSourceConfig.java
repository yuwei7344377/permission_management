package com.dhcc.jn.tenant.config.dao;

import java.beans.PropertyVetoException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;
import com.dhcc.jn.tenant.utils.DESUtil;

/**
 * 配置datasource到ioc容器里面
 *
 * @author zhanglei
 */
@Configuration
// 配置mybatis mapper的扫描路径
@MapperScan("com.dhcc.jn.tenant.dao")
public class DataSourceConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    /**
     * 生成与spring-dao.xml对应的bean dataSource
     *
     * @return druid数据源
     * @throws PropertyVetoException 可能出现的配置文件属性读取失败异常
     */
    @Bean(name = "dataSource")
    public DruidDataSource createDataSource() throws PropertyVetoException {
        // 生成datasource实例
        DruidDataSource dataSource = new DruidDataSource();
        // 跟配置文件一样设置以下信息
        // 驱动
        dataSource.setDriverClassName(jdbcDriver);
        // 数据库连接URL
        dataSource.setUrl(jdbcUrl);
        // 设置用户名
        dataSource.setUsername(DESUtil.getDecryptString(jdbcUsername));
        // 设置用户密码
        dataSource.setPassword(DESUtil.getDecryptString(jdbcPassword));
        // 连接池最大线程数
        dataSource.setMaxActive(50);
        // 连接池最小线程数
        dataSource.setMinIdle(10);
        // 初始化时建立物理连接的个数
        dataSource.setInitialSize(5);
        // 连接超时时间
        dataSource.setMaxWait(10000);
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(30000);
        // 长时间没有访问，就检测是否与数据库连接
        dataSource.setTestWhileIdle(true);
        // 用来检测连接是否有效的sql
        dataSource.setValidationQuery("SELECT 1");

        return dataSource;
    }

}
