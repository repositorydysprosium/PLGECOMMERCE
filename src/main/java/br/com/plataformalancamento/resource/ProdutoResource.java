package br.com.plataformalancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.dto.ProdutoDTO;
import br.com.plataformalancamento.model.ProdutoModel;
import br.com.plataformalancamento.service.ProdutoService;
import br.com.plataformalancamento.utility.ConfiguracaoURLUtility;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/findall")
	public List<ProdutoModel> findAll() {
		return produtoService.findAll();
	}
	
	@GetMapping("/findone/{codigo}")
	public ResponseEntity<ProdutoModel> findOne(@PathVariable Long codigo) {
		ProdutoModel produtoModel = produtoService.findOne(codigo);
		return ResponseEntity.ok().body(produtoModel);
	}
	
	@GetMapping("/findallpage")
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidadePagina", defaultValue = "10") Integer quantidadePagina,
			@RequestParam(value = "campoOrdenacao", defaultValue = "nome") String campoOrdenacao,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "codigoCategoriaProdutoList", defaultValue = "") String codigoCategoriaProdutoList) {
		List<Long> longList = ConfiguracaoURLUtility.decodeStringLongList(codigoCategoriaProdutoList);
		String nomeResponse = ConfiguracaoURLUtility.decodeParamentroURL(nome);
		Page<ProdutoModel> produtoModelPageList = produtoService.recuperarProduto(nomeResponse, longList, pagina, quantidadePagina, campoOrdenacao, direction);
		Page<ProdutoDTO> categoriaProdutoDTOPageList = produtoModelPageList.map( produtoDTOResult -> new ProdutoDTO(produtoDTOResult));
		return ResponseEntity.ok().body(categoriaProdutoDTOPageList);
	}
	
}
