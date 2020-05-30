package com.example.boot_edition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = { "com.example.boot_edition"})
//排除DataSource自动配置类,否则会默认自动配置,不会使用我们自定义的DataSource,并且启动报错
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.boot_edition.mapper")
//@SpringBootApplication
public class BootEditionApplication{

    public static void main(String[] args) {
        SpringApplication.run(BootEditionApplication.class, args);
    }

}
