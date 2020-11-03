package br.com.plataformalancamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plataformalancamento.enumeration.TipoClienteEnumeration;
import br.com.plataformalancamento.enumeration.TipoEstadoPagamentoEnumeration;
import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.model.CidadeModel;
import br.com.plataformalancamento.model.ClienteModel;
import br.com.plataformalancamento.model.EnderecoModel;
import br.com.plataformalancamento.model.EstadoModel;
import br.com.plataformalancamento.model.ItemPedidoModel;
import br.com.plataformalancamento.model.PagamentoBoletoBancarioModel;
import br.com.plataformalancamento.model.PagamentoCartaoModel;
import br.com.plataformalancamento.model.PagamentoModel;
import br.com.plataformalancamento.model.PedidoModel;
import br.com.plataformalancamento.model.ProdutoModel;
import br.com.plataformalancamento.repository.CategoriaProdutoRepository;
import br.com.plataformalancamento.repository.CidadeRepository;
import br.com.plataformalancamento.repository.ClienteRepository;
import br.com.plataformalancamento.repository.EnderecoRepository;
import br.com.plataformalancamento.repository.EstadoRepository;
import br.com.plataformalancamento.repository.ItemPedidoRepository;
import br.com.plataformalancamento.repository.PagamentoRepository;
import br.com.plataformalancamento.repository.PedidoRepository;
import br.com.plataformalancamento.repository.ProdutoRepository;
import br.com.plataformalancamento.utility.DateUtility;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaProdutoModel categoriaProdutoModel01 = new CategoriaProdutoModel(null, "Informática");
		CategoriaProdutoModel categoriaProdutoModel02 = new CategoriaProdutoModel(null, "Escritório");
		
		for(int index = 0 ; index <= 10000 ; index++) {
			CategoriaProdutoModel categoriaProdutoModelResult = new CategoriaProdutoModel(null, "Categoria Produto Teste " + index);
			categoriaProdutoRepository.saveAll(Arrays.asList(categoriaProdutoModelResult));
		}
		
		ProdutoModel produtoModel01 = new ProdutoModel(null, "Computador", 2000.00);
		ProdutoModel produtoModel02 = new ProdutoModel(null, "Impressora", 800.00);
		ProdutoModel produtoModel03 = new ProdutoModel(null, "Mouse Óptico", 80.00);
		
		categoriaProdutoModel01.getProdutoModelList().addAll(Arrays.asList(produtoModel01, produtoModel02, produtoModel03));
		categoriaProdutoModel02.getProdutoModelList().addAll(Arrays.asList(produtoModel02));
		
		produtoModel01.getCategoriaProdutoModelList().addAll(Arrays.asList(categoriaProdutoModel01));
		produtoModel02.getCategoriaProdutoModelList().addAll(Arrays.asList(categoriaProdutoModel01, categoriaProdutoModel02));
		produtoModel03.getCategoriaProdutoModelList().addAll(Arrays.asList(categoriaProdutoModel01));

		categoriaProdutoRepository.saveAll(Arrays.asList(categoriaProdutoModel01, categoriaProdutoModel02));
		produtoRepository.saveAll(Arrays.asList(produtoModel01, produtoModel02, produtoModel03));
		
		EstadoModel estadoModel01 = new EstadoModel(null, "Minas Gerais", "MG");
		EstadoModel estadoModel02 = new EstadoModel(null, "São Paulo", "SP");
		EstadoModel estadoModel03 = new EstadoModel(null, "Distrito Federal", "DF");
		
		CidadeModel cidadeModel01 = new CidadeModel(null, "Uberlândia", estadoModel01);
		CidadeModel cidadeModel02 = new CidadeModel(null, "Belo Horizonte", estadoModel02);
		CidadeModel cidadeModel03 = new CidadeModel(null, "Campinas", estadoModel02);
		CidadeModel cidadeModel04 = new CidadeModel(null, "Santa Maria", estadoModel03);
		CidadeModel cidadeModel05 = new CidadeModel(null, "Paranoá", estadoModel03);
		
		estadoModel01.getCidadeModelList().addAll(Arrays.asList(cidadeModel01));
		estadoModel02.getCidadeModelList().addAll(Arrays.asList(cidadeModel02, cidadeModel03));
		estadoModel03.getCidadeModelList().addAll(Arrays.asList(cidadeModel04, cidadeModel05));
		
		estadoRepository.saveAll(Arrays.asList(estadoModel01, estadoModel02, estadoModel03));
		cidadeRepository.saveAll(Arrays.asList(cidadeModel01, cidadeModel02, cidadeModel03, cidadeModel04, cidadeModel05));
		
		ClienteModel clienteModel01 = new ClienteModel(null, "Thereza das Graças Rodrigues", "thereza.rodrigues@hotmail.com.br", "000.000.000-00", TipoClienteEnumeration.PESSOA_FISICA);
			clienteModel01.getTelefoneList().addAll(Arrays.asList("(11) 1111-1111"));
			clienteModel01.getTelefoneList().addAll(Arrays.asList("(22) 2222-2222"));
			
		EnderecoModel enderecoModel01 = new EnderecoModel(null, "Quadra", "403", "Conjunto A Apartamento", "Paranoá", "72.007-001", cidadeModel04, clienteModel01);
		EnderecoModel enderecoModel02 = new EnderecoModel(null, "Quadra", "13", "207 conjunto A Lote", "Santa Maria", "72.507-401", cidadeModel05, clienteModel01);
		
			clienteModel01.getEnderecoModelList().add(enderecoModel01);
			clienteModel01.getEnderecoModelList().add(enderecoModel02);
			
			clienteRepository.saveAll(Arrays.asList(clienteModel01));
			enderecoRepository.saveAll(Arrays.asList(enderecoModel01, enderecoModel02));
			
		PedidoModel pedidoModel01 = new PedidoModel(null, DateUtility.recuperarDataFormato("30/09/2017 10:32"), clienteModel01, enderecoModel01);
		PedidoModel pedidoModel02 = new PedidoModel(null, DateUtility.recuperarDataFormato("30/09/2017 10:32"), clienteModel01, enderecoModel02);
		
		PagamentoModel pagamentoModel01 = new PagamentoCartaoModel(null, TipoEstadoPagamentoEnumeration.QUITADO, pedidoModel01, 6);
			pedidoModel01.setPagamentoModel(pagamentoModel01);
		PagamentoModel pagamentoModel02 = new PagamentoBoletoBancarioModel(null, TipoEstadoPagamentoEnumeration.PENDENTE, pedidoModel02, DateUtility.recuperarDataFormato("30/09/2018 00:00"), null);
			pedidoModel02.setPagamentoModel(pagamentoModel02);
			
			clienteModel01.getPedidoModelList().addAll(Arrays.asList(pedidoModel01, pedidoModel02));
			
			pedidoRepository.saveAll(Arrays.asList(pedidoModel01, pedidoModel02));
			pagamentoRepository.saveAll(Arrays.asList(pagamentoModel01, pagamentoModel02));
			
		ItemPedidoModel itemPedidoModel01 = new ItemPedidoModel(pedidoModel01, produtoModel01, 0.00, 1, 2000.00);
		ItemPedidoModel itemPedidoModel02 = new ItemPedidoModel(pedidoModel01, produtoModel03, 0.00, 2, 80.00);
		ItemPedidoModel itemPedidoModel03 = new ItemPedidoModel(pedidoModel02, produtoModel02, 100.00, 1, 800.00);
		
			pedidoModel01.getItemPedidoModelList().addAll(Arrays.asList(itemPedidoModel01, itemPedidoModel02));
			pedidoModel02.getItemPedidoModelList().addAll(Arrays.asList(itemPedidoModel03));
			
			produtoModel01.getItemPedidoModelList().addAll(Arrays.asList(itemPedidoModel01));
			produtoModel02.getItemPedidoModelList().addAll(Arrays.asList(itemPedidoModel03));
			produtoModel03.getItemPedidoModelList().addAll(Arrays.asList(itemPedidoModel02));
			
		
			itemPedidoRepository.saveAll(Arrays.asList(itemPedidoModel01, itemPedidoModel02, itemPedidoModel03));
	}

}
