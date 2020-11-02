package br.com.plataformalancamento.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.service.CategoriaProdutoService;

@RestController
@RequestMapping("/categoriaproduto")
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
	
	@PostMapping("/persist")
	public ResponseEntity<Void> persist(@RequestBody CategoriaProdutoModel categoriaProdutoModel) {
		categoriaProdutoModel = categoriaProdutoService.persist(categoriaProdutoModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(categoriaProdutoModel.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/merge/{codigo}")
	public ResponseEntity<Void> merge(@RequestBody CategoriaProdutoModel categoriaProdutoModel, @PathVariable Long codigo) {
		categoriaProdutoModel.setCodigo(codigo);
		categoriaProdutoModel = categoriaProdutoService.merge(categoriaProdutoModel);
		return ResponseEntity.noContent().build();
	}

}
