package com.ybw.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.ybw.demo.enums.DBType;
import com.ybw.demo.exception.ReadWriteDataSourceTransactionException;
import com.ybw.demo.utils.holder.DataSourceHolder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Created by yao on 2018/1/29
 * mybatis读写分离配置
 * 配置文件声明 mapper文件位置
 */

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.ybw.demo.mapper")
public class ReadOrWriteDatabaseConfig {

    /**读库资源池设置*/
    @Bean(name = "readDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.read")
    public DataSource readDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    /**写库资源池设置*/
    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.write")
    public DataSource writeDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    /**设置链接资源池工厂*/
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        try {
            //实例化工厂对象
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            //设置链接池
            sqlSessionFactoryBean.setDataSource(roundRobinDataSourceProxy());
            //绑定mapper xml
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));


            return sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            return null;
        }
    }

    /**设置读、写资源池*/
    @Bean(name="roundRobinDataSourceProxy")
    public AbstractRoutingDataSource roundRobinDataSourceProxy(){

        Map<Object,Object> dataSources = new HashMap<>();
        //将读、写资源池写入集合
        dataSources.put(DBType.READ.getType(),readDataSource());
        dataSources.put(DBType.WRITE.getType(),writeDataSource());
        //设置读库数量
        final int readSize = Integer.parseInt("1");
        //建立链接池资源
        AbstractRoutingDataSource proxy = new AbstractRoutingDataSource() {

            private AtomicInteger count = new AtomicInteger(0);

            @Override
            protected Object determineCurrentLookupKey() {
                String key = DataSourceHolder.getReadOrWrite();
                if(key==null){
                    throw new ReadWriteDataSourceTransactionException("",null);
                }
                if(key.equals(DBType.WRITE.getType())){
                    return DBType.WRITE.getType();
                }
                int number = count.getAndAdd(1);
                int lookupKey = number % readSize;

                return DBType.READ.getType()+(lookupKey+1);
            }
        };
        //默认访问数据库
        proxy.setDefaultTargetDataSource(readDataSource());//默认库
        //设置资源池
        proxy.setTargetDataSources(dataSources);

        return proxy;
    }
    //工厂模型管理
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //事务管理
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(roundRobinDataSourceProxy());
    }


}
