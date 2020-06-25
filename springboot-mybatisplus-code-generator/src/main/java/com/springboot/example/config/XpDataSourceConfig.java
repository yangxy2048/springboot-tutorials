package com.springboot.example.config;

import lombok.Data;

/**
 * 数据源配置
 */
@Data
public class XpDataSourceConfig {
    /**
     * 数据库信息查询
     */
    private String dbQuery;
    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * PostgreSQL schemaname
     */
    private String schemaname = "public";

    /**
     * 驱动连接的URL
     */
    private String url;
    /**
     * 驱动名称
     */
    private String driverName;
    /**
     * 数据库连接用户名
     */
    private String userName;
    /**
     * 数据库连接密码
     */
    private String password;


}
