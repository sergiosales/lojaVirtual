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
@Table(name = "avaliacao_produto")
public class AvaliacaoProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer nota;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne()
	@JoinColumn(name = "produto_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "produt_fk" ))
	private Produto produto;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "pessoas_fk" ))
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		AvaliacaoProduto other = (AvaliacaoProduto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AvaliacaoProduto [id=" + id + ", nota=" + nota + ", descricao=" + descricao + ", produto=" + produto
				+ ", pessoa=" + pessoa + "]";
	}
	
	
	
	
	

}
