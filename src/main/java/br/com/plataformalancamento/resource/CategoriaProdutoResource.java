package br.com.plataformalancamento.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.plataformalancamento.dto.CategoriaProdutoDTO;
import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.service.CategoriaProdutoService;

@RestController
@RequestMapping("/categoriaproduto")
public class CategoriaProdutoResource {
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;
	
	@GetMapping("/findall")
	public ResponseEntity<List<CategoriaProdutoDTO>> findAll() {
		List<CategoriaProdutoModel> categoriaProdutoModelList = categoriaProdutoService.findAll();
		List<CategoriaProdutoDTO> categoriaProdutoDTOList = categoriaProdutoModelList
				.stream().map( categoriaProdutoModelResult -> new CategoriaProdutoDTO(categoriaProdutoModelResult)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaProdutoDTOList);
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
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Long codigo) {
		categoriaProdutoService.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findallpage")
	public ResponseEntity<Page<CategoriaProdutoDTO>> findPage(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidadePagina", defaultValue = "10") Integer quantidadePagina,
			@RequestParam(value = "campoOrdenacao", defaultValue = "nome") String campoOrdenacao,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<CategoriaProdutoModel> categoriaProdutoModelPageList = categoriaProdutoService.findPage(pagina, quantidadePagina, campoOrdenacao, direction);
		Page<CategoriaProdutoDTO> categoriaProdutoDTOPageList = categoriaProdutoModelPageList.map( categoriaProdutoDTOResult -> new CategoriaProdutoDTO(categoriaProdutoDTOResult));
		return ResponseEntity.ok().body(categoriaProdutoDTOPageList);
	}

}
