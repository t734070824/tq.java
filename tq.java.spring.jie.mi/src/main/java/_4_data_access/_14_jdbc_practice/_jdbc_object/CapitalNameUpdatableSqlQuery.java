package _4_data_access._14_jdbc_practice._jdbc_object;

import org.springframework.jdbc.object.UpdatableSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2018/10/18 16:38
 */
public class CapitalNameUpdatableSqlQuery extends UpdatableSqlQuery{

    public CapitalNameUpdatableSqlQuery(DataSource ds, String sql) {
        super(ds, sql);
        compile();
    }

    @Override
    protected Object updateRow(ResultSet rs, int rowNum, Map context) throws SQLException {
        String name = rs.getString("name");
        rs.updateString("name", name.toUpperCase());
        return null;
    }
}
