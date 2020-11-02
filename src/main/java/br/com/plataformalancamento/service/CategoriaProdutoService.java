package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	public CategoriaProdutoModel persist(CategoriaProdutoModel categoriaProdutoModel) {
		categoriaProdutoModel.setCodigo(null);
		return categoriaProdutoRepository.save(categoriaProdutoModel);
	}
	
	public CategoriaProdutoModel merge(CategoriaProdutoModel categoriaProdutoModel) {
		findOne(categoriaProdutoModel.getCodigo());
		return categoriaProdutoRepository.save(categoriaProdutoModel);
	}
	
	public void delete(Long codigo) {
		findOne(codigo);
		try {
			categoriaProdutoRepository.deleteById(codigo);
		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
			
		}
	}

}