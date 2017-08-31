package org.study.basestatic;

import com.google.common.collect.Maps;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ArnoldLee on 16/12/4.
 */
public class StaticTest {

    //存放支付的用户userId
    private  Map<String,String> sessionMap = Maps.newHashMap();


    public void changeMap(String value){
        System.out.println("第一步,userId为:"+sessionMap.get("userId"));
        sessionMap.put("userId",value);
        System.out.println("第二部,userId为:"+sessionMap.get("userId"));
    }

    public void getMap(){
        System.out.println("第三步,userId为:"+sessionMap.get("userId"));
    }
}
