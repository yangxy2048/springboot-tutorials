package com.springboot.example.executor.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.List;

/**
 * 描述信息
 *
 * @author DevinYang
 * @createTime 2020-06-19
 */
public abstract class AbstractGeneratorConfig {
    /**
     * 配置信息
     *
     * @create: 2020/6/25
     */
    GlobalConfig globalConfig = new GlobalConfig();
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    StrategyConfig strategyConfig = new StrategyConfig();
    PackageConfig packageConfig = new PackageConfig();

    //配置信息
    protected abstract void config();

    public AbstractGeneratorConfig() {
    }

    public void doMpGeneration() {
        //配置设置（yml文件中）
        config();

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);


        autoGenerator.execute();

    }


}
