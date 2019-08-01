package org.study.snowFlake;

/**
 * Created by ArnoldLee on 18/11/8.
 */
public class IdGeneratorTest {


    public static void main(String[] args) {
//        String url = "http://192.168.188.105:8084";
//        CachedIdGenerator idGenerator = new CachedIdGenerator(url,"test");
//        long id = idGenerator.getUID();
//        System.out.println(id);

        String os = System.getProperty("os.name");
        System.out.println(os);
    }
}
