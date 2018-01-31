package com.ybw.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by yao on 2018/1/17
 *
 * 配置mybatis
 */
//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = "com.ybw.demo.mapper")
public class DatabaseConfig {


    /**注释说明：基础方法+优先执行+mybatis链接配置 返回链接资源池*/
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.demo")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    /**注释说明：基础方法+优先执行 建立链接池工厂*/
    @Primary
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception{
        //建立链接池工厂对象
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置链接池资源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //绑定mapper xml
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

        /**********分页插件*********/
        /*PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo","check");
        properties.setProperty("params","count=countSql");
        interceptor.setProperties(properties);
        sqlSessionFactoryBean.getObject().getConfiguration().addInterceptor(interceptor);*/
        /***********分页插件*********/

        return sqlSessionFactoryBean.getObject();
    }


    /** 建立链接事务 */
    @Bean(name = "txManager")
    public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /** 将链接池工厂放到链接模型中 */
    @Bean(name = "sqlSessionTemplateBean")
    public SqlSessionTemplate sqlSessionTemplateBean(@Qualifier("sqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
