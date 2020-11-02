package br.com.plataformalancamento.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPKModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "ID_PEDIDO")
	private PedidoModel pedidoModel;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUTO")
	private ProdutoModel produtoModel;
	
	public ItemPedidoPKModel() { }

	public PedidoModel getPedidoModel() {
		return pedidoModel;
	}

	public void setPedidoModel(PedidoModel pedidoModel) {
		this.pedidoModel = pedidoModel;
	}

	public ProdutoModel getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoModel == null) ? 0 : pedidoModel.hashCode());
		result = prime * result + ((produtoModel == null) ? 0 : produtoModel.hashCode());
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
		ItemPedidoPKModel other = (ItemPedidoPKModel) obj;
		if (pedidoModel == null) {
			if (other.pedidoModel != null)
				return false;
		} else if (!pedidoModel.equals(other.pedidoModel))
			return false;
		if (produtoModel == null) {
			if (other.produtoModel != null)
				return false;
		} else if (!produtoModel.equals(other.produtoModel))
			return false;
		return true;
	}
	
}
