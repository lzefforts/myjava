package org.study.httpClient;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by ArnoldLee on 18/6/12.
 */
public class HttpClientTest {

    public static void httpGet(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(response.getEntity()));


    }

    public static void enableSSL(){


    }



    public static void test() throws IOException {


    }


    public static void main(String[] args) {
        String url = "https://www.huxiu.com";
        httpGet(url);


    }
}
