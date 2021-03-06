package br.com.plataformalancamento.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceHandlerException {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErroPadraoException> objetoNaoEncontrado(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest) {
		ErroPadraoException erroPadraoException = new ErroPadraoException(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadraoException);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErroPadraoException> erroReferencia(DataIntegrityViolationException dataIntegrityViolationException, HttpServletRequest httpServletRequest) {
		ErroPadraoException erroPadraoException = new ErroPadraoException(HttpStatus.BAD_REQUEST.value(), dataIntegrityViolationException.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadraoException);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadraoException> erroReferencia(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
		ValidationErrorException validationErrorException = new ValidationErrorException(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		for(FieldError fildError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrorException.adicionarError(fildError.getField(), fildError.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorException );
	}
	
}
