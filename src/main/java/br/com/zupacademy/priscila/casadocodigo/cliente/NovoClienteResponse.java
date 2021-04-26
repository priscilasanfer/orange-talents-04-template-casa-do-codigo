package br.com.zupacademy.priscila.casadocodigo.cliente;

public class NovoClienteResponse {

    private Long id;

    public NovoClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
