package annotation.lesson2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
// ограничем использование созданной аннотации только для метода и класса
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Maksim";
    int dateOfCreation() default 2020;
    String purpose();
}
