package _blog_720ui_com._2_data;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 其他创建 dataSource 的方式
 * @author 734070824@qq.com
 * @date 2019/2/20 15:31
 */
//@Configuration
//@EnableTransactionManagement
//@PropertySource(value = {"classpath:config/source.properties"})
public class BeanConfig {

//    @Autowired
//    private Environment env;
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource(){
//
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(env.getProperty("source.driverClassName").trim());
//        dataSource.setUrl(env.getProperty("source.url").trim());
//        dataSource.setUsername(env.getProperty("source.username").trim());
//        dataSource.setPassword(env.getProperty("source.password").trim());
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource());
//        return jdbcTemplate;
//    }

}
