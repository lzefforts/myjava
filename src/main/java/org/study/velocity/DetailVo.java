package org.study.velocity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 详细页面vo
 * Created by ArnoldLee on 16/12/9.
 */
public class DetailVo {


    @Comments("名称")
    private String a;
    @Comments("金额")
    private BigDecimal b;
    @Comments("日期")
    private Date c;
    @Comments("认购编号")
    private Long d;
    @Comments("排队号")
    private Integer e;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public Date getC() {
        return c;
    }

    public void setC(Date c) {
        this.c = c;
    }

    public Long getD() {
        return d;
    }

    public void setD(Long d) {
        this.d = d;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }
}
