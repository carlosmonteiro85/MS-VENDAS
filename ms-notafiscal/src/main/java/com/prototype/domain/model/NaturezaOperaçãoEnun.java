package com.prototype.domain.model;

import lombok.Getter;

public enum NaturezaOperaçãoEnun {
	
	VENDA("Venda"), DEVOLUCAO("Devolução"), DOACAO("Doação");
	
	@Getter
	private String descricao;
	
	private NaturezaOperaçãoEnun(String descricao) {
		this.descricao = descricao;
	}

}
