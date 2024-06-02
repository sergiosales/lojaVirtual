package com.sales.lojavirtual.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
@Embeddable
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

}
