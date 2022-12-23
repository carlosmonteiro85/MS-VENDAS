package com.prototype.domain;

import java.util.Iterator;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prototype.api.dto.ItemDto;
import com.prototype.api.dto.ProdutoDto;
import com.prototype.api.infra.ProdutoResource;
import com.prototype.domain.exception.ErroComunicacaoException;
import com.prototype.domain.exception.NegocioException;
import com.prototype.domain.exception.NotFounEntityException;
import com.prototype.domain.model.Item;
import com.prototype.domain.model.Venda;
import com.prototype.domain.model.enuns.StatusEnum;
import com.prototype.domain.util.Utils;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendaService {
	
	private final ProdutoResource produtoResource;
	
	// TODO abrir venda 
	// TODO remover Item
	// TODO efetuar pagamento
	// TODO gerar nota
	// TODO fechar venda
	// TODO cancelar venda
	
	public void removerItem(Venda venda, String codigoProduto) {
		
		validarStatusVenda(venda);	
		
		Item itemRemover = null;
		
		for(int i = 0; venda.getItens().size() >= i; i++ ) {
			
			Item item = venda.getItens().get(i);
			
			if (item.getCodigoProduto().equals(codigoProduto)) {
				itemRemover = item;
				break;
			}
			if(Utils.isNull(itemRemover)) {
				throw new NotFounEntityException("Não existe um item com o codigo " + codigoProduto + " na lista");
			}
			
			venda.getItens().remove(itemRemover);
		}
	}
	
	public void adicionarItem(Venda venda, String codigoProduto, Integer quantidade) {
		validarStatusVenda(venda);	
		Item item = montarItem(codigoProduto, quantidade);
		venda.getItens().add(item);
		//TODO desenvolver
		
		venda.getItens().contains(item);
		
		for ( Item itemList : venda.getItens()) {
			if(itemList.getCodigoProduto().equals(codigoProduto)) {
				itemList.setQuantidade( itemList.getQuantidade() + item.getQuantidade());
			}
		}
		
	}

	private void validarStatusVenda(Venda venda) {
		if(!venda.getStatus().equals(StatusEnum.ABERTA) ) {
			throw new NegocioException("Não é possivel adicionar ou remover item desta venda, pois o status esta " + venda.getStatus());
		}
	}

	private Item montarItem(String codigoProduto, Integer quantidade) {
		try {
			ResponseEntity<ProdutoDto> dadosProduto = produtoResource.dadosProduto(codigoProduto);
			return ItemDto.builder()
						.produto(dadosProduto.getBody())
						.quantidade(quantidade)
						.build().toEntity();

		} catch (FeignClientException e) {
			if (HttpStatus.NOT_FOUND.value() == e.status()) {
				throw new NotFounEntityException("Não foi encontrado um produto com o código: " + codigoProduto);
			}
			throw new ErroComunicacaoException(e.getMessage() + String.valueOf(e.status()));
		}
	}
}
