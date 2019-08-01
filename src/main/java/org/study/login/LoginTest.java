package org.study.login;

import org.apache.http.HttpException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.cookie.Cookie;
import org.checkerframework.common.reflection.qual.GetMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by ArnoldLee on 2019/3/13.
 */
public class LoginTest {


    public static void getImage(){

        String yzmUrl = "https://bj.122.gov.cn/m/tmri/captcha/math?nocache="+System.currentTimeMillis()+""+Math.round(Math.random()*900 + 100);
        System.out.printf("yzmUrl:%s\n",yzmUrl);


//        HttpServletRequest request = ServletActionContext.getRequest();
//        HttpServletResponse response = ServletActionContext.getResponse();
//        //初始化httpclient
//        HttpClient httpClient = new HttpClient();
//        //首先把进入山西交警官网的首页得到cookie（里面会包括token和sessionid等）；
//        String url1 = "http://sx.122.gov.cn/views/inquiry.html?q=j";
//        GetMethod getMethod1 = new GetMethod(url1);
//        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
//
//        try {
//            //执行访问页面
//            int statusCode=httpClient.executeMethod(getMethod1);
//        } catch (HttpException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // 获得登陆后的 Cookie
//        Cookie[] cookies = httpClient.getState().getCookies();
//        StringBuffer tmpcookies = new StringBuffer();
//        for (Cookie c : cookies) {
//            tmpcookies.append(c.toString() + ";");
//        }
//        //这里吧cookie存在本地session里，供查询提交数据用
//        request.getSession().setAttribute("cookie", tmpcookies.toString());
//        //给路径加后缀，避免相同路径被缓存不再请求
//        String url2 = "http://sx.122.gov.cn/captcha?t="+new Date().getTime();
//        GetMethod getMethod2 = new GetMethod(url2);
//        try {
//            int statusCode2=httpClient.executeMethod(getMethod2);
//        } catch (HttpException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //获取请求到的数据
//        byte[] responseBody = null;
//        try {
//            responseBody = getMethod2.getResponseBody();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //将请求的验证码图片用输出流方式输出
//        try {
//            OutputStream out = response.getOutputStream();
//            response.setContentType("image/jpeg");
//            response.setHeader("Content-Type","image/jpeg");
//            out.write(responseBody);
//            out.flush();
//
//            out.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }


    public static void main(String[] args) {
        getImage();
    }

}
