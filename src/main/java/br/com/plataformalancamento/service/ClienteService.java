package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.ClienteDTO;
import br.com.plataformalancamento.enumeration.TipoClienteEnumeration;
import br.com.plataformalancamento.exception.DataIntegrityViolationException;
import br.com.plataformalancamento.exception.ObjectNotFoundException;
import br.com.plataformalancamento.model.CidadeModel;
import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.model.EnderecoModel;
import br.com.plataformalancamento.repository.ClienteRepository;
import br.com.plataformalancamento.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}
	
	public ClienteModel findOne(Long codigo) {
		Optional<ClienteModel> clienteModelOptional = clienteRepository.findById(codigo);
		return clienteModelOptional.orElseThrow( () -> 
			new ObjectNotFoundException("Objeto (" + ClienteModel.class.getName() + ") com o código de identificação (ID = " + codigo + ") não pode ser encontrado!"));
	}
	
	@Transactional
	public ClienteModel persist(ClienteModel clienteModel) {
		clienteModel = clienteRepository.save(clienteModel);
		enderecoRepository.saveAll(clienteModel.getEnderecoModelList());
		return clienteModel;
	}
	
	public ClienteModel merge(ClienteModel clienteModel) {
		ClienteModel clienteModelResult = findOne(clienteModel.getCodigo());
		atualizadorDadosCliente(clienteModelResult, clienteModel);
		return clienteRepository.save(clienteModelResult);
	}
	
	private void atualizadorDadosCliente(ClienteModel clienteModelNovo, ClienteModel clienteModel) {
		clienteModelNovo.setCodigo(clienteModel.getCodigo());
		clienteModelNovo.setNome(clienteModel.getNome());
		clienteModelNovo.setEmail(clienteModel.getEmail());
	}
	
	public void delete(Long codigo) {
		findOne(codigo);
		try {
			clienteRepository.deleteById(codigo);
		} catch (org.springframework.dao.DataIntegrityViolationException dataIntegrityViolationException) {
			throw new DataIntegrityViolationException("Não é possível excluir, pois há dados vinculados e outra tabela!");
		}
	}
	
	public Page<ClienteModel> findPage(Integer pagina, Integer quantidadePagina, String campoOrdenacao, String direction) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidadePagina, Direction.valueOf(direction), campoOrdenacao);
		return clienteRepository.findAll(pageRequest);
	}
	
	public ClienteModel instanciarCliente(ClienteDTO clienteDTO) {
		return new ClienteModel(clienteDTO.getCodigo(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
	}
	
	public ClienteModel instanciarClientePersistencia(ClienteDTO clienteDTO) {
		ClienteModel clienteModel = new ClienteModel(clienteDTO.getCodigo(), clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getCpfcnpj(), TipoClienteEnumeration.converterEnumeration(clienteDTO.getIdentificadorTipoClienteEnumeration()), bCryptPasswordEncoder.encode(clienteDTO.getSenha()));
		EnderecoModel enderecoModel = new EnderecoModel(clienteDTO.getLogradouro(), clienteDTO.getNumero(), clienteDTO.getComplemento(), clienteDTO.getBairro(), clienteDTO.getCep(), new CidadeModel(clienteDTO.getCodigoCidade()), clienteModel);
			clienteModel.getEnderecoModelList().add(enderecoModel);
			if(!clienteDTO.getTelefoneCelular().isEmpty()) {
				clienteModel.getTelefoneList().add(clienteDTO.getTelefoneCelular());
			}
			if(!clienteDTO.getTelefoneFixo().isEmpty()) {
				clienteModel.getTelefoneList().add(clienteDTO.getTelefoneFixo());
			}
			if(!clienteDTO.getTelefoneFixo().isEmpty()) {
				clienteModel.getTelefoneList().add(clienteDTO.getTelefoneFixoComercial());
			}
		return clienteModel;
	}
	
}
