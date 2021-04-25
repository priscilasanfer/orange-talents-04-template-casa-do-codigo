package br.com.zupacademy.priscila.casadocodigo.livro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<ListaLivrosResponse> listar(){
        return ListaLivrosResponse.toModel(manager);
    }

    @GetMapping("/{id}")
    public DetalheLivroResponse detalhar(@PathVariable Long id){
        Livro livro = manager.find(Livro.class, id);

        if(livro == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new DetalheLivroResponse(livro);
    }
}
