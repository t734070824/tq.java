package _study._zhisheng_blog._3_transformation;

import _study._zhisheng_blog._1_data_source.SourceFromMySQL;
import _study._zhisheng_blog._1_data_source.Student;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 16:34
 */
public class FlatMapDemo {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Student> studentDataStreamSource = env.addSource(new SourceFromMySQL());

        SingleOutputStreamOperator<Student> studentSingleOutputStreamOperator =
                studentDataStreamSource.flatMap(new FlatMapFunction<Student, Student>() {
            @Override
            public void flatMap(Student value, Collector<Student> out) throws Exception {
                if (value.id % 2 == 0) {
                    out.collect(value);
                    System.err.println("out:" + out);
                }
            }
        });

        studentSingleOutputStreamOperator.print();

        env.execute("FlatMapDemo");


    }
}
