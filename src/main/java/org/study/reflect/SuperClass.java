package org.study.reflect;

/**
 * Created by ArnoldLee on 17/1/21.
 */
public class SuperClass implements Cloneable{

    public SuperClass(Long version, String state) {
        this.version = version;
        this.state = state;
    }

    public SuperClass() {
//        System.out.println("hahaha");
    }

    private Long version;

    private String state;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public SuperClass clone() throws CloneNotSupportedException {
        return (SuperClass)super.clone();
    }
}
