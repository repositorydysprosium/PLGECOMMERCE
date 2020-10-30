package br.com.plataformalancamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.model.ProdutoModel;
import br.com.plataformalancamento.repository.CategoriaProdutoRepository;
import br.com.plataformalancamento.repository.ProdutoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
	}

}
