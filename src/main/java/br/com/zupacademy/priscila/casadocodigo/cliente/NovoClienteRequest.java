package br.com.zupacademy.priscila.casadocodigo.cliente;

import br.com.zupacademy.priscila.casadocodigo.estado.Estado;
import br.com.zupacademy.priscila.casadocodigo.pais.Pais;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.Documento;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.ExistsId;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteRequest {

    @Email
    @NotBlank
    @UniqueValue(targetClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @UniqueValue(targetClass = Cliente.class, fieldName ="documento")
    @NotBlank
    @Documento
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public NovoClienteRequest(@Email @NotBlank String email,
                              @NotBlank String nome,
                              @NotBlank String sobrenome,
                              @NotBlank String documento,
                              @NotBlank String endereco,
                              @NotBlank String complemento,
                              @NotBlank String cidade,
                              @NotNull Long paisId,
                              @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Cliente toModel(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, paisId);

        Cliente cliente = new Cliente(this.email,
                this.nome,
                this.sobrenome,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                pais,
                this.telefone,
                this.cep);

        if(estadoId != null){
            Estado estado = manager.find(Estado.class, estadoId);
            cliente.setEstado(estado);
        }

        return cliente;
    }
}
