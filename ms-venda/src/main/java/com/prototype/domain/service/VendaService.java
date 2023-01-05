package com.prototype.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.prototype.api.dto.ItemDto;
import com.prototype.api.dto.UsuarioResponsavelDTO;
import com.prototype.api.dto.VendaDTO;
import com.prototype.core.modelmapper.MapperConverter;
import com.prototype.domain.exception.NegocioException;
import com.prototype.domain.exception.NotFounEntityException;
import com.prototype.domain.model.Item;
import com.prototype.domain.model.Venda;
import com.prototype.domain.model.enuns.StatusEnum;
import com.prototype.domain.repository.VendasRepository;
import com.prototype.domain.util.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendaService {

	private final ProdutoService produtoService;
	private final VendasRepository vendaRepository;
	private final ClienteService clienteService;
	private final MapperConverter mapper;

	public VendaDTO abrirVenda(String cpfCliente) {
		UsuarioResponsavelDTO cliente = clienteService.buscarDadosCliente(cpfCliente);

		Venda venda = validarVenda(cliente);

		VendaDTO vendaDTO = mapper.entidadeToDto(venda, VendaDTO.class);

		return vendaDTO;
	}

	private Venda validarVenda(UsuarioResponsavelDTO cliente) {
		Venda venda = vendaRepository.obterVendaPorStatusECpfCliente(cliente.getCpf(), StatusEnum.ABERTA)
				.orElse(new Venda(cliente));

		if (Objects.isNull(venda.getId())) {
			vendaRepository.save(venda);
		}
		return venda;
	}

	public VendaDTO adicionarItem(Long idVenda, String codigoProduto, Integer quantidade) {

		Venda venda = vendaRepository.findById(idVenda).orElseThrow(
				() -> new NotFounEntityException("Não foi possível encontrar uma venda com o id: " + idVenda));

		validarStatusVenda(venda);

		boolean naoPossueItem = verificarSePossueItem(venda.getItens(), codigoProduto, quantidade);

		if (naoPossueItem) {
			ItemDto itemDTO = produtoService.montarItem(codigoProduto, quantidade);
			venda.getItens().add(mapper.dtoToentidade(itemDTO, Item.class));
		}
		// TODO adicionar o somar frete
		somarTotal(venda);
		vendaRepository.save(venda);

		return mapper.entidadeToDto(venda, VendaDTO.class);
	}

	private boolean verificarSePossueItem(List<Item> itens, String codigoProduto, int qtn) {
		boolean naoPossueItem = true;
		for (Item itemList : itens) {
			if (itemList.getProduto().getCodigo().equals(codigoProduto)) {
				int qt = itemList.getQuantidade() + qtn;
				itemList.setQuantidade(qt < 0 ? 0 : qt);
				naoPossueItem = false;
				break;
			}
		}
		return naoPossueItem;
	}

	public VendaDTO removerItem(Long idVenda, String codigoProduto) {

		Venda venda = vendaRepository.findById(idVenda)
				.orElseThrow(() -> new NotFounEntityException("Não foi encontrado uma venda com o id: " + idVenda));

		validarStatusVenda(venda);
		
		Item itemRemover = null;
		
		for (int i = 0; venda.getItens().size() > i; i++) {
			
			Item item = venda.getItens().get(i);
			
			if (item.getProduto().getCodigo().equals(codigoProduto)) {
				itemRemover = item;
				
				venda.getItens().remove(itemRemover);
				
				somarTotal(venda);
				
				vendaRepository.save(venda);
			}
		}
		
		if (Utils.isNull(itemRemover)) {
			throw new NotFounEntityException("Não existe um item com o codigo " + codigoProduto + " na lista");
		}
		
		return mapper.entidadeToDto(venda, VendaDTO.class); 
	}

	public void cancelarVenda(Venda venda) {
		// TODO Gerar nota cancelamento
		venda.setStatus(StatusEnum.CANCELADA);
		venda.getItens().clear();
	}

	public void fecharVenda(Venda venda) {
		// TODO obter Nota gerada
		venda.setStatus(StatusEnum.FECHADA);
	}

	public void gerarNotaVenda(Venda venda) {
		// TODO obter dados frete
		// TODO obter dados usuario
		// TODO gerar arquivo xml
		// TODO enviar dados venda em xml
		venda.setStatus(StatusEnum.FECHADA);
	}

	private void validarStatusVenda(Venda venda) {
		if (!venda.getStatus().equals(StatusEnum.ABERTA)) {
			throw new NegocioException(
					"Não é possivel adicionar ou remover item desta venda, pois o status esta " + venda.getStatus());
		}
	}

	private void somarTotal(Venda venda) {

		BigDecimal total = new BigDecimal(0);

		for (Item item : venda.getItens()) {
			BigDecimal t1 = item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade()));
			total = t1.add(total);

		}
		venda.setTotal(total);
	}
	
	public VendaDTO findById(Long idVenda) {
		Venda venda = vendaRepository.findById(idVenda).orElseThrow(() -> new NotFounEntityException("Não foi encontrado uma venda com o codigo " + idVenda));
		return mapper.entidadeToDto(venda, VendaDTO.class);
	}
}
