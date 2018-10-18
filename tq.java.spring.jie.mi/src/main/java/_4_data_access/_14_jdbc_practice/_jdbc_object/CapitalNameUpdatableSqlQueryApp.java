package _4_data_access._14_jdbc_practice._jdbc_object;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.object.UpdatableSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2018/10/18 16:38
 */
public class CapitalNameUpdatableSqlQueryApp{

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.82:3306/tq_demo");
        dataSource.setUsername("root");
        dataSource.setPassword("333dkx8s");

        String sql = "select * from user";
        CapitalNameUpdatableSqlQuery updatableSqlQuery = new CapitalNameUpdatableSqlQuery(dataSource, sql);
        updatableSqlQuery.execute();

    }
}
