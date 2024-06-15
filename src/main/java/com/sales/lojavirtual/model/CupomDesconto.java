package com.sales.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cupom_desconto")
public class CupomDesconto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(nullable = false)
	private String codDescricao;
	
	private BigDecimal valorRealDesconto;
	
	private BigDecimal valorPorcentDesc;
	
	@Column(nullable = false)
	private Date dataValidadeCupon;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodDescricao() {
		return codDescricao;
	}
	public void setCodDescricao(String codDescricao) {
		this.codDescricao = codDescricao;
	}
	public BigDecimal getValorRealDesconto() {
		return valorRealDesconto;
	}
	public void setValorRealDesconto(BigDecimal valorRealDesconto) {
		this.valorRealDesconto = valorRealDesconto;
	}
	public BigDecimal getValorPorcentDesc() {
		return valorPorcentDesc;
	}
	public void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
		this.valorPorcentDesc = valorPorcentDesc;
	}
	public Date getDataValidadeCupon() {
		return dataValidadeCupon;
	}
	public void setDataValidadeCupon(Date dataValidadeCupon) {
		this.dataValidadeCupon = dataValidadeCupon;
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
		CupomDesconto other = (CupomDesconto) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
