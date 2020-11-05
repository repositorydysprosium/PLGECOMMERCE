package br.com.plataformalancamento.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.plataformalancamento.annotation.ClienteRegraNegocioAnnotation;
import br.com.plataformalancamento.dto.ClienteDTO;
import br.com.plataformalancamento.enumeration.TipoClienteEnumeration;
import br.com.plataformalancamento.exception.FildMessageException;
import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.repository.ClienteRepository;

public class ClienteRegraNegocioValidation implements ConstraintValidator<ClienteRegraNegocioAnnotation, ClienteDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {
		List<FildMessageException> fildMessageExceptionList = new ArrayList<>();
		if(clienteDTO.getIdentificadorTipoClienteEnumeration().equals(TipoClienteEnumeration.PESSOA_FISICA.getCodigo()) && !DocumentoPessoaFisicaJuridicaValidation.isValidSsn(clienteDTO.getCpfcnpj())) {
			fildMessageExceptionList.add(new FildMessageException("cpfcnpj", "CPF Inválido!"));
		}
		if(clienteDTO.getIdentificadorTipoClienteEnumeration().equals(TipoClienteEnumeration.PESSOA_JURIDICA.getCodigo()) && !DocumentoPessoaFisicaJuridicaValidation.isValidTfn(clienteDTO.getCpfcnpj())) {
			fildMessageExceptionList.add(new FildMessageException("cpfcnpj", "CNPJ Inválido!"));
		}
		
		ClienteModel clienteModelResultado = clienteRepository.findByEmail(clienteDTO.getEmail());
		
		if(clienteModelResultado != null) {
			fildMessageExceptionList.add(new FildMessageException("EMAIL", "E-mail já cadastrado na base de dados!"));
		}
		
		for(FildMessageException fildMessageExceptionResult : fildMessageExceptionList) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fildMessageExceptionResult.getMensagemError()).addPropertyNode(fildMessageExceptionResult.getMensagemError()).addConstraintViolation();
		}
		return fildMessageExceptionList.isEmpty();
	}
	
}
