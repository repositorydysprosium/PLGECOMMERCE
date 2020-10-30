package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.model.CidadeModel;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> { }
