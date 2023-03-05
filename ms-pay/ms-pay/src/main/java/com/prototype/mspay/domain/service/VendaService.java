package com.prototype.mspay.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prototype.mspay.api.dto.VendaDTO;
import com.prototype.mspay.api.infra.VendaResource;
import com.prototype.mspay.domain.exception.ErroComunicacaoException;
import com.prototype.mspay.domain.exception.NotFounEntityException;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendaService {

	private final VendaResource vendaResource;

	public VendaDTO getVenda(Long codigo) {
		try {
			return vendaResource.findVendaById(codigo).getBody();
		} catch (FeignException e) {
			validarStatusServico(codigo, e);
		}
		// TODO tratar
		return null;
	}
	
	public void gerarNotaPagamento(Long idVenda) {
		try {
			vendaResource.gerarNf(idVenda);
		} catch (FeignException e) {
			validarStatusServico(idVenda, e);
		}
	}

	private void validarStatusServico(Long idVenda, FeignException e) {
		if (HttpStatus.NOT_FOUND.value() == e.status()) {
			throw new NotFounEntityException("Não foi encontrado uma venda com o codigo " + idVenda);
		}
		throw new ErroComunicacaoException(e.getMessage() + String.valueOf(e.status()));
	}
}
