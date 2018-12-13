package _scene._stock;

import org.apache.thrift.TException;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 16:51
 */
public class StockServiceImpl implements StockService.Iface{
    @Override
    public int getStock(int sid) throws TException {
        return StockDao.getStock(sid);
    }

    @Override
    public boolean reduceStock(int sid, int reduce) throws TException {
        return StockDao.reduceStock(sid, reduce);
    }

    @Override
    public boolean setStock(int sid, int setNum) throws TException {
        return StockDao.setStock(sid, setNum);
    }
}
