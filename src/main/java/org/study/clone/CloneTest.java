package org.study.clone;

import java.time.LocalDate;

/**
 * 拷贝\浅克隆\深克隆
 * @author ArnoldLee
 * @date 18/6/5
 */
public class CloneTest {


    public static void copy(){
        System.out.println("#############拷贝#############");
        User user = new User("tom","男",21, LocalDate.now(), new Card("1111"));
        User newUser = user;
        newUser.setAge(30);
        System.out.println("newUser.age:"+newUser.getAge());
        System.out.println("user.age:"+user.getAge());

    }


    public static void shallowClone(){
        System.out.println("#############浅克隆#############");
        Info info = new Info("a.jpg");
        User user = new User("tom","男",21, LocalDate.now(),info);
        User newUser = null;
        try {
            newUser = user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        newUser.setAge(30);
        newUser.info.setImageInfo("b.jpg");

        System.out.println("newUser.age:"+newUser.getAge());
        System.out.println("newUser.info:"+newUser.info.getImageInfo());
        System.out.println("user.age:"+user.getAge());
        System.out.println("user.info:"+user.info.getImageInfo());
    }

    public static void deepClone(){
        System.out.println("#############深克隆#############");
        Card card = new Card("1111");
        User user = new User("tom","男",21, LocalDate.now(),card);
        User newUser = null;
        try {
            newUser = user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        newUser.age=30;
        newUser.setRegisterTime(LocalDate.of(2018,6,1));
        newUser.card.setCardNo("2222");

        System.out.println("newUser.age:"+newUser.getAge());
        System.out.println("newUser.RegisterTime:"+newUser.getRegisterTime());
        System.out.println("newUser.card:"+newUser.getCard().getCardNo());
        System.out.println("user.age:"+user.getAge());
        System.out.println("user.RegisterTime:"+user.getRegisterTime());
        System.out.println("user.card:"+user.getCard().getCardNo());
    }

    public static void main(String[] args) {
        //1.拷贝
        copy();
        //2.浅克隆
        shallowClone();
        //3.深克隆
        deepClone();
    }



}
