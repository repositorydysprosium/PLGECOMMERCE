package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.model.EstadoModel;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> { }
