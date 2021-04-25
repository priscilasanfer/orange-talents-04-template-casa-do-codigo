package br.com.zupacademy.priscila.casadocodigo.pais;

import br.com.zupacademy.priscila.casadocodigo.utils.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank @UniqueValue(targetClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public NovoPaisRequest() {}

    public NovoPaisRequest(@NotBlank String nome) {
        this.nome = nome;
     }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
