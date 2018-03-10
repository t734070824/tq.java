package _producer_consumer._bank;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 服务队列
 * @author 734070824@qq.com
 * @date 2018/3/10 11:00
 */
public class ConsumerLine extends ArrayBlockingQueue<Consumer> {

    private static final long serialVersionUID = 4158592581752985923L;
    public ConsumerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if(this.size() == 0) return "[Emtry]";
        StringBuilder sb = new StringBuilder();
        for(Consumer c : this){
            sb.append(c).append(",");
        }
        return sb.toString();
    }
}
