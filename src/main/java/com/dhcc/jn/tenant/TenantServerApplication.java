package com.dhcc.jn.tenant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dhcc.jn.tenant.dao")
public class TenantServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenantServerApplication.class, args);
    }

}
