package br.com.zupacademy.priscila.casadocodigo.cliente;

import br.com.zupacademy.priscila.casadocodigo.utils.validation.EstadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoValidator estadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoValidator);
    }

    @PostMapping
    @Transactional
    public NovoClienteResponse salvar(@RequestBody @Valid NovoClienteRequest request){
        Cliente novoCliente = request.toModel(manager);
        manager.persist(novoCliente);
        return new NovoClienteResponse(novoCliente);
    }
}
