package com.prototype.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prototype.api.dto.ItemDto;
import com.prototype.api.dto.ProdutoDto;
import com.prototype.api.infra.ProdutoResource;
import com.prototype.domain.exception.ErroComunicacaoException;
import com.prototype.domain.exception.NotFounEntityException;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	private final ProdutoResource produtoResource;
	
	public ItemDto montarItem(String codigoProduto, Integer quantidade) {
		try {
			ProdutoDto produto = produtoResource.dadosProduto(codigoProduto).getBody();
			return new ItemDto(produto, quantidade);
			
		} catch (FeignClientException e) {
			if (HttpStatus.NOT_FOUND.value() == e.status()) {
				throw new NotFounEntityException("Não foi encontrado um produto com o código: " + codigoProduto);
			}
			throw new ErroComunicacaoException(e.getMessage() + String.valueOf(e.status()));
		}
	}
}
