package com.prototype;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prototype.api.dto.UsuarioInputDto;
import com.prototype.api.dto.UsuarioOutputDto;
import com.prototype.domain.model.Endereco;
import com.prototype.domain.service.UsuarioService;

class UsuarioPersistence extends DemoApplicationTests{
	
	@Autowired
	private UsuarioService service;
	private UsuarioInputDto usuario;
	private Endereco endereco;
	
	@BeforeEach
	void antesDosTestes() {
		usuario = criarUsuario();
		endereco = criarEndereco();
		usuario.setEndereco(endereco);
	}
	
	@Test
	void salvarUsuario() {
		UsuarioOutputDto usuarioPersisted = service.save(usuario);
		assertNotNull(usuarioPersisted.getId());
	}

}
