package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import javax.validation.Payload;

public @interface ExistsId {
    Class<?> domainClass();

    String fieldName();

    String message() default "O valor do campo {0} já está em uso.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
