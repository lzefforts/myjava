package org.study.clone;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ArnoldLee
 * @date 18/6/5
 */
public class User implements Serializable,Cloneable {
    private static final long serialVersionUID = 1630152850554745145L;


    private String name;
    private String sex;
    public Integer age;
    public LocalDate registerTime;
    public Card card;

    public User(String name, String sex, Integer age, LocalDate registerTime, Info info) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.registerTime = registerTime;
        this.info = info;
    }

    public Info info;

    public User(String name, String sex, Integer age, LocalDate registerTime, Card card) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.registerTime = registerTime;
        this.card = card;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        User user = null;
        user = (User) super.clone();
        if(user.card != null){
            user.card = (Card) card.clone();
        }
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDate registerTime) {
        this.registerTime = registerTime;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
