package com.springboot.example.executor.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.springboot.example.config.*;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

/**
 * 描述信息
 *
 * @author DevinYang
 * @createTime 2020-06-19
 */
public class DefaultGeneratorConfig extends AbstractGeneratorConfig {
    private static final String SPLIT_CHAR = ",";

    @Override
    protected void config() {
        Yaml yaml = new Yaml();
        XpConfig ret = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("generator.yml"),XpConfig.class);

        /**
         * 数据库配置
         */
        XpDataSourceConfig dsConfig = ret.getDatasource();
        //默认mysql
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName(StringUtils.defaultString(dsConfig.getDriverName(),"com.mysql.jdbc.Driver"));
        dataSourceConfig.setUrl(dsConfig.getUrl());
        dataSourceConfig.setUsername(dsConfig.getUserName());
        dataSourceConfig.setPassword(dsConfig.getPassword());

        /**
         * 全局配置
         */
        XpGlobalConfig xpGlobalConfig = ret.getGlobal();
        globalConfig.setOutputDir(xpGlobalConfig.getOutputDir());
        globalConfig.setFileOverride(xpGlobalConfig.isFileOverride());
        globalConfig.setOpen(xpGlobalConfig.isOpen());
        globalConfig.setEnableCache(xpGlobalConfig.isEnableCache());
        globalConfig.setBaseResultMap(xpGlobalConfig.isBaseResultMap());
        globalConfig.setBaseColumnList(xpGlobalConfig.isBaseColumnList());
        globalConfig.setAuthor(xpGlobalConfig.getAuthor());
        globalConfig.setActiveRecord(xpGlobalConfig.isActiveRecord());
        globalConfig.setControllerName(xpGlobalConfig.getControllerName());
        globalConfig.setServiceName(xpGlobalConfig.getServiceName());
        globalConfig.setServiceImplName(xpGlobalConfig.getServiceImplName());
        globalConfig.setMapperName(xpGlobalConfig.getMapperName());
        globalConfig.setXmlName(xpGlobalConfig.getXmlName());
        globalConfig.setIdType(IdType.AUTO);


        /**
         * 包配置
         */
        XpPackageConfig xpPackageConfig = ret.getPackages();
        packageConfig.setParent(xpPackageConfig.getParent());
        packageConfig.setModuleName(xpPackageConfig.getModuleName());
        packageConfig.setController(xpPackageConfig.getController());
        packageConfig.setEntity(xpPackageConfig.getEntity());
        packageConfig.setMapper(xpPackageConfig.getMapper());
        packageConfig.setService(xpPackageConfig.getService());
        packageConfig.setServiceImpl(xpPackageConfig.getServiceImpl());
        packageConfig.setXml(xpPackageConfig.getXml());



        /**
         * 生成策略
         */
        XpStrategyConfig xpStrategyConfig = ret.getStrategy();
        strategyConfig.setCapitalMode(xpStrategyConfig.isCapitalMode());
        strategyConfig.setSkipView(xpStrategyConfig.isSkipView());
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getNaming())){
            strategyConfig.setNaming(NamingStrategy.valueOf(xpStrategyConfig.getNaming()));
        }
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getColumnNaming())){
            strategyConfig.setColumnNaming(NamingStrategy.valueOf(xpStrategyConfig.getColumnNaming()));
        }
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getTablePrefix())) {
            strategyConfig.setTablePrefix(xpStrategyConfig.getTablePrefix().split(SPLIT_CHAR));
        }
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getFieldPrefix())) {
            strategyConfig.setFieldPrefix(xpStrategyConfig.getFieldPrefix().split(SPLIT_CHAR));
        }
        strategyConfig.setSuperEntityClass(xpStrategyConfig.getSuperEntityClass());
        strategyConfig.setSuperEntityClass(xpStrategyConfig.getSuperEntityClass());
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getSuperEntityColumns())) {
            strategyConfig.setSuperEntityColumns(xpStrategyConfig.getSuperEntityColumns().split(SPLIT_CHAR));
        }
        strategyConfig.setSuperMapperClass(xpStrategyConfig.getSuperMapperClass());
        strategyConfig.setSuperServiceClass(xpStrategyConfig.getSuperServiceClass());
        strategyConfig.setSuperServiceImplClass(xpStrategyConfig.getSuperServiceImplClass());
        strategyConfig.setSuperControllerClass(xpStrategyConfig.getSuperControllerClass());
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getInclude())){
            strategyConfig.setInclude(xpStrategyConfig.getInclude().split(SPLIT_CHAR));
        }
        if (StringUtils.isNoneEmpty(xpStrategyConfig.getExclude())){
            strategyConfig.setExclude(xpStrategyConfig.getInclude().split(SPLIT_CHAR));
        }
        strategyConfig.setEntityColumnConstant(xpStrategyConfig.isEntityColumnConstant());
        strategyConfig.setEntityBuilderModel(xpStrategyConfig.isEntityBuilderModel());
        strategyConfig.setEntityLombokModel(xpStrategyConfig.isEntityLombokModel());
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(xpStrategyConfig.isEntityBooleanColumnRemoveIsPrefix());
        strategyConfig.setRestControllerStyle(xpStrategyConfig.isRestControllerStyle());
        strategyConfig.setControllerMappingHyphenStyle(xpStrategyConfig.isControllerMappingHyphenStyle());
        strategyConfig.setEntityTableFieldAnnotationEnable(xpStrategyConfig.isEntityTableFieldAnnotationEnable());
        strategyConfig.setVersionFieldName(xpStrategyConfig.getVersionFieldName());
        strategyConfig.setLogicDeleteFieldName(xpStrategyConfig.getLogicDeleteFieldName());

    }
}
