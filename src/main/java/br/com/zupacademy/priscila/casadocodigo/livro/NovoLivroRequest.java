package br.com.zupacademy.priscila.casadocodigo.livro;

import br.com.zupacademy.priscila.casadocodigo.autor.Autor;
import br.com.zupacademy.priscila.casadocodigo.categoria.Categoria;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank @UniqueValue(targetClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroDePaginas;

    @NotBlank @UniqueValue(targetClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    private Long categoria_id;

    @NotNull
    private Long autor_id;

    public NovoLivroRequest(@NotBlank String titulo,
                            @NotBlank @Size(max = 500) String resumo,
                            String sumario,
                            @NotNull @Min(value = 20) BigDecimal preco,
                            @NotNull @Min(value = 100) Integer numeroDePaginas,
                            @NotBlank String isbn,
                            @Future LocalDate dataDePublicacao,
                            @NotNull Long categoria_id,
                            @NotNull Long autor_id) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria_id = categoria_id;
        this.autor_id = autor_id;
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

    public Long getCategoria_id() {
        return categoria_id;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public Livro toModel(EntityManager manager){
        Categoria categoria = manager.find(Categoria.class, categoria_id);
        Autor autor = manager.find(Autor.class, autor_id);

        return new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataDePublicacao,
                categoria,
                autor);
    }
}
