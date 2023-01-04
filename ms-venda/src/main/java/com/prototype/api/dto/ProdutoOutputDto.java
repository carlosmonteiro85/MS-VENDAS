package com.prototype.api.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoOutputDto {
	private String nome;
	private BigDecimal preco;
	private String codigo ;
}
