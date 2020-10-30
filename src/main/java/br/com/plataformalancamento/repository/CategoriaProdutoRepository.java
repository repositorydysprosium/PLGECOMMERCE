package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.model.CategoriaProdutoModel;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProdutoModel, Long> { }
