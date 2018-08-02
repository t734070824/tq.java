package _jdk7_new._autoclose_try;

/**
 * @author 734070824@qq.com
 * @date 2018/8/1 11:43
 */
public class Resource implements AutoCloseable{



    @Override
    public void close() {
        System.err.println("close");
    }

    public void get() throws Exception{
        System.err.println("get");
    }
}
