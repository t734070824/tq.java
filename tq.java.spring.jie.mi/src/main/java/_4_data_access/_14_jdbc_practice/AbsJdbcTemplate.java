package _4_data_access._14_jdbc_practice;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Jdbc模板雏形
 * @author 734070824@qq.com
 * @date 2018/10/16 15:29
 */
public abstract class AbsJdbcTemplate {

    public final Object execute(String sql){
        Connection con = null;
        Statement stmt = null;
        try{
            con = getConnection();
            stmt = con.createStatement();
            Object retValue = executeWithStatement(stmt, sql);
            return retValue;
        }catch (SQLException e){
            DataAccessException ex = translateSQLException();
            throw ex;
        }finally {
            closeStatement(stmt);
            releaseConnection(con);
        }
    }

    protected abstract void releaseConnection(Connection con);

    protected abstract void closeStatement(Statement stmt);

    protected abstract DataAccessException translateSQLException();

    protected abstract Object executeWithStatement(Statement stmt, String sql);

    protected abstract Connection getConnection();
}
