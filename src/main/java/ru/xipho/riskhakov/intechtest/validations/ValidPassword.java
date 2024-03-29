package ru.xipho.riskhakov.intechtest.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Password must be at least 8 symbols long and contain at least one of capital letter, number and special symbol like !@#$%";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
