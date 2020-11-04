package br.com.plataformalancamento.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.plataformalancamento.annotation.ClienteRegraNegocioAnnotation;
import br.com.plataformalancamento.dto.ClienteDTO;
import br.com.plataformalancamento.enumeration.TipoClienteEnumeration;
import br.com.plataformalancamento.exception.FildMessageException;

public class ClienteRegraNegocioValidation implements ConstraintValidator<ClienteRegraNegocioAnnotation, ClienteDTO> {

	@Override
	public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {
		List<FildMessageException> fildMessageExceptionList = new ArrayList<>();
		if(clienteDTO.getIdentificadorTipoClienteEnumeration().equals(TipoClienteEnumeration.PESSOA_FISICA.getCodigo()) && !DocumentoPessoaFisicaJuridicaValidation.isValidSsn(clienteDTO.getCpfcnpj())) {
			fildMessageExceptionList.add(new FildMessageException("cpfcnpj", "CPF Inválido!"));
		}
		if(clienteDTO.getIdentificadorTipoClienteEnumeration().equals(TipoClienteEnumeration.PESSOA_JURIDICA.getCodigo()) && !DocumentoPessoaFisicaJuridicaValidation.isValidTfn(clienteDTO.getCpfcnpj())) {
			fildMessageExceptionList.add(new FildMessageException("cpfcnpj", "CNPJ Inválido!"));
		}
		for(FildMessageException fildMessageExceptionResult : fildMessageExceptionList) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fildMessageExceptionResult.getMensagemError()).addPropertyNode(fildMessageExceptionResult.getMensagemError()).addConstraintViolation();
		}
		return fildMessageExceptionList.isEmpty();
	}
	
}
