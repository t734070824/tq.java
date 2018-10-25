package _5_transaction._20_spring_transaction_manage;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

/**
 * @author 734070824@qq.com
 * @date 2018/4/16 14:53
 */
public class PrototypeTransactionInterceptor implements MethodInterceptor{

    private PlatformTransactionManager transactionManager;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        TransactionDefinition definition = getTransactionDefinitionByMethod(method);
        TransactionStatus txStatus = transactionManager.getTransaction(definition);
        Object result = null;

        try{
            result = invocation.proceed();

        } catch (Throwable e){
            if(needRollbackOn(e)){
                transactionManager.rollback(txStatus);
            }else {
                transactionManager.commit(txStatus);
            }
            throw  e;
        }

        transactionManager.commit(txStatus);
        return result;
    }

    private boolean needRollbackOn(Throwable e) {
        return false;
    }

    private TransactionDefinition getTransactionDefinitionByMethod(Method method) {
        //TODO 实现细节
        return null;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
