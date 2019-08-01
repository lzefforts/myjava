package org.study.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ArnoldLee on 2019/3/12.
 */
public class Login {

    //String userName;
//String passWord;

    public Login(){

    }

    public void setUserName(WebDriver driver, String userName){

        WebElement username = driver.findElement(By.id("inputId"));//定位用户名输入框
        username.sendKeys(userName);//输入用户名root
    }
    public void setPassWord(WebDriver driver,String passWord){

        WebElement password = driver.findElement(By.id("inputPassword"));//定位密码输入框
        password.sendKeys(passWord);//输入密码root
    }
    public void clickLogin(WebDriver driver){
        WebElement yzm = driver.findElement(By.id("csessionid"));//验证码输入框
        yzm.click();//点击验证码输入框

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
            System.out.printf("等待刷新验证码");
        }

        WebElement loginbtn = driver.findElement(By.id("btnGryhdl"));//定位登录按钮，xpath相对路径
//xpath绝对路径
        //("html/body/div[1]/div/div/form/label[4]/input[@value='登 录']"));//("html/body/div[1]/div/div/form/label[4]/input[1]"));//
        loginbtn.click();//点击登录按钮
    }

}
