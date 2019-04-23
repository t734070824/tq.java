package _flink._study._zhisheng_blog._3_transformation;

import _flink._study._zhisheng_blog._1_data_source.SourceFromMySQL;
import _flink._study._zhisheng_blog._1_data_source.Student;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 16:50
 */
public class FilterDemo {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Student> student = env.addSource(new SourceFromMySQL());

        SingleOutputStreamOperator<Student> filter = student.filter(new FilterFunction<Student>() {
            @Override
            public boolean filter(Student value) throws Exception {
                if (value.id > 95) {
                    return true;
                }
                return false;
            }
        });
        filter.print();

        env.execute("FilterDemo");


    }
}
