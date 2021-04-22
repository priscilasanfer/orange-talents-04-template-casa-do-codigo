package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailUnicoValidator.class})
public @interface EmailUnico {

    String message() default "{EmailUnico}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "" ;

}
