package org.study.reflect;

/**
 * Created by ArnoldLee on 17/1/21.
 */
public class BaseClass extends SuperClass{

    private String baseName;

    public String baseType;

    protected Long baseNo;

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public Long getBaseNo() {
        return baseNo;
    }

    public void setBaseNo(Long baseNo) {
        this.baseNo = baseNo;
    }
}
