package _study._zhisheng_blog._1_data_source;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 16:18
 */
public class Main3 {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        List<Student> arr = new ArrayList<>();
        arr.add(new Student(1231,"sss","123",123));

        DataStreamSource<Student> studentDataStreamSource = env.fromCollection(arr);
        studentDataStreamSource.addSink(new SinkToMySQL());
        env.execute("sink.demo");
    }
}
