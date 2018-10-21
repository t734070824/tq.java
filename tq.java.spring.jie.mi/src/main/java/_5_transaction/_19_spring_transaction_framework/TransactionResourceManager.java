package _5_transaction._19_spring_transaction_framework;

/**
 * 事务连接资源
 * @author 734070824@qq.com
 * @date 2018/4/11 11:08
 */
public class TransactionResourceManager {

    private static ThreadLocal resources = new ThreadLocal();

    public static Object getResource(){
        return  resources.get();
    }

    public static void bindResource(Object resource){
        resources.set(resource);
    }

    public static Object unbindResource(){
        final Object resource = getResource();
        resources.set(null);
        return  resource;
    }
}
