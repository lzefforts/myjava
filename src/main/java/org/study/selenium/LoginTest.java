package org.study.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ArnoldLee on 2019/3/12.
 */
public class LoginTest {


    public static void login() {
        //如果火狐浏览器没有默认安装在C盘，需要制定其路径  
//        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla firefox\\firefox.exe");
        //System.setProperty("webdriver.firefox.marionette","D:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://szv.122.gov.cn/m/login");//根据URL转到相应的地址
        driver.manage().window().maximize();//浏览器窗口最大化 
         /*
         * 登录功能
         * 
         */
        Login login = new Login();

//        //重置输入框
//        login.setUserName(driver, "root");
//        login.setPassWord(driver, "root");
//        login.clickCancel(driver);

        //正确的用户名root和正确的密码root，登录系统
        login.setUserName(driver, "root");
        login.setPassWord(driver, "root");
        login.clickLogin(driver);

         /* 固定等待时间
        //Thread.sleep(5000);//设置固定的等待时间，仅写这一行代码，需要在main后跟上throws InterruptedException
         * */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
            System.out.printf("登录成功，首页获取元素失败");
        }

        //隐十等待方式,设置脚本在查找元素时的最大等待时间

        //显示等待

//        driver.quit();//关闭浏览器

    }

    public static void main(String[] args) {
        login();
    }


}
