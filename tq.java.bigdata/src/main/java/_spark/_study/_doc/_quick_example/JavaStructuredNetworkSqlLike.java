package _spark._study._doc._quick_example;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder;
import org.apache.spark.sql.expressions.javalang.typed;
import org.apache.spark.sql.streaming.StreamingQueryException;

/**
 * @author 734070824@qq.com
 * @date 2019/4/18 15:41
 */
public class JavaStructuredNetworkSqlLike {

    public static void main(String[] args) throws StreamingQueryException {
        SparkSession spark = SparkSession
                .builder()
                .appName("JavaStructuredNetworkSqlLike")
                .getOrCreate();

        // Create DataFrame representing the stream of input lines from connection to localhost:9999
        // streaming DataFrame with IOT device data with schema { device: string, type: string, signal: double, time: DateType }
        Dataset<Row> df = spark
                .readStream()
                .format("socket")
                .option("host", "192.168.101.184")
                .option("port", 9999)
                .load();


        // streaming Dataset with IOT device data
        Dataset<DeviceData> ds = df.as(ExpressionEncoder.javaBean(DeviceData.class));

        // Generate running word count
        Dataset<Row> wordCounts = ds.groupBy("value").count();


        // Select the devices which have signal more than 10
        df.select("device").where("signal > 10"); // using untyped APIs
        ds.filter((FilterFunction<DeviceData>) value -> value.getSignal() > 10)
                .map((MapFunction<DeviceData, String>) value -> value.getDevice(), Encoders.STRING());

        // Running count of the number of updates for each device type
        df.groupBy("deviceType").count(); // using untyped API

        // Running average signal for each device type
        ds.groupByKey((MapFunction<DeviceData, String>) value -> value.getDeviceType(), Encoders.STRING())
                .agg(typed.avg((MapFunction<DeviceData, Double>) value -> value.getSignal()));
    }
}
