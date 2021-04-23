package br.com.zupacademy.priscila.casadocodigo.livro;

import br.com.zupacademy.priscila.casadocodigo.categoria.NovaCategoriaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoLivroResponse> salvar(@RequestBody @Valid NovoLivroRequest request){
        Livro novoLivro = request.toModel(manager);
        manager.persist(novoLivro);
        return ResponseEntity.ok(new NovoLivroResponse(novoLivro));
    }
}
