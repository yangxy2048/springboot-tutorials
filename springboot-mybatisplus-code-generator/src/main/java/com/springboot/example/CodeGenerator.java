package com.springboot.example;


import com.springboot.example.executor.config.DefaultGeneratorConfig;

/**
 * 代码生成器
 */
public class CodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        DefaultGeneratorConfig gunsGeneratorConfig = new DefaultGeneratorConfig();
        gunsGeneratorConfig.doMpGeneration();


    }

}