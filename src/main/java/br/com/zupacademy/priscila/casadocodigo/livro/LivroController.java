package br.com.zupacademy.priscila.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
