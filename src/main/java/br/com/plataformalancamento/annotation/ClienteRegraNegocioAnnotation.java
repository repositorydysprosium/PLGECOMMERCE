package br.com.plataformalancamento.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.plataformalancamento.validation.ClienteRegraNegocioValidation;

@Constraint(validatedBy = ClienteRegraNegocioValidation.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface ClienteRegraNegocioAnnotation {
	
	String message() default "Erro de Validação Negocial!";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
