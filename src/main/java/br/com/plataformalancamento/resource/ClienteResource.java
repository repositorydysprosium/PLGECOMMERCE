package br.com.plataformalancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/findall")
	public List<ClienteModel> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/findone/{codigo}")
	public ResponseEntity<ClienteModel> findOne(@PathVariable Long codigo) {
		ClienteModel clienteModel = clienteService.findOne(codigo);
		return ResponseEntity.ok().body(clienteModel);
	}
	
}
