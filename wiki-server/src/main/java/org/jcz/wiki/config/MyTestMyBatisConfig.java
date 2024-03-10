package org.jcz.wiki.config;

import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.jcz.wiki.mapper.mytest",
        sqlSessionTemplateRef = "mytestSqlSessionTemplate")
public class MyTestMyBatisConfig {

    @Resource
    private DataSource mytestDataSource;

    @Bean(name = "mytestSqlSessionFactory")
    @Primary
    public SqlSessionFactory mytestSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mytestDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/mytest/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mytestTransactionManager")
    @Primary
    public DataSourceTransactionManager mytestTransactionManager() {
        return new DataSourceTransactionManager(mytestDataSource);
    }

    @Bean(name = "mytestSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate eqbSqlSessionTemplate(@Qualifier("mytestSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}