package br.com.zupacademy.priscila.casadocodigo.categoria;

import br.com.zupacademy.priscila.casadocodigo.utils.validation.ValorUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank @ValorUnico(targetClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public NovaCategoriaRequest() {}

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
