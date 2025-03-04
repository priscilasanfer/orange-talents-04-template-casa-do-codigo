package br.com.zupacademy.priscila.casadocodigo.livro;

import br.com.zupacademy.priscila.casadocodigo.autor.Autor;
import br.com.zupacademy.priscila.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false)
    private String resumo;

    @Column(columnDefinition = "text", nullable = false)
    private String sumario;

    @NotNull
    @Min(20)
    @Column(nullable = false)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    @Column(nullable = false)
    private Integer numeroDePaginas;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @ManyToOne
    @NotNull
    @Valid
    private Categoria categoria;

    @ManyToOne
    @NotNull
    @Valid
    private Autor autor;

    @Deprecated
    public Livro() {}

    public Livro(@NotBlank String titulo,
                 @NotBlank @Size(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer numeroDePaginas,
                 @NotBlank String isbn,
                 @Future @NotNull LocalDate dataDePublicacao,
                 @NotNull @Valid Categoria categoria,
                 @NotNull @Valid Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
