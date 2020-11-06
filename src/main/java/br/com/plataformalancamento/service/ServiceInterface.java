package br.com.plataformalancamento.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ServiceInterface<O> {
	public List<O> findAll();
	public O findOne(Long codigo);
	public O persist(O model);
	public O merge(O model);
	public void delete(Long codigo);
	public Page<O> findPage(Integer pagina, Integer quantidadePagina, String campoOrdenacao, String direction);
}