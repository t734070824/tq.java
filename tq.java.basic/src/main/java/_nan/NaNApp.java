package _nan;

import org.junit.Test;

/**
 * 存在使 i > j || i <= j 不成立
 * @author 734070824@qq.com
 * @date 2018/4/4 15:18
 */
public class NaNApp {

    @Test
    public void NoN_FLoat(){
        float i = Float.NaN;
        float j = Float.NaN;
        System.err.println(i > j || i <= j);
    }


    @Test
    public void NoN_Double(){
        double i = Double.NaN;
        double j = Double.NaN;
        System.err.println(i > j || i <= j);
    }
}
