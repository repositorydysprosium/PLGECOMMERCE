package br.com.plataformalancamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.model.CidadeModel;
import br.com.plataformalancamento.model.EstadoModel;
import br.com.plataformalancamento.model.ProdutoModel;
import br.com.plataformalancamento.repository.CategoriaProdutoRepository;
import br.com.plataformalancamento.repository.CidadeRepository;
import br.com.plataformalancamento.repository.EstadoRepository;
import br.com.plataformalancamento.repository.ProdutoRepository;

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
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaProdutoModel categoriaProdutoModel01 = new CategoriaProdutoModel(null, "Informática");
		CategoriaProdutoModel categoriaProdutoModel02 = new CategoriaProdutoModel(null, "Escritório");
		
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
		
		CidadeModel cidadeModel01 = new CidadeModel(null, "Uberlândia", estadoModel01);
		CidadeModel cidadeModel02 = new CidadeModel(null, "Belo Horizonte", estadoModel02);
		CidadeModel cidadeModel03 = new CidadeModel(null, "Campinas", estadoModel02);
		
		estadoModel01.getCidadeModelList().addAll(Arrays.asList(cidadeModel01));
		estadoModel02.getCidadeModelList().addAll(Arrays.asList(cidadeModel02, cidadeModel03));
		
		estadoRepository.saveAll(Arrays.asList(estadoModel01, estadoModel02));
		cidadeRepository.saveAll(Arrays.asList(cidadeModel01, cidadeModel02, cidadeModel03));
		
	}

}
