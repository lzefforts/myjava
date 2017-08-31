package org.study.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ArnoldLee on 16/11/6.
 */
public class VelocityTwo {

    public static String defaultWorkSpace = "/Users/ArnoldLee/Downloads/intellj-workspace";
    public static String projectPath = "/myjava/src/main/java";
    public static String destUrl = "/org/study/velocity/output/TemplateClassTest.java";

    public static String getProjectPath(boolean flag){
        if(flag) return projectPath;
        return "/zma-trade-service/src/test/java/cn/creditease/zma/trade/batch";
    }



    public static void main(String[] args){
        //初始化引擎
        VelocityEngine vEngine = new VelocityEngine();
        vEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        vEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        vEngine.init();
        //读取Hellovelocity.vm这个模板生成的Template这个类
        Template template = vEngine.getTemplate("velocity/velocitytwo.vm");
        VelocityContext context = new VelocityContext();

        Method[] methods = TemplateClass.class.getDeclaredMethods();
        context.put("classNameUpCase","TemplateClass");
        context.put("classNameLowCase","templateClass");

        List<String> methodList = new ArrayList<String>();
        for(Method method : methods){
            String methodName = method.getName();
            methodList.add(methodName);
        }
        context.put("methods",methodList);
        //VelocityTwo.class.getClassLoader().getResource("").getPath();
        //System.out.println(rootPath);
        merge(template,context,defaultWorkSpace+projectPath+destUrl);

    }

    private static void merge(Template template, VelocityContext ctx, String path) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
