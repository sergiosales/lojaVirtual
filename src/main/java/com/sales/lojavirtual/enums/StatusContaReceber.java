package com.sales.lojavirtual.enums;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

public enum StatusContaReceber {
	
	COBRANÇA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada");
	
	private String descricao;
	
	private StatusContaReceber(String descricao) {
	 this.descricao= descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	 @Override
	public String toString() {
		return this.descricao;
	}


}
