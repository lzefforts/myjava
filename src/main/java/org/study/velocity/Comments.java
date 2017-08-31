package org.study.velocity;

import java.lang.annotation.*;

/**
 * Created by ArnoldLee on 16/12/9.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comments {
    String value() default "";
}
