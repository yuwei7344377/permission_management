package com.dhcc.jn.tenant.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class SqlSessionFactoryConfiguration {
    // mybatis-config.xml配置文件的路径
    private static String mybatisConfigFile;

    @Value("${mybatis.config-location}")
    public void setMybatisConfigFile(String mybatisConfigFile) {
        SqlSessionFactoryConfiguration.mybatisConfigFile = mybatisConfigFile;
    }

    // mybatis mapper文件所在路径
    private static String mapperPath;

    @Value("${mybatis.mapper-locations}")
    public void setMapperPath(String mapperPath) {
        SqlSessionFactoryConfiguration.mapperPath = mapperPath;
    }

    // 实体类所在的package
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasPackage;

    @Autowired
    private DataSource dataSource;

    /**
     * 创建sqlSessionFactoryBean 实例 并且设置configtion 设置mapper 映射路径 设置datasource数据源
     *
     * @return 创建的SQL session 工厂
     * @throws IOException 读取配置文件可能抛出IO异常
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置mybatis configuration 扫描路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFile));
        // 添加mapper 扫描路径
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        // 设置dataSource
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置typeAlias 包扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactoryBean;
    }

}
