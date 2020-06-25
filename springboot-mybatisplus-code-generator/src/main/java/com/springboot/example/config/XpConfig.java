package com.springboot.example.config;

import lombok.Data;

@Data
public class XpConfig {
    private XpGlobalConfig global;
    private XpStrategyConfig strategy;
    private XpPackageConfig packages;
    private XpDataSourceConfig datasource;
    private XpSwitchConfig switchs;

}
