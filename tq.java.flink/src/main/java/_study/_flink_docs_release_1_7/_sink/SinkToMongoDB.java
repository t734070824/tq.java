package _study._flink_docs_release_1_7._sink;

import _study._flink_docs_release_1_7._data_source.Student;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * @author 734070824@qq.com
 * @date 2019/3/26 17:58
 */
public class SinkToMongoDB extends RichSourceFunction<Student> {

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);


    }

    @Override
    public void run(SourceContext<Student> ctx) throws Exception {

    }

    @Override
    public void cancel() {

    }
}
