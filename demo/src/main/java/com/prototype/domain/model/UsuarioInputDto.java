package com.prototype.domain.model;

import lombok.Getter;


public class UsuarioInputDto {

	@Getter
	private String nome;
	
	public Usuario toEntity() {
		return new Usuario(nome);
	}
}
