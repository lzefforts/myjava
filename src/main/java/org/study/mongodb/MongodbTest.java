package org.study.mongodb;

import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;

/**
 * Created by ArnoldLee on 18/6/12.
 */
public class MongodbTest {

    private static String local_host = "127.0.0.1";
    private static String local_db = "runoob";
    private static String local_collection = "test";

    private static String test_host = "192.168.188.177";
    private static String test_db = "t1";
    private static String test_collection = "t_product_detail";

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(test_host,27017);

        MongoDatabase database = mongoClient.getDatabase(test_db);
        System.out.println(database.getName());

        MongoCollection<Document> collection = database.getCollection(test_collection);
        FindIterable iterable =  collection.find();
        MongoCursor<Document> mongoCursor = iterable.iterator();
        while(mongoCursor.hasNext()){
            Document document = mongoCursor.next();
            test(document);

        }
        mongoCursor.close();

    }


    public static void test(Document input){
        List<Document> list = input.get("packageContent",List.class);
        List<Map<String,String>> results = new ArrayList<>();
        for(Document document : list){
            Set<String> sets = document.keySet();
            Map<String,String> hashMap = new HashMap<>();
            for(String key : sets){
                hashMap.put(key,document.getString(key));
            }
            results.add(hashMap);
        }
        System.out.println("###########");
        System.out.println(JSON.toJSONString(results));
        System.out.println("###########");


    }
}
