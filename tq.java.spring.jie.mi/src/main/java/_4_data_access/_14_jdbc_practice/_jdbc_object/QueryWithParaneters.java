package _4_data_access._14_jdbc_practice._jdbc_object;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

/**
 * @author 734070824@qq.com
 * @date 2018/10/18 15:14
 */
public class QueryWithParaneters extends MappingSqlQueryWithParameters{

    private static final String QUERY_SQL = "select * from `user` where name = ?";

    public QueryWithParaneters(DataSource ds) {
        super(ds, QUERY_SQL);
        declareParameter(new SqlParameter(VARCHAR));
        compile();
    }

    @Override
    protected Object mapRow(ResultSet rs, int rowNum, Object[] parameters, Map context) throws SQLException {
        User user =  new User();
        user.id = rs.getInt(1);
        user.name = rs.getString(2);
        user.password = rs.getString(3);
        user.age = rs.getInt(4);
        user.deleteFlag = rs.getInt(5);
        return user;
    }
}
