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
@Table(name = "item_venda")
public class ItemVenda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double qtd;
	
	@ManyToOne()
	@JoinColumn(name = "produto_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "produto_id_fk" ))
	private Produto produto;
	
	@ManyToOne()
	@JoinColumn(name = "venda_loja_virutal_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "venda_loja_virutal_fk" ))
	private VendaLojaVirtual vendaLojaVirtual;

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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaLojaVirtual getVendaLojaVirtual() {
		return vendaLojaVirtual;
	}

	public void setVendaLojaVirtual(VendaLojaVirtual vendaLojaVirtual) {
		this.vendaLojaVirtual = vendaLojaVirtual;
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
		ItemVenda other = (ItemVenda) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", qtd=" + qtd + ", produto=" + produto + ", vendaLojaVirtual="
				+ vendaLojaVirtual + "]";
	}
	
	

}
