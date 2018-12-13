package _scene._stock;

import org.apache.thrift.TException;

import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 17:45
 */
public class StockClientTest {

    public static void main(String[] args) throws TException, InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        StockClient2.main(null);
        StockClient.main(null);
        TimeUnit.SECONDS.sleep(10);
        StockClient2.main(null);

        System.err.println(StockClient.falseNum.get());


    }


}
