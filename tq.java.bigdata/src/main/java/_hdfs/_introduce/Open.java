package _hdfs._introduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * @author 734070824@qq.com
 * @date 2018/8/28 17:20
 */
public class Open {

    public static void main(String[] args) throws IOException {
        System.setProperty("HADOOP_USER_NAME", "tangqing");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.101.203:8022");
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
        FileSystem fs = FileSystem.get(conf);
        fs.mkdirs(new Path("/tq/hdfs"));
        System.err.println(fs);
    }
}
