package org.study.tsinsen;

import java.util.Scanner;

/**
 * 试题见:http://www.tsinsen.com/A1100
 * Created by ArnoldLee on 18/5/12.
 */
public class A1100 {


    public void calculate(){
        String str = this.getInput();
        String[] strArray = str.split(" ");
        


    }


    public String getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input two numbers with backspace:");
        String value = sc.nextLine();  //读取字符串型输入
        System.out.println("input is:"+value);
        return value;
    }

    public static void main(String[] args) {
        A1100 a1100 = new A1100();
        a1100.getInput();
    }


}
