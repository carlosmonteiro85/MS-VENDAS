package com.prototype.api.dto;

import com.prototype.domain.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDto {
	private Long id;
	private String nome;
	
	public static  UsuarioOutputDto toDTO (Usuario usuario) {
		return new UsuarioOutputDto(usuario.getId(), usuario.getNome());
	}
}
