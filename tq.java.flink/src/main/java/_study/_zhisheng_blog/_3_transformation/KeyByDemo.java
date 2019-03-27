package _study._zhisheng_blog._3_transformation;

import _study._zhisheng_blog._1_data_source.SourceFromMySQL;
import _study._zhisheng_blog._1_data_source.Student;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 17:00
 */
public class KeyByDemo {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Student> student = env.addSource(new SourceFromMySQL());

        KeyedStream<Student, Integer> studentIntegerKeyedStream = student.keyBy(new KeySelector<Student, Integer>() {
            @Override
            public Integer getKey(Student value) throws Exception {
                return value.age;
            }
        });
        studentIntegerKeyedStream.print();

        env.execute("FilterDemo");


    }
}
