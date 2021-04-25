package br.com.zupacademy.priscila.casadocodigo.livro;

import br.com.zupacademy.priscila.casadocodigo.autor.DetalheAutorResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalheLivroResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private DetalheAutorResponse autor;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    public DetalheLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.autor = new DetalheAutorResponse(livro.getAutor());
        this.dataDePublicacao = livro.getDataDePublicacao();
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

    public DetalheAutorResponse getAutor() {
        return autor;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }
}
