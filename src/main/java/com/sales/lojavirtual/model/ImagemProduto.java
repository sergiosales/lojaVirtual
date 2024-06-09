package com.sales.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

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
@Table(name = "imagem_produtos")
@SequenceGenerator(name = "seq_imgprodutos",sequenceName ="seq_imgprodutos",initialValue = 1,allocationSize = 1 )
public class ImagemProduto implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator ="seq_imgprodutos" )
	private Long id;
	
	private String imagemOriginal;
	
	private String imagemMiniaturar;
	
	@ManyToOne
	@JoinColumn(name = "produto_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "produto_fk"))
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagemOriginal() {
		return imagemOriginal;
	}

	public void setImagemOriginal(String imagemOriginal) {
		this.imagemOriginal = imagemOriginal;
	}

	public String getImagemMiniaturar() {
		return imagemMiniaturar;
	}

	public void setImagemMiniaturar(String imagemMiniaturar) {
		this.imagemMiniaturar = imagemMiniaturar;
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
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ImagemProduto [id=" + id + ", imagemOriginal=" + imagemOriginal + ", imagemMiniaturar="
				+ imagemMiniaturar + ", produto=" + produto + "]";
	}
	
	
}
