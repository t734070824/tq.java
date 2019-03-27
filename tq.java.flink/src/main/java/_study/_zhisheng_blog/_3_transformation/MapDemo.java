package _study._zhisheng_blog._3_transformation;

import _study._zhisheng_blog._1_data_source.SourceFromMySQL;
import _study._zhisheng_blog._1_data_source.Student;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 16:28
 */
public class MapDemo {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Student> studentDataStreamSource = env.addSource(new SourceFromMySQL());
        SingleOutputStreamOperator<Student> map = studentDataStreamSource.map(new MapFunction<Student, Student>() {
            @Override
            public Student map(Student value) throws Exception {
                Student s1 = new Student();
                s1.id = value.id;
                s1.name = value.name;
                s1.password = value.password;
                s1.age = value.age + 5;
                return s1;
            }
        });
        map.print();
        env.execute("map demo");
    }
}
