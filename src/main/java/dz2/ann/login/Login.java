package dz2.ann.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)      // применяется к полям
@Retention(RetentionPolicy.RUNTIME)     // нужно, чтобы работало в режиме работы программы
public @interface Login {
    //String name();
}
