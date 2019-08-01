package org.study.validate;

import net.sf.oval.ConstraintTarget;
import net.sf.oval.constraint.*;

import java.io.Serializable;

/**
 * Created by ArnoldLee on 18/11/29.
 */
public class Param extends ParentParam implements Serializable {

    @NotNull(errorCode = "1",message="birthday字段不能为空")
    @CheckWith(value = CheckBirthday.class,message="日期格式有误!")
    private String birthday;

    @NotNull(errorCode = "1",message="productCode字段不能为空")
    private String productCode;


    private String AA;

    @MatchPattern(pattern = "[0-1]",message = "sex只能在(0,1)中取值!")
    private String sex;

    @MatchPattern(pattern = "[1-5]0 ",message = "coverage只能在(10,20,30,40)中取值!")
    private String coverage;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }



    public String getAA() {
        return AA;
    }

    public void setAA(String AA) {
        this.AA = AA;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    @Override
    public String toString() {
        return "Param{" +
                "birthday='" + birthday + '\'' +
                ", productCode='" + productCode + '\'' +
                ", AA='" + AA + '\'' +
                ", sex='" + sex + '\'' +
                ", coverage='" + coverage + '\'' +
                '}';
    }
}
