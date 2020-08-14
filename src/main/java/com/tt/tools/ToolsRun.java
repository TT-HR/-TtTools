package com.tt.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.tt.tools.mapper")
public class ToolsRun {
    public static void main(String[] args) {
        SpringApplication.run(ToolsRun.class,args);
    }
}
