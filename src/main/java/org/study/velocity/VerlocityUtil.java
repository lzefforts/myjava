package org.study.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ArnoldLee on 16/12/9.
 */
public class VerlocityUtil {


    private static VelocityEngine init(){
        //初始化引擎
        VelocityEngine vEngine = new VelocityEngine();
        vEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        vEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        vEngine.init();
        return vEngine;
    }


    public static void execObj(String templateUrl,Map<String,Object> conditions,Class beanClass,Long column){
        //读取Hellovelocity.vm这个模板生成的Template这个类
        Template template = init().getTemplate(templateUrl);//"velocity/velocityone.vm"
        VelocityContext context = new VelocityContext();

        List<OutPut> resultList = new LinkedList<OutPut>();

        Field[] fields = beanClass.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Comments.class)){
                String comments = field.getAnnotation(Comments.class).value();
                String name = field.getName();
                OutPut outPut = new OutPut();
                outPut.setComments(comments);
                outPut.setName(name);
                resultList.add(outPut);
            }
        }


        for(String key : conditions.keySet()){
            Object value = conditions.get(key);
            context.put(key,value);
        }
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
    }

    public static void execObjByTable(Integer line,Integer row){

    }

    public static class OutPut{
        private String comments;
        private String name;

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
