package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import br.com.zupacademy.priscila.casadocodigo.estado.Estado;
import br.com.zupacademy.priscila.casadocodigo.estado.NovoEstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateValidator implements ConstraintValidator<UniqueState, NovoEstadoRequest> {

    @Autowired
    private EntityManager manager;

    @Override
    public boolean isValid(NovoEstadoRequest request, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select e from Estado e where e.nome = :nome and e.pais.id = :paisId");
        query.setParameter("nome", request.getNome());
        query.setParameter("paisId", request.getPaisId());

        List<Estado> resultList = query.getResultList();

        return resultList.isEmpty();
    }
}
