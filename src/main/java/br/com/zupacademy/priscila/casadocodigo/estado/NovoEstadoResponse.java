package br.com.zupacademy.priscila.casadocodigo.estado;

import br.com.zupacademy.priscila.casadocodigo.pais.Pais;

public class NovoEstadoResponse {
    private Long id;
    private String nome;
    private Pais pais;

    public NovoEstadoResponse(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}