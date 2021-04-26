package br.com.zupacademy.priscila.casadocodigo.utils.validation;

import br.com.zupacademy.priscila.casadocodigo.cliente.NovoClienteRequest;
import br.com.zupacademy.priscila.casadocodigo.estado.Estado;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovoClienteRequest request = (NovoClienteRequest) target;

        Query query = manager.createQuery("select e from Estado e where e.pais.id = :paisId ");
        query.setParameter("paisId", request.getPaisId());

        List<Estado> resultList = query.getResultList();

        if (request.getEstadoId() == null && !resultList.isEmpty()){
            errors.rejectValue("estadoId", "404", "Por favor selecione um estado do pais informado ");
        }
    }
}
