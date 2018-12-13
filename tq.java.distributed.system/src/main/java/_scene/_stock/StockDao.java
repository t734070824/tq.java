package _scene._stock;

import org.apache.thrift.TException;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 16:52
 */
public class StockDao {

    protected static StockVo vo = new StockVo(1, 1000);

    public static int getStock(int sid) {
        return vo.getNum();
    }

    public static boolean reduceStock(int sid, int reduce) {
        vo.setNum(vo.getNum()-reduce);
        return true;
    }

    public static boolean setStock(int sid, int setNum)  {
        vo.setNum(setNum);
        return true;
    }
}
