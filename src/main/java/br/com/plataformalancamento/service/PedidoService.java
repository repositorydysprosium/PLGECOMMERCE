package br.com.plataformalancamento.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.enumeration.TipoEstadoPagamentoEnumeration;
import br.com.plataformalancamento.model.ItemPedidoModel;
import br.com.plataformalancamento.model.PagamentoBoletoBancarioModel;
import br.com.plataformalancamento.model.PedidoModel;
import br.com.plataformalancamento.repository.ItemPedidoRepository;
import br.com.plataformalancamento.repository.PagamentoRepository;
import br.com.plataformalancamento.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoBoletoBancarioService pagamentoBoletoBancarioService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public List<PedidoModel> findAll() {
		return pedidoRepository.findAll();
	}
	
	public PedidoModel findOne(Long codigo) {
		Optional<PedidoModel> pedidoModelOptional = pedidoRepository.findById(codigo);
		return pedidoModelOptional.orElse(null);
	}
	
	@Transactional
	public PedidoModel persist(PedidoModel pedidoModel) {
		pedidoModel.setCodigo(null);
		pedidoModel.setDataHora(new Date());
		pedidoModel.getPagamentoModel().setTipoEstadoPagamentoEnumeration(TipoEstadoPagamentoEnumeration.PENDENTE);
		pedidoModel.getPagamentoModel().setPedidoModel(pedidoModel);
			if(pedidoModel.getPagamentoModel() instanceof PagamentoBoletoBancarioModel) {
				PagamentoBoletoBancarioModel pagamentoBoletoBancarioModel = (PagamentoBoletoBancarioModel) pedidoModel.getPagamentoModel();
				pagamentoBoletoBancarioService.configurarPagamentoBoletoBancario(pagamentoBoletoBancarioModel, pedidoModel.getDataHora());
			}
		pedidoRepository.save(pedidoModel);
		pagamentoRepository.save(pedidoModel.getPagamentoModel());
		for(ItemPedidoModel itemPedidoModelResultado : pedidoModel.getItemPedidoModelList()) {
			itemPedidoModelResultado.setValorDesconto(0D);
			itemPedidoModelResultado.setPreco(produtoService.findOne(itemPedidoModelResultado.getProdutoModel().getCodigo()).getPreco());
			itemPedidoModelResultado.getCodigo().setProdutoModel(itemPedidoModelResultado.getProdutoModel());
			itemPedidoModelResultado.setPedido(pedidoModel);
		}
		itemPedidoRepository.saveAll(pedidoModel.getItemPedidoModelList());
		return pedidoModel;
	}
	
}
