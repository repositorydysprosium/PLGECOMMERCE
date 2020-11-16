package br.com.plataformalancamento.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.model.ProdutoModel;
import br.com.plataformalancamento.repository.CategoriaProdutoRepository;
import br.com.plataformalancamento.repository.ProdutoRepository;

@Service
public class ProdutoService implements InterfaceService<ProdutoModel> {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Override
	public List<ProdutoModel> findAll() {
		return produtoRepository.findAll();
	}
	
	@Override
	public ProdutoModel findOne(Long codigo) {
		Optional<ProdutoModel> produtoModelOptional = produtoRepository.findById(codigo);
		return produtoModelOptional.orElse(null);
	}

	@Override
	public ProdutoModel persist(ProdutoModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoModel merge(ProdutoModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ProdutoModel> findPage(Integer pagina, Integer quantidadePagina, String campoOrdenacao,
			String direction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public Page<ProdutoModel> recuperarProduto(String nome, List<Long> codigoCategoriaProdutoList, Integer pagina, Integer quantidadePagina, String campoOrdenacao, String direction) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidadePagina, Direction.valueOf(direction), campoOrdenacao);
		List<CategoriaProdutoModel> categoriaProdutoModelList = categoriaProdutoRepository.findAllById(codigoCategoriaProdutoList);
		return produtoRepository.recuperarProduto(nome, categoriaProdutoModelList, pageRequest);
	}
	
}
