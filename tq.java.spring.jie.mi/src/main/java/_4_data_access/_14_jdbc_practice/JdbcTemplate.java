package _4_data_access._14_jdbc_practice;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 借助 callBack接口
 * @author 734070824@qq.com
 * @date 2018/10/16 19:26
 */
public class JdbcTemplate {

    public final Object execute(StatementCallback callback){
        Connection con = null;
        Statement stmt = null;
        try{
            con = getConnection();
            stmt = con.createStatement();
            Object retValue = callback.doWithStatement(stmt);
            return retValue;
        }catch (SQLException e){
            DataAccessException ex = translateSQLException(e);
            throw ex;
        }finally {
            closeStatement(stmt);
            releaseConnection(con);
        }
    }

    private void closeStatement(Statement stmt){

    }

    private void releaseConnection(Connection con) {
    }

    private DataAccessException translateSQLException(SQLException e) {
        return null;
    }

    private Connection getConnection() {
        return null;
    }
}
