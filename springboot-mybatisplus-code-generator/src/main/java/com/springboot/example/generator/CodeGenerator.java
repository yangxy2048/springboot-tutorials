package com.springboot.example.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;

/**
 *  mybatis-plus代码自定生产
 *
 * @author DevinYang
 * @createTime 2020-06-17
 */
public class CodeGenerator {
    //项目路径
    private static final String BASE_PROJECT_PATH = "/Users/devinyang/Downloads/code/merchantaccount";
    //包名
    private static final String BASE_PACKAGE = "com.yy.paymentacceptance.merchantaccount";
    //作者名称
    private static final String AUTHOR_NAME ="DevinYang";
    //要生成的表名
    private static final String[] TABLES = {"city"};
    //表前缀
    private static final String[] PREFIX ={};


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(BASE_PROJECT_PATH);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);//不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);//XML二级缓存
        gc.setBaseResultMap(true);//XML ResultMap
        gc.setBaseColumnList(true);//XML columList
        gc.setAuthor(AUTHOR_NAME);//作者

        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/MerchantAccount?serverTimezone=GMT%2B8");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(PREFIX);//此处可以修改您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);//表名生成策略
        strategy.setInclude(TABLES);//需要生成的表

        strategy.setSuperServiceClass("");
        strategy.setSuperServiceImplClass("");
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(BASE_PACKAGE);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        //执行生成
        mpg.execute();
    }
}
