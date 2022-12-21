package com.prototype.api.dto;

import com.prototype.domain.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDto {
	private String nome;
	private String cpf;
	private Endereco endereco;
	
}
