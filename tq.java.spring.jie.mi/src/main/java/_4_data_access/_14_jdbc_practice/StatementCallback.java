package _4_data_access._14_jdbc_practice;

import java.sql.Statement;

/**
 * callback接口
 * @author 734070824@qq.com
 * @date 2018/10/16 19:26
 */
public interface StatementCallback {
    Object doWithStatement(Statement stmt);
}
