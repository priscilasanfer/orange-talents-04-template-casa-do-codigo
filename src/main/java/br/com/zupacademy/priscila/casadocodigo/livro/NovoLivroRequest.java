package br.com.zupacademy.priscila.casadocodigo.livro;

import br.com.zupacademy.priscila.casadocodigo.autor.Autor;
import br.com.zupacademy.priscila.casadocodigo.categoria.Categoria;
import br.com.zupacademy.priscila.casadocodigo.utils.validation.ExistsId;
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
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank @UniqueValue(targetClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long categoriaId;

    @NotNull @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    public NovoLivroRequest(@NotBlank String titulo,
                            @NotBlank @Size(max = 500) String resumo,
                            String sumario,
                            @NotNull @Min(value = 20) BigDecimal preco,
                            @NotNull @Min(value = 100) Integer numeroDePaginas,
                            @NotBlank String isbn,
                            @NotNull Long categoriaId,
                            @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    /*
    Para Serialização pelo Jackson pois não estava conseguindo
    fazer pelo construtor
     */
    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public Livro toModel(EntityManager manager){
        @NotNull Categoria categoria = manager.find(Categoria.class, categoriaId);
        @NotNull Autor autor = manager.find(Autor.class, autorId);

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
