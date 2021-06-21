package com.hry.component.mybatisplus.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * 代码生成器
 * @author: huangrongyou@yixin.im
 * @date: 2021/5/27 10:47
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码路径
        String codeDir = "D:\\tmp\\src";
        // 包路径
        String parentPackage = "im.yixin.simu.client.ipasssimu";
        // 指定表名（可以同时操作多个表，使用 , 隔开）（需要修改）
        String[] tables = new String[]{"group_config","dev_online","dev_data", "dev_last_info"};

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // String projectPath = System.getProperty("user.dir");
        // 填写代码生成的目录(需要修改)
        String projectPath = codeDir;
        // 拼接出代码最终输出的目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 配置开发者信息（可选）（需要修改）
        gc.setAuthor("hry");
        // 配置是否打开目录，false 为不打开（可选）
        gc.setOpen(false);
        // 实体属性 Swagger2 注解，添加 Swagger 依赖，开启 Swagger2 模式（可选）
        //gc.setSwagger2(true);
        // 重新生成文件时是否覆盖，false 表示不覆盖（可选）
        gc.setFileOverride(false);
        // 配置主键生成策略，此处为 ASSIGN_ID（可选）
        gc.setIdType(IdType.ASSIGN_ID);
        // 配置日期类型，此处为 ONLY_DATE（可选）
        gc.setDateType(DateType.ONLY_DATE);

        // 设置名字：名称必须有 %s 需要做为占位符
        gc.setControllerName("%sCtl");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setEntityName("%sModel");
        // 设置 resultMap
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);



        // 包配置
        PackageConfig pc = new PackageConfig();
        // 配置父包名（需要修改）
        pc.setParent(parentPackage);
        // 配置模块名（需要修改）
        // pc.setModuleName("test_mybatis_plus");
        // 配置 entity 包名
        pc.setEntity("model");
        // 配置 mapper 包名
        pc.setMapper("mapper");
        // 配置 service 包名
        pc.setService("service");
        // 配置 controller 包名
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 指定表名（可以同时操作多个表，使用 , 隔开）（需要修改）
        strategy.setInclude(tables);

        // strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 配置数据表与实体类名之间映射的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 配置数据表的字段与实体类的属性名之间映射的策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        //  一般表以上的配置就可以，但是 以上的配置里 log_202105 会输出 Log202105开头的类，如 Log202105ServiceImpl。 不符合要求，这里使用自定义
        // 通过INameConvert 自定义表名 或 字段名称： 这个配置同时会覆盖 setNaming() 和 setColumnNaming() 里的设置
//        strategy.setNameConvert(new INameConvert() {
//            @Override
//            public String entityNameConvert(TableInfo tableInfo) {
//                return "Log";
//            }
//
//            @Override
//            public String propertyNameConvert(TableField field) {
//                String name = field.getColumnName();
//                // 快速检查
//                if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(name)) {
//                    // 没必要转换
//                    return StringPool.EMPTY;
//                }
//                String tempName = name;
//                // 大写数字下划线组成转为小写 , 允许混合模式转为小写
//                if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isCapitalMode(name) || com.baomidou.mybatisplus.core.toolkit.StringUtils.isMixedMode(name)) {
//                    tempName = name.toLowerCase();
//                }
//                StringBuilder result = new StringBuilder();
//                // 用下划线将原始字符串分割
//                String[] camels = tempName.split(ConstVal.UNDERLINE);
//                // 跳过原始字符串中开头、结尾的下换线或双重下划线
//                // 处理真正的驼峰片段
//                Arrays.stream(camels).filter(camel -> !com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(camel)).forEach(camel -> {
//                    if (result.length() == 0) {
//                        // 第一个驼峰片段，全部字母都小写
//                        result.append(camel.toLowerCase());
//                    } else {
//                        // 其他的驼峰片段，首字母大写
//                        result.append(capitalFirst(camel));
//                    }
//                });
//                return result.toString();
//            }
//        });
        // 配置 lombok 模式
        strategy.setEntityLombokModel(false);
        // 配置 rest 风格的控制器（@RestController）
        strategy.setRestControllerStyle(true);
        // 配置驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 配置表前缀，生成实体时去除表前缀
        // 此处的表名为 test_mybatis_plus_user，模块名为 test_mybatis_plus，去除前缀后剩下为 user。
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        mpg.setTemplateEngine(new VelocityTemplateEngine());

//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        // 如果模板引擎是 velocity
//        String templatePath = "/templates/mapper.xml.vm";
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/" + pc + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);



        // 执行输出
        mpg.execute();
    }



    /**
     * 实体首字母大写
     *
     * @param name 待转换的字符串
     * @return 转换后的字符串
     */
    public static String capitalFirst(String name) {
        if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(name)) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return StringPool.EMPTY;
    }

}