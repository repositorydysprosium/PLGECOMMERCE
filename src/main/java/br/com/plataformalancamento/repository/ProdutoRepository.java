package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.model.CategoriaProdutoModel;
import br.com.plataformalancamento.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	// FIXME -- {ERROR} Ocorre erro ao buscar na requisicao com a primeira letra minuscula. Verificar funcionamento do LIKE
	@Query("SELECT DISTINCT produtoModel FROM ProdutoModel produtoModel INNER JOIN produtoModel.categoriaProdutoModelList categoriaProduto WHERE produtoModel.nome LIKE %:nome% AND categoriaProduto IN :categoriaProdutoModelList")
	public Page<ProdutoModel> recuperarProduto(@Param("nome") String nome, @Param("categoriaProdutoModelList") List<CategoriaProdutoModel> categoriaProdutoModelList, Pageable pageRequest);
	
}
