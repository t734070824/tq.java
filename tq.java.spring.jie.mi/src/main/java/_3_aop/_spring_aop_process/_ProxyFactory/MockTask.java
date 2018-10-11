package _3_aop._spring_aop_process._ProxyFactory;

/**
 * @author 734070824@qq.com
 * @date 2018/10/11 19:41
 */
public class MockTask implements ITask{
    @Override
    public void execute() {
        System.err.println("task executor");
    }
}
