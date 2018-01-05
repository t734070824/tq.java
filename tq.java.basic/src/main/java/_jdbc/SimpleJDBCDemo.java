package _jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleJDBCDemo {


    public static void main(String[] args) {
        queryForList();
    }


    public static List<Map<String, Object>> queryForList(){

        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Map<String, Object>> resultList = new ArrayList<>();

        try{

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://192.168.1.82:3306/tq_demo";
            String username = "root";
            String password = "333dkx8s";

            connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from user where id = 1";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            // 处理查询结果（将查询结果转换成List<Map>格式）
            ResultSetMetaData rsmd = rs.getMetaData();
            int num = rsmd.getColumnCount();

            while(rs.next()){
                Map map = new HashMap();
                for(int i = 0;i < num;i++){
                    String columnName = rsmd.getColumnName(i+1);
                    map.put(columnName,rs.getString(columnName));
                }
                resultList.add(map);
            }

            System.err.println(resultList);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                // 关闭结果集
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                // 关闭执行
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

}
