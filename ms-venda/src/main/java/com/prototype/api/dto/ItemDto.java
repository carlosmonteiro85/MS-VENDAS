package com.prototype.api.dto;

import com.prototype.domain.model.Item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
	private ProdutoDto produto;
	private Integer quantidade;
	
	
	public Item toEntity() {
		return new Item(produto.getCodigo(), produto.getNome(), quantidade, produto.getPreco());
	}
}
