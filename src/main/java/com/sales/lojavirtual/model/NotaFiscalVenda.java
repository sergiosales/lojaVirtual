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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota_fiscal_venda")
public class NotaFiscalVenda implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private String serie;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(columnDefinition = "text",nullable = false)
	private String xml;
	
	@Column(columnDefinition = "text",nullable = false)
	private String pdf;
	
	@OneToOne()
	@JoinColumn(name = "venda_loja_virtual_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "venda_loja_virtual_fk" ))
	private VendaLojaVirtual vendaLojaVirtual;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
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
		NotaFiscalVenda other = (NotaFiscalVenda) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "NotaFiscalVenda [id=" + id + ", numero=" + numero + ", serie=" + serie + ", tipo=" + tipo + ", xml="
				+ xml + ", pdf=" + pdf + ", vendaLojaVirtual=" + vendaLojaVirtual + "]";
	}
	
	

}
