package com.sales.lojavirtual.enums;



public enum StatusContaPagar {
	
	COBRANÇA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada"),
	NEGOCIADA("Renegociada");
	
	private String descricao;
	
	private StatusContaPagar(String descricao) {
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
