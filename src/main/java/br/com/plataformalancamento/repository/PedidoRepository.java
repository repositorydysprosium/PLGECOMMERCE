package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.model.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> { }
