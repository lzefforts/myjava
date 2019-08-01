package org.study.validate;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;

/**
 * Created by ArnoldLee on 18/11/29.
 */
public class ParamTest {

    public static void main(String[] args) {
        Param param = new Param();
        param.setSex("0");
        param.setBirthday("1980-13-02");
        param.setProductCode("gsyxzjx");
        param.setCoverage("10");
        param.setEmal("123@aaa.bc");

        Validator validator = new Validator();

        List<ConstraintViolation> ret = validator.validate(param);
        System.out.println(ret.toString());
//        URLDecoder.decode("哈哈哈%asdjfll");
//        System.out.printf("");



//        System.out.printf("当前时间为:%s\n",LocalDateTime.now());
//        System.out.printf("当前时间为:%s\n",LocalDate.now());
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDateTime = LocalDate.parse("1988-01-31",formatter);
//        System.out.printf("日期为:%s\n", JSON.toJSONString(localDateTime));
    }
}
