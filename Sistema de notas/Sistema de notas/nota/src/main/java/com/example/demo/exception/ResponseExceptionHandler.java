package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//cuando se gatilla una exception determinada o personalizar y devolver a nivel de la app la respuesta.
//esto es a nivel de controller y no de servicio.
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
//ojo: las nuevas excepciones debe tener exceptionhandler 
	//excepciones todas
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(ModeloNotFoundException ex,
	WebRequest request) {
	ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
	request.getDescription(false));
	return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//excepciones a nivel de modelo 404
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> manejarModeloException(ModeloNotFoundException ex,
	WebRequest request) {
	ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
	request.getDescription(false));
	return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}
	
	
	//esta exception se ejecute se va devolver un bad_request--- un dato no enviado etc = 400 no valido
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	HttpHeaders headers, HttpStatus status, WebRequest request) {
	ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
	request.getDescription(false));
	return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
	
	
}
