package br.com.zupacademy.priscila.casadocodigo.pais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public NovoPaisResponse salvar(@RequestBody @Valid NovoPaisRequest request){
        Pais novoPais = request.toModel();
        manager.persist(novoPais);
        return new NovoPaisResponse(novoPais);
    }
}
