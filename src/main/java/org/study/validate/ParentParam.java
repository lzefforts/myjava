package org.study.validate;

import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 *
 * @author ArnoldLee
 * @date 2018/12/7
 */
public class ParentParam implements Serializable {
    private static final long serialVersionUID = -8099521364732087740L;

    @NotNull(errorCode = "1",message="emal字段不能为空")
    @Email(message="email is error.")
    private String emal;

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

}
