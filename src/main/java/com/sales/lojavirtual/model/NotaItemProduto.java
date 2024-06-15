package com.sales.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "nota_item_produto")
public class NotaItemProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double qtd;
	
	@ManyToOne
	@JoinColumn(name = "nota_fiscal_compra_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "nota_fiscal_produto_fk"))
	private NotaFiscalCompra notaFiscalCompra;
	
	
	@ManyToOne
	@JoinColumn(name = "produto_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "nota_produto_fk"))
	private Produto produto;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getQtd() {
		return qtd;
	}


	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}


	public NotaFiscalCompra getNotaFiscalCompra() {
		return notaFiscalCompra;
	}


	public void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
		this.notaFiscalCompra = notaFiscalCompra;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaItemProduto other = (NotaItemProduto) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "NotaItemProduto [id=" + id + ", qtd=" + qtd + ", notaFiscalCompra=" + notaFiscalCompra + ", produto="
				+ produto + "]";
	}
	
	
	

}
