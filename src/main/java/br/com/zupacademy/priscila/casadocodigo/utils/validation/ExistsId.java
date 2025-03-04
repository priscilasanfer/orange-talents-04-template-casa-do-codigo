package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistsIdValidator.class})
public @interface ExistsId {
    Class<?> domainClass();

    String fieldName();

    String message() default "O valor do campo {0} já está em uso.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
