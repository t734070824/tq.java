package _realize;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 734070824@qq.com
 * @date 2018/8/1 10:23
 */
public class DataSource {


    private HikariDataSource ds;

    /**
     * 初始化连接池
     * @param minimum
     * @param Maximum
     */
    public void init(int minimum,int Maximum){
        //连接池配置
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://192.168.1.82:3306/tq_demo?user=root&password=333dkx8s&serverTimezone=UTC");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 500);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.setConnectionTestQuery("SELECT 1");
        config.setAutoCommit(true);
        //池中最小空闲链接数量
        config.setMinimumIdle(minimum);
        //池中最大链接数量
        config.setMaximumPoolSize(Maximum);

        ds = new HikariDataSource(config);

    }

    /**
     * 销毁连接池
     */
    public void shutdown(){
        ds.close();
    }

    /**
     * 从连接池中获取链接
     * @return
     */
    public Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            ds.getHikariPoolMXBean().resumePool();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        DataSource ds = new DataSource();
        ds.init(10, 10);
        for (int i = 0; i < 15; i++) {
            Connection conn = ds.getConnection();
            Statement statement = null;

            int var4;
            try {
                String sqlstr = "update  user set name = '123' where id = 11";
                statement = conn.createStatement();
                int num = statement.executeUpdate(sqlstr);
                System.err.println(num);
                if (statement != null) {
                    statement.close();
                }
                var4 = num;
            } finally {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                conn.close();

            }
        }
    }


}
