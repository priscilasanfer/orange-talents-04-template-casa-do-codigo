package br.com.zupacademy.priscila.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class ListaLivrosResponse {

    private Long id;
    private String titulo;

    public ListaLivrosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListaLivrosResponse> toModel(EntityManager manager) {
        TypedQuery<Livro> query = manager.createQuery("select l from Livro l", Livro.class);
        List<Livro> resultList = query.getResultList();
        return resultList.stream().map(ListaLivrosResponse::new).collect(Collectors.toList());
    }
}
