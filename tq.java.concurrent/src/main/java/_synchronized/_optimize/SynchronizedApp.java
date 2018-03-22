package _synchronized._optimize;

/**
 *  Synchronized javap
 * @author 734070824@qq.com
 * @date 2018/3/22 15:52
 */
public class SynchronizedApp {
    public synchronized void test1(){

    }
    public void test2(){
        synchronized (this){

        }
    }
}
