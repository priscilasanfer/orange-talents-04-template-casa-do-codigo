package br.com.zupacademy.priscila.casadocodigo.utils.exception;

public class ApiErrorResponse {

    private String code;
    private String message;

    public ApiErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCampo() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
