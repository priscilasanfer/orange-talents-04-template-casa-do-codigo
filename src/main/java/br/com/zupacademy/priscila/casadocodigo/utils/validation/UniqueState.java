package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueStateValidator.class})
public @interface UniqueState {

    String message() default "Já tem um estado com esse nome para esse Pais";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
