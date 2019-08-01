package org.study.mapStruct;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PersonDto implements Serializable {


    private String name;
    private String sex;
    private Integer age;
    private String address;
    private BigDecimal shouRu;
    private BigDecimal zhiChu;
}
