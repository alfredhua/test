package com.dictionary.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "jdbc")
@Data
public class DatabaseConfig {

//    Logger logger=Logger.getLogger(DatabaseConfig.class);
    static int min_pool_size=10;
    static int max_pool_size=100;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private int maximumPoolSize;

    @Bean(name = "commonDataSource")
    public DataSource dataSource() {

        if(maximumPoolSize<min_pool_size)
        {
            maximumPoolSize=min_pool_size;
        }
        if(maximumPoolSize>max_pool_size){
            maximumPoolSize=max_pool_size;
        }

//        logger.info("---------------------");
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(maximumPoolSize);
        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
//        logger.info("-------------------------------");
//        logger.info("the mysql  url " + url);
        return ds;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("commonDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setTypeHandlersPackage("com.github.javaplugs.mybatis");
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}

