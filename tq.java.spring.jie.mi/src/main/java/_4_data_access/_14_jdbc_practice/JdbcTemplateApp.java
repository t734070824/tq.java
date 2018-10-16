package _4_data_access._14_jdbc_practice;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 具体使用示例
 * @author 734070824@qq.com
 * @date 2018/10/16 20:16
 */
public class JdbcTemplateApp {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.82:3306/tq_demo");
        dataSource.setUsername("root");
        dataSource.setPassword("333dkx8s");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int i = jdbcTemplate.queryForInt("SELECT id FROM user where name = 'tq'");
        System.err.println(i);
    }
}
