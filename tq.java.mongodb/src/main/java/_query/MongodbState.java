package _query;


import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bson.Document;

import java.lang.reflect.Modifier;

/**
 * @author 734070824@qq.com
 * @date 2018/12/26 10:21
 */
public class MongodbState {

    public static void main(String[] args) {
        String uri= "mongodb://mongodb199:60001,mongodb199:60002/?safe=TRUE;maxPoolSize=500;connectTimeoutMS=20000";
        String username = "root";
        String password = "sw3dsw2d";
        uri = uri.replace("mongodb://", String.format("mongodb://%s:%s@", username, password));
        MongoClientURI clientUri = new MongoClientURI(uri);
        MongoClient client = new MongoClient(clientUri);
        String mongoClientOptions = client.getMongoClientOptions().toString();


        System.err.println("mongoClientOptions: " + mongoClientOptions.toString());
        System.err.println("getReplicaSetStatus: " + client.getReplicaSetStatus().toString());
        Document document = client.getDatabase("admin").runCommand(new Document("serverStatus", 1));


        System.err.println(JSON.toJSONString(document));




    }
}
