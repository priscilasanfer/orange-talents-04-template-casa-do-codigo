package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private String fieldName;

    private Class<?> targetClass;

    @Override
    public void initialize(ValorUnico constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        targetClass = constraintAnnotation.targetClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from " + targetClass.getName() + " where " + fieldName + " = :value");
        query.setParameter("value", value);
        List<?> resultado = query.getResultList();
        return resultado.isEmpty();
    }
}
