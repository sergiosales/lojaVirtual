package com.sales.lojavirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
@Embeddable
public class PessoaJuridica extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String cnpj;
	
	@Column(nullable = false)
	private String insEstadual;
	
	private String insMunicipal;
	
	@Column(nullable = false)
	private String nomeFantasia;
	
	@Column(nullable = false)
	private String razaoSocial;	

	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInsEstadual() {
		return insEstadual;
	}
	public void setInsEstadual(String insEstadual) {
		this.insEstadual = insEstadual;
	}
	public String getInsMunicipal() {
		return insMunicipal;
	}
	public void setInsMunicipal(String insMunicipal) {
		this.insMunicipal = insMunicipal;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
	
	
	

}
