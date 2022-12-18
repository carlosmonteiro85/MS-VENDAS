package com.prototype.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.api.dto.UsuarioOutputDto;
import com.prototype.domain.model.Usuario;
import com.prototype.domain.model.UsuarioInputDto;
import com.prototype.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("teste")
public class ControllerTeste {
	
	private final UsuarioRepository repository;

	@GetMapping
	public String teste() {
		return "ola mundo";
	}
	
	@PostMapping("save")
	public ResponseEntity<UsuarioOutputDto> saveUser(@RequestBody UsuarioInputDto usuarioInput) {
		
		Usuario entity = usuarioInput.toEntity();
		repository.save(entity);
		
		return ResponseEntity.ok().body(UsuarioOutputDto.toDTO(entity));
	}
	
}
