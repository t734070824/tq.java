package _flink._study._zhisheng_blog._1_data_source;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 15:36
 */
public class SourceDemo {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        List<String> arr = new ArrayList<>();
        arr.add("ss1");
        arr.add("ss2");
        env.fromCollection(arr).print();
        env.execute("fromCollection");

    }
}
