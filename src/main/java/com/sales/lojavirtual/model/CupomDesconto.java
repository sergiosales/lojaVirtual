package com.sales.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cupom_desconto")
@SequenceGenerator(name = "seq_cupom_desconto",sequenceName ="seq_cupom_desconto",allocationSize = 1,initialValue = 1 )
public class CupomDesconto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator ="seq_cupom_desconto" )
	private Long id;
	
	private String codDescricao;
	private BigDecimal valorRealDesconto;
	private BigDecimal valorPorcentDesc;
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
