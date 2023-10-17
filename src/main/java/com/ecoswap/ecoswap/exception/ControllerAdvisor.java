package com.ecoswap.ecoswap.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<Object> handleNoSuchElementFoundException(
            NoSuchElementFoundException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", ex.getStatusCode().value());
        body.put("data", LocalDateTime.now());
        body.put("mensagem", ex.getReason());

        return new ResponseEntity<>(body, ex.getStatusCode());
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status.value());
        body.put("data", LocalDateTime.now());

        FieldError er = ex.getFieldError();
        body.put("mensagem", "O valor recebido da propriedade '" + er.getField() + "' de '" + er.getObjectName() + "' é inválido, pois: " + er.getDefaultMessage());

        return new ResponseEntity<>(body, status);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status.value());
        body.put("data", LocalDateTime.now());
        body.put("mensagem", "O valor recebido do parâmetro '" + ex.getPropertyName() + "' é inválido, pois: impossível de converter " + ex.getValue().getClass().getName() + " para " + ex.getRequiredType().getName());

        return new ResponseEntity<>(body, status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status.value());
        body.put("data", LocalDateTime.now());
        body.put("mensagem", "Valor de parâmetro obrigatório '" + ex.getParameterName() + "' de tipo '" + ex.getParameterType() + "' não recebido");

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 400);
        body.put("data", LocalDateTime.now());
        ConstraintViolation<?> er = ex.getConstraintViolations().iterator().next();
        String campo = null;
        for (jakarta.validation.Path.Node node : er.getPropertyPath()) {
            campo = node.getName();
        }
        body.put("mensagem", "O valor recebido do parâmetro '" + campo + "' é inválido, pois: '" + campo + "' " + er.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleUnhandledException(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 500);
        body.put("data", LocalDateTime.now());
        body.put("mensagem", ex.getClass().getName() + ex.getMessage() + ex.getCause());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
