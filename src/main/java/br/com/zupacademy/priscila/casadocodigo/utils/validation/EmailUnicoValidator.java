package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import br.com.zupacademy.priscila.casadocodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !repository.existsAutorByEmail(email);
    }
}
