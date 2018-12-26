package _query;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * mongodb 连接
 */
public class MongodbConn {
    public static void main(String[] args) {
        String uri= "mongodb://mongodb199:60001,mongodb199:60002/?safe=TRUE;maxPoolSize=500;connectTimeoutMS=20000";
        String username = "root";
        String password = "sw3dsw2d";
        uri = uri.replace("mongodb://", String.format("mongodb://%s:%s@", username, password));
        MongoClientURI clientUri = new MongoClientURI(uri);
        MongoClient client = new MongoClient(clientUri);
        System.err.println("success");
    }
}
