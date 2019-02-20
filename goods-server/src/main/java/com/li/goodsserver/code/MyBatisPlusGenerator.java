package com.li.goodsserver.code;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @ClassName CodeGeneration
 * @Author lihaodong
 * @Date 2019/1/7 17:37
 * @Mail lihaodongmail@163.com
 * @Description
 * @Version 1.0
 **/

public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("/Users/lihaodong/Desktop/LiHaoDong/shop/goods-server/src/main/java");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);//生成基本的resultMap
        gc.setBaseColumnList(false);//生成基本的SQL片段
        gc.setAuthor("lihaodong");// 作者
        mpg.setGlobalConfig(gc);

        //2. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/shop");
        mpg.setDataSource(dsc);

        //3. 策略配置globalConfiguration中
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix("sys_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setSuperEntityClass("com.li.goodsserver.model");
        strategy.setInclude("sys_goods_sku"); // 需要生成的表
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        //4. 包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.li.goodsserver");
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }
}
