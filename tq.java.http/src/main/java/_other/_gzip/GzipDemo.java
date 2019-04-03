package _other._gzip;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author 734070824@qq.com
 * @date 2019/4/3 15:37
 */
public class GzipDemo {

    public static void main(String[] args) throws IOException {
        String str = "[{p1:\"12_22_235\",pu:\"1\",v:\"1.0.1\",net_work:\" \",ua_model:\" \",os_v:\"\",t:\"1\",rpage:\"1\",tm_1:2,tm_2:2,tm_3:2,tm_4:2,tm_5:2,rload:2},"
                + "{p1:\"2_22_235\",pu:\"1\",v:\"1.0.1\",net_work:\" \",ua_model:\" \",os_v:\"\",t:\"1\",rpage:\"1\",tm_1:2,tm_2:2,tm_3:2,tm_4:2,tm_5:2,rload:2},"
                + "{p1:\"2_22_235\",pu:\"1\",v:\"1.0.1\",net_work:\" \",ua_model:\" \",os_v:\"\",t:\"1\",rpage:\"1\",tm_1:2,tm_2:2,tm_3:2,tm_4:2,tm_5:2,rload:2}]";

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost method = new HttpPost("http://localhost:8080/asda/api/sd?123");
        method.addHeader("Content-type","application/json");
//        method.setHeader("Content-Encoding", "gzip");
//        method.setEntity(new StringEntity(GzipUtils.compress(str), Charset.forName("UTF-8")));

//        method.setHeader("Content-Encoding", "gzip");
        method.setEntity(new StringEntity(str, Charset.forName("UTF-8")));

        HttpResponse response = httpClient.execute(method);

        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("error...");
        }

        // Read the response body
        String body = EntityUtils.toString(response.getEntity());


        System.out.println(body);

    }
}
