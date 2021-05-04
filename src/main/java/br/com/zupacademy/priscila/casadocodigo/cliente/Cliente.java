package br.com.zupacademy.priscila.casadocodigo.cliente;

import br.com.zupacademy.priscila.casadocodigo.estado.Estado;
import br.com.zupacademy.priscila.casadocodigo.pais.Pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobrenome;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String documento;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Column(nullable = false)
    private String cep;

    @Deprecated
    public Cliente() {}

    public Cliente(@Email @NotBlank String email,
                   @NotBlank String nome,
                   @NotBlank String sobrenome,
                   @NotBlank String documento,
                   @NotBlank String endereco,
                   @NotBlank String complemento,
                   @NotBlank String cidade,
                   @NotNull Pais pais,
                   @NotBlank String telefone,
                   @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
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

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
