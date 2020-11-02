package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.model.PedidoModel;
import br.com.plataformalancamento.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<PedidoModel> findAll() {
		return pedidoRepository.findAll();
	}
	
	public PedidoModel findOne(Long codigo) {
		Optional<PedidoModel> pedidoModelOptional = pedidoRepository.findById(codigo);
		return pedidoModelOptional.orElse(null);
	}
	
}
