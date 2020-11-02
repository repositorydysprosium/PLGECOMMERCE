package br.com.plataformalancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.model.PedidoModel;
import br.com.plataformalancamento.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/findall")
	public List<PedidoModel> findAll() {
		return pedidoService.findAll();
	}
	
	@GetMapping("/findone/{codigo}")
	public ResponseEntity<PedidoModel> findOne(@PathVariable Long codigo) {
		PedidoModel pedidoModel = pedidoService.findOne(codigo);
		return ResponseEntity.ok().body(pedidoModel);
	}
	
}
