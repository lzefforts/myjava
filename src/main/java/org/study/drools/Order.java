package org.study.drools;

import java.io.Serializable;

/**
 * Created by ArnoldLee on 17/4/11.
 */
public class Order implements Serializable{

    private String name = "";
    private Integer sumprice =0;
    private Integer DiscountPercent=0;;

    public Integer getSumprice() {
        return sumprice;
    }
    public void setSumprice(Integer sumprice) {
        this.sumprice = sumprice;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDiscountPercent() {
        return DiscountPercent;
    }
    public void setDiscountPercent(Integer DiscountPercent) {
        this.DiscountPercent = DiscountPercent;
    }
}
