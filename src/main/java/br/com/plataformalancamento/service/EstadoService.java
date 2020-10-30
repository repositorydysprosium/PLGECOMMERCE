package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.model.EstadoModel;
import br.com.plataformalancamento.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<EstadoModel> findAll() {
		return estadoRepository.findAll();
	}
	
	public EstadoModel findOne(Long codigo) {
		Optional<EstadoModel> estadoModelOptional = estadoRepository.findById(codigo);
		return estadoModelOptional.orElse(null);
	}
	
}
