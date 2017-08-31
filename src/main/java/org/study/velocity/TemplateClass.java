package org.study.velocity;

import java.util.Map;

/**
 * Created by ArnoldLee on 16/11/6.
 */
public abstract class TemplateClass {

    public abstract void a();

    public String getResult(Map<String,Object> conditions){
        if(conditions.isEmpty()){
            return "hello,world!";
        }
        return conditions.get("hello").toString();
    }

    public void b(){
        System.out.println("-----b-----");
    }
}
