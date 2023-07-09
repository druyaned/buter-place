package com.github.druyaned.buters.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CardExpirationValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CardExpirationConstraint {
    
    String message() default "некорректная дата или несоответствие формату ММ/ГГ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
