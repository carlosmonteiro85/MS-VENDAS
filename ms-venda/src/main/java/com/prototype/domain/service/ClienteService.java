package com.prototype.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prototype.api.dto.UsuarioResponsavelDTO;
import com.prototype.api.infra.UsuarioResource;
import com.prototype.domain.exception.ErroComunicacaoException;
import com.prototype.domain.exception.NotFounEntityException;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final UsuarioResource usuarioResource;
	
	public UsuarioResponsavelDTO buscarDadosCliente(String cpfCliente) {
		try {
			return usuarioResource.getUsuario(cpfCliente).getBody();
		} catch (FeignClientException e) {
			if (HttpStatus.NOT_FOUND.value() == e.status()) {
				throw new NotFounEntityException("Não foi encontrado um cliente com o cpf: " + cpfCliente);
			}
			throw new ErroComunicacaoException(e.getMessage() + String.valueOf(e.status()));
		}
	} 
}
