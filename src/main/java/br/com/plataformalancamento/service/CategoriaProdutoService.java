package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.exception.ObjectNotFoundException;
import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.repository.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	public List<CategoriaProdutoModel> findAll() {
		return categoriaProdutoRepository.findAll();
	}
	
	public CategoriaProdutoModel findOne(Long codigo) {
		Optional<CategoriaProdutoModel> categoriaProdutoModelOptional = categoriaProdutoRepository.findById(codigo);
		return categoriaProdutoModelOptional.orElseThrow( () -> 
			new ObjectNotFoundException("Objeto (" + CategoriaProdutoModel.class.getName() + ") com o código de identificação (ID = " + codigo + ") não pode ser encontrado!"));
	}

}
