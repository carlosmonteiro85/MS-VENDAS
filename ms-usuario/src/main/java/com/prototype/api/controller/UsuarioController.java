package com.prototype.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.api.dto.UsuarioInputDto;
import com.prototype.api.dto.UsuarioOutputDto;
import com.prototype.domain.service.UsuarioService;
import com.prototype.domain.util.AppConstants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	private final UsuarioService service;

	@GetMapping()
	public ResponseEntity<Page<UsuarioOutputDto>> findPaginated(
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_NUMERO_PAGINA, required = false) int page, 
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_TOTAL_PAGINA, required = false) int size,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_POR, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECAO, required = false) String sortDir) {
	    return ResponseEntity.ok(service.findAll(page, size, sortBy, sortDir));
	}
	
	@PostMapping()
	public ResponseEntity<UsuarioOutputDto> saveUser(@RequestBody UsuarioInputDto usuarioInput) {
		return ResponseEntity.ok().body(service.save(usuarioInput));
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<UsuarioOutputDto> getUsuario(@RequestParam("cpf") String cpf) {
		return ResponseEntity.ok().body(service.findByCpf(cpf));
	}
}
