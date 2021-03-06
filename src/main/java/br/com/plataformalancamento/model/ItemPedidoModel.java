package br.com.plataformalancamento.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plataformalancamento.utility.ConfiguracaoMonetariaUtility;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedidoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPKModel codigo = new ItemPedidoPKModel();
	
	private Double valorDesconto;
	
	private Integer quantidade;
	
	private Double preco;
	
	// TODO
	@Transient
	private ProdutoModel produtoModel;
	
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
	
	public Double getSubtotal() {
		return (this.preco - this.valorDesconto) * quantidade;
	}
	
	@JsonIgnore
	public PedidoModel getPedidoModel() {
		return codigo.getPedidoModel();
	}
	
	public void setPedido(PedidoModel pedidoModel) {
		codigo.setPedidoModel(pedidoModel);
	}
	
	public void setProduto(ProdutoModel produtoModel) {
		codigo.setProdutoModel(produtoModel);
	}
	
//	public ProdutoModel getProdutoModel() {
//		return codigo.getProdutoModel();
//	}
//
//	public void setProdutoModel(ProdutoModel produtoModel) {
//		this.produtoModel = produtoModel;
//	}

	public ProdutoModel getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
			builder.append("Quantidade: " + getQuantidade() + "\n");
			builder.append("Preço Unitário: " + ConfiguracaoMonetariaUtility.configurarValorEmReal(getPreco()) + "\n");
		return builder.toString();
	}

}
