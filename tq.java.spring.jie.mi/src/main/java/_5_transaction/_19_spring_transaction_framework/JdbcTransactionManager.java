package _5_transaction._19_spring_transaction_framework;

import org.springframework.transaction.*;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 734070824@qq.com
 * @date 2018/4/11 11:11
 */
public class JdbcTransactionManager implements PlatformTransactionManager{

    private DataSource dataSource;

    public JdbcTransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            TransactionResourceManager.bindResource(connection);
            return new DefaultTransactionStatus(connection, true, true, false, true, null);
        } catch (SQLException e) {
            throw new CannotCreateTransactionException(" ", e);
        }
    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        Connection connection = (Connection) TransactionResourceManager.unbindResource();
        try {
            connection.commit();
        } catch (SQLException e) {
            throw  new UnexpectedRollbackException(" ", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        Connection connection = (Connection) TransactionResourceManager.unbindResource();
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw  new UnexpectedRollbackException(" ", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
