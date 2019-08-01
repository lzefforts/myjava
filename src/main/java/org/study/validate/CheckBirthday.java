package org.study.validate;

import net.sf.oval.constraint.CheckWithCheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 校验生日格式(yyyy-MM-dd)
 * @author ArnoldLee
 * @date 18/11/29
 */
public class CheckBirthday implements CheckWithCheck.SimpleCheck {
    private static final long serialVersionUID = 7802093272760766953L;

    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {
        String str = value.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate localDateTime = LocalDate.parse(str,formatter);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
