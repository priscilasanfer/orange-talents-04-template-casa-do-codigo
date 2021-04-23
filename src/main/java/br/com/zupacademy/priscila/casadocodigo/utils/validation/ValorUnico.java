package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValorUnicoValidator.class})
public @interface ValorUnico {

    Class<?> targetClass();

    String fieldName();

    String message() default "{ValorUnico}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
