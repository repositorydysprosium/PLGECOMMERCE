package br.com.plataformalancamento.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedidoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPKModel codigo = new ItemPedidoPKModel();
	
	private Double valorDesconto;
	
	private Integer quantidade;
	
	private Double preco;
	
	public ItemPedidoModel() { }

	public ItemPedidoModel(Double valorDesconto, Integer quantidade, Double preco) {
		super();
		this.valorDesconto = valorDesconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public ItemPedidoModel(PedidoModel pedidoModel, ProdutoModel produtoModel, Double valorDesconto, Integer quantidade, Double preco) {
		super();
		codigo.setPedidoModel(pedidoModel);
		codigo.setProdutoModel(produtoModel);
		this.valorDesconto = valorDesconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public PedidoModel getPedidoModel() {
		return codigo.getPedidoModel();
	}
	
	public ProdutoModel getProdutoModel() {
		return codigo.getProdutoModel();
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ItemPedidoPKModel getCodigo() {
		return codigo;
	}

	public void setCodigo(ItemPedidoPKModel codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoModel other = (ItemPedidoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
