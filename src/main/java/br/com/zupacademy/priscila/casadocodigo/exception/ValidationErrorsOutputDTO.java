package br.com.zupacademy.priscila.casadocodigo.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDTO {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorOutputDto> fieldErros = new ArrayList<>();

    public void addError(String message){
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message){
        FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
        fieldErros.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutputDto> getFieldErros() {
        return fieldErros;
    }
}
