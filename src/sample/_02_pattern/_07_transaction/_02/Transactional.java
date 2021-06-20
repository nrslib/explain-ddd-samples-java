package sample._02_pattern._07_transaction._02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Spring boot の Transactional を模したダミー
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {
    Isolation isolation() default Isolation.DEFAULT;
}
