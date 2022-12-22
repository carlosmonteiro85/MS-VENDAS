package com.prototype.api.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ProdutoRequest {
	@Setter
	@Getter
	private String nome;
	@Setter
	@Getter
	private String descricao;
	@Setter
	@Getter
	private BigDecimal preco;
	@Setter
	@Getter
	private String codigo ;
}
