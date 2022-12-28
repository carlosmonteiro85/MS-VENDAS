package com.prototype.domain;

import java.math.BigDecimal;
import java.util.List;

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
import com.prototype.domain.repository.VendasRepository;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendaService {

	private final ProdutoResource produtoResource;
	private final VendasRepository vendaRepository;

	public Venda abrirVenda() {
		return vendaRepository.save(new Venda());
	}

	// TODO buscar dados da fila de nota
	public void cancelarVenda(Long idVenda) {
		
		Venda venda = buscarVendoPeloid(idVenda);
		
		// TODO Gerar nota cancelamento
		venda.setStatus(StatusEnum.CANCELADA);
		venda.getItens().clear();
	}

	public void fecharVenda(Venda venda) {
		// TODO obter Nota gerada
		venda.setStatus(StatusEnum.FECHADA);
	}

	// TODO enviar dados para a fila de gerar nota
	public void gerarNotaVenda(Venda venda) {
		// TODO obter dados frete
		// TODO obter dados usuario
		// TODO gerar arquivo xml
		// TODO enviar dados venda em xml
		venda.setStatus(StatusEnum.FECHADA);
	}

	public void removerItem(Long idVenda, String codigoProduto) {
		
		Venda venda = buscarVendoPeloid(idVenda);
		
		validarStatusVenda(venda);
		
		Item itemRemover = null;
		
		for (int i = 0; venda.getItens().size() >= i; i++) {
			Item item = venda.getItens().get(i);
			if (item.getCodigoProduto().equals(codigoProduto)) {
				itemRemover = item;
				break;
			}
			
			if (Utils.isNull(itemRemover)) {
				throw new NotFounEntityException("Não existe um item com o codigo " + codigoProduto + " na lista");
			}
			
			venda.getItens().remove(itemRemover);
		}
		
		somarTotal(venda);
		vendaRepository.save(venda);
	}

	public void adicionarItem(Long idVenda, String codigoProduto, Integer quantidade) {
		
		Venda venda = buscarVendoPeloid(idVenda);
		
		validarStatusVenda(venda);
		
		boolean naoPossueItem = verificarSePossueItem(venda.getItens(), codigoProduto, quantidade);
		
		if (naoPossueItem) {
			Item item = montarItem(codigoProduto, quantidade);
			venda.getItens().add(item);
		}
		
		somarTotal(venda);
		vendaRepository.save(venda);
	}

	private boolean verificarSePossueItem(List<Item> itens, String codigoProduto, int qtn) {
		boolean naoPossueItem = true;
		for (Item itemList : itens) {
			if (itemList.getCodigoProduto().equals(codigoProduto)) {
				int qt = itemList.getQuantidade() + qtn;
				itemList.setQuantidade(qt < 0 ? 0 : qt);
				naoPossueItem = false;
				break;
			}
		}
		return naoPossueItem;
	}

	private void validarStatusVenda(Venda venda) {
		if (!venda.getStatus().equals(StatusEnum.ABERTA)) {
			throw new NegocioException(
					"Não é possivel adicionar ou remover item desta venda, pois o status esta " + venda.getStatus());
		}
	}

	private Item montarItem(String codigoProduto, Integer quantidade) {
		try {
			ResponseEntity<ProdutoDto> dadosProduto = produtoResource.dadosProduto(codigoProduto);
			return ItemDto.builder().produto(dadosProduto.getBody()).quantidade(quantidade).build().toEntity();

		} catch (FeignClientException e) {
			if (HttpStatus.NOT_FOUND.value() == e.status()) {
				throw new NotFounEntityException("Não foi encontrado um produto com o código: " + codigoProduto);
			}
			throw new ErroComunicacaoException(e.getMessage() + String.valueOf(e.status()));
		}
	}

	private void somarTotal(Venda venda) {
		for (Item item : venda.getItens()) {
			BigDecimal t1 = item.getValorItem().multiply(new BigDecimal(item.getQuantidade()));
			venda.getTotal().add(t1);
		}
	}

	public Venda buscarVendoPeloid(Long idVenda) {
		return vendaRepository.findById(idVenda)
				.orElseThrow(() -> new NotFounEntityException("Não foi encontrado uma venda com o codigo " + idVenda));
	}
}
