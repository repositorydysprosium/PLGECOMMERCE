package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.model.PagamentoModel;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> { }
