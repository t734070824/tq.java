package _scene._stock;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 16:55
 */
public class StockVo {

    private int sid;

    private int num;

    public StockVo(int sid, int num) {
        this.sid = sid;
        this.num = num;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
