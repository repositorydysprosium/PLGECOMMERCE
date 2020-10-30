package br.com.plataformalancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.service.CategoriaProdutoService;

@RestController
@RequestMapping("/categoria_produto")
public class CategoriaProdutoResource {
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;
	
	@GetMapping("/findall")
	public List<CategoriaProdutoModel> findAll() {
		return categoriaProdutoService.findAll();
	}
	
	@GetMapping("/findone/{codigo}")
	public ResponseEntity<CategoriaProdutoModel> findOne(@PathVariable Long codigo) {
		CategoriaProdutoModel categoriaProdutoModel = categoriaProdutoService.findOne(codigo);
		return ResponseEntity.ok().body(categoriaProdutoModel);
	}

}
