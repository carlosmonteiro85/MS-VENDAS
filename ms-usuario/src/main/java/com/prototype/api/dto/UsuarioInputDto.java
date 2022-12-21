package com.prototype.api.dto;

import com.prototype.domain.model.Endereco;

import lombok.Getter;
import lombok.Setter;


public class UsuarioInputDto {
	@Setter
	@Getter
	private String nome;
	@Setter
	@Getter
	private String cpf;
	@Setter
	@Getter
	private Endereco endereco;
}
