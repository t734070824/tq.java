package _4_data_access._14_jdbc_practice._jdbc_object;

import org.apache.commons.dbcp.BasicDataSource;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/10/18 15:36
 */
public class QueryWithParanetersApp {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.82:3306/tq_demo");
        dataSource.setUsername("root");
        dataSource.setPassword("333dkx8s");

        QueryWithParaneters query = new QueryWithParaneters(dataSource);
        List list = query.execute("tq");
        for (Object o : list) {

            System.err.println(o);
        }

    }
}
