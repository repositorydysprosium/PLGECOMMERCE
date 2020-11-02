package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.exception.ObjectNotFoundException;
import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}
	
	public ClienteModel findOne(Long codigo) {
		Optional<ClienteModel> clienteModelOptional = clienteRepository.findById(codigo);
		return clienteModelOptional.orElseThrow( () -> 
			new ObjectNotFoundException("Objeto (" + ClienteModel.class.getName() + ") com o código de identificação (ID = " + codigo + ") não pode ser encontrado!"));
	}
	
}
