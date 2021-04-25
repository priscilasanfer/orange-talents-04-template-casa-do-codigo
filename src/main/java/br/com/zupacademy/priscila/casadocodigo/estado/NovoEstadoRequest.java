package br.com.zupacademy.priscila.casadocodigo.estado;

import br.com.zupacademy.priscila.casadocodigo.pais.Pais;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.ExistsId;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.UniqueState;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueState
public class NovoEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    @Deprecated
    public NovoEstadoRequest() {}

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getNome() {
        return nome;
    }

    public Estado toModel(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, paisId);

        return new Estado (this.nome, pais);
    }

}
