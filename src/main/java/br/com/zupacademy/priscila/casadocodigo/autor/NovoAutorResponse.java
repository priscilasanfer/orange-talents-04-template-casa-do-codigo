package br.com.zupacademy.priscila.casadocodigo.autor;

import java.time.OffsetDateTime;

public class NovoAutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private OffsetDateTime instanteCriacao;


    public NovoAutorResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instanteCriacao = autor.getInstanteCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public OffsetDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
