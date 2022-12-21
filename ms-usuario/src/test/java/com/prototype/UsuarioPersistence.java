package com.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prototype.api.dto.UsuarioInputDto;
import com.prototype.api.dto.UsuarioOutputDto;
import com.prototype.core.modelmapper.MapperConverter;
import com.prototype.domain.exception.EntidadeDuplicadaException;
import com.prototype.domain.exception.NotFounEntityException;
import com.prototype.domain.model.Endereco;
import com.prototype.domain.model.Usuario;
import com.prototype.domain.repository.UsuarioRepository;
import com.prototype.domain.service.UsuarioService;

class UsuarioPersistence extends DemoApplicationTests {

	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	MapperConverter map;

	private UsuarioInputDto usuario;
	private Endereco endereco;

	@BeforeEach
	void antesDosTestes() {
		usuario = criarUsuario();
		endereco = criarEndereco();
		usuario.setEndereco(endereco);
	}

	@AfterEach
	void depoisDosTestes() {
		repository.deleteAll();
	}

	@Test
	void salvarUsuario() {
		UsuarioOutputDto usuarioPersisted = service.save(usuario);
		assertNotNull(usuarioPersisted.getCpf());
	}

	@Test
	void lancarExcecaoAosalvarUsuarioComCpfExistente() {
		String erroEsperado = "Já exist um usuario com o cpf " + usuario.getCpf() + " cadastrado.";
		repository.save(map.dtoToentidade(usuario, Usuario.class));
		UsuarioInputDto usuarioDois = criarUsuario();
		usuarioDois.setCpf(usuario.getCpf());
		
		EntidadeDuplicadaException erro = assertThrows(EntidadeDuplicadaException.class, () -> service.save(usuario));
		
		assertNotNull(erro);
		assertEquals(erro.getMessage(), erroEsperado);
	}
	
	@Test
	void obterUsuarioPeloCpf() {
		service.save(usuario);
		
		UsuarioOutputDto usuarioRecuperado = service.findByCpf(usuario.getCpf());
		
		assertNotNull(usuarioRecuperado);
	}
	
	@Test
	void lancarExcecaoAoBuscarUsuarioComCpfInexistente() {
		
		String erroEsperado = "Não existe um usuario com o cpf informado.";
		String cpf = usuario.getCpf();
		repository.deleteAll();

		NotFounEntityException erro = assertThrows(NotFounEntityException.class, () -> service.findByCpf(cpf));
		
		assertNotNull(erro);
		assertEquals(erro.getMessage(), erroEsperado);
	}
}
