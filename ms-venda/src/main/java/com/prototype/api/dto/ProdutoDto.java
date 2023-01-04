package com.prototype.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoDto {
	private String nome;
	private BigDecimal preco;
	private String codigo ;
}
