package br.com.zupacademy.priscila.casadocodigo.estado;

import br.com.zupacademy.priscila.casadocodigo.utils.validation.UniqueState;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public NovoEstadoResponse salvar(@RequestBody @Valid @UniqueState NovoEstadoRequest request){
        Estado novoEstado = request.toModel(manager);
        manager.persist(novoEstado);
        return new NovoEstadoResponse(novoEstado);
    }
}
