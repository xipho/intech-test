package ru.xipho.riskhakov.intechtest.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchConfirmationValidator.class)
@Documented
public @interface PasswordMatchConfirmation {
    String message() default "Password does not match its confirmation";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
