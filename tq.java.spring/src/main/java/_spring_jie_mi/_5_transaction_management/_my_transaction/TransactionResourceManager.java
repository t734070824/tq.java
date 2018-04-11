package _spring_jie_mi._5_transaction_management._my_transaction;

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
