package _5_transaction._19_spring_transaction_framework;

import java.sql.Connection;

/**
 * @author 734070824@qq.com
 * @date 2018/4/11 11:18
 */
public class FooJdbcDao implements  IDao{
    @Override
    public void daDataAccess() {
        // daDataAccess
        Connection conn = (Connection) TransactionResourceManager.getResource();

    }
}
