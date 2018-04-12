package _transaction_manager_advanced_application;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 734070824@qq.com
 * @date 2018/4/12 11:00
 */
@Service("service1")
public class UserJdbcWithoutTransManagerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName,int toAdd){
        String sql = "UPDATE user u SET u.age = u.age + ? WHERE name =?";
        jdbcTemplate.update(sql,toAdd,userName);
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("_transaction_manager_advanced_application/jdbcWithoutTransManager.xml");
        UserJdbcWithoutTransManagerService service =
                (UserJdbcWithoutTransManagerService)ctx.getBean("service1");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        BasicDataSource basicDataSource = (BasicDataSource)jdbcTemplate.getDataSource();

        //①.检查数据源autoCommit的设置
        System.out.println("autoCommit:"+ basicDataSource.getDefaultAutoCommit());

        //②.插入一条记录，初始分数为10
        jdbcTemplate.execute(
                "INSERT INTO user(id, name,password,age) VALUES(3, 'tom','123456',10)");

        //③.调用工作在无事务环境下的服务类方法,将分数添加20分
        service.addScore("tom",20);

        //④.查看此时用户的分数
        int score = jdbcTemplate.queryForObject("SELECT age FROM user WHERE name = ? ", Integer.class, "tom");
        System.out.println("score:"+score);
        jdbcTemplate.execute("DELETE FROM user WHERE name='tom'");
    }
}