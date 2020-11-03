package br.com.plataformalancamento.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import br.com.plataformalancamento.dto.ClienteDTO;
import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/findall")
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteModel> clienteModelList = clienteService.findAll();
		List<ClienteDTO> clienteDTOList = clienteModelList
				.stream().map( clienteModelResult -> new ClienteDTO(clienteModelResult)).collect(Collectors.toList());
		return ResponseEntity.ok().body(clienteDTOList);
	}
	
	@GetMapping("/findone/{codigo}")
	public ResponseEntity<ClienteModel> findOne(@PathVariable Long codigo) {
		ClienteModel clienteModel = clienteService.findOne(codigo);
		return ResponseEntity.ok().body(clienteModel);
	}
	
	@PostMapping("/persist")
	public ResponseEntity<Void> persist(@Valid @RequestBody ClienteDTO clienteDTO) {
		ClienteModel clienteModel = clienteService.instanciarCliente(clienteDTO);
		clienteModel = clienteService.persist(clienteModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(clienteModel.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/merge/{codigo}")
	public ResponseEntity<Void> merge(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Long codigo) {
		ClienteModel clienteModel = clienteService.instanciarCliente(clienteDTO);
		clienteModel.setCodigo(codigo);
		clienteService.merge(clienteModel);
		return ResponseEntity.noContent().build();
	}
	
	@Deprecated
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Long codigo) {
		clienteService.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findallpage")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidadePagina", defaultValue = "10") Integer quantidadePagina,
			@RequestParam(value = "campoOrdenacao", defaultValue = "nome") String campoOrdenacao,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<ClienteModel> clienteModelPageList = clienteService.findPage(pagina, quantidadePagina, campoOrdenacao, direction);
		Page<ClienteDTO> clienteDTOPageList = clienteModelPageList.map( clienteDTOResult -> new ClienteDTO(clienteDTOResult));
		return ResponseEntity.ok().body(clienteDTOPageList);
	}
	
}
