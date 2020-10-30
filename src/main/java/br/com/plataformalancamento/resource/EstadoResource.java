package br.com.plataformalancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.model.EstadoModel;
import br.com.plataformalancamento.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/findall")
	public List<EstadoModel> findAll() {
		return estadoService.findAll();
	}
	
	@GetMapping("/findone/{codigo}")
	public ResponseEntity<EstadoModel> findOne(@PathVariable Long codigo) {
		EstadoModel estadoModel = estadoService.findOne(codigo);
		return ResponseEntity.ok().body(estadoModel);
	}
	
}
