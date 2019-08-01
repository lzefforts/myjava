package org.study.mapStruct;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Person implements Serializable {


    private String name;
    private String sex;
    private Integer age;
    private String address;
    private BigDecimal inCome;
    private BigDecimal outCome;

}
