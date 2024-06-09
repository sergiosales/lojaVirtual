package com.sales.lojavirtual.model;

import java.io.Serializable;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacao_produto")
@SequenceGenerator(name = "seq_avaliacao_produto",sequenceName ="seq_avaliacao_produto",initialValue = 1,allocationSize = 1 )
public class AvaliacaoProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq_avaliacao_produto")
	private Long id;
	
	private Integer nota;
	private String descricao;
	
	@ManyToOne()
	@JoinColumn(name = "produto_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "produt_fk" ))
	private Produto produto;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id",nullable = false,
	foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "pessoa_fk" ))
	private Pessoa pessoa;
	

}
